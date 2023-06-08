package me.samuel.launchpad.commands

import me.samuel.launchpad.commands.subcommands.HelpCommand
import me.samuel.launchpad.commands.subcommands.ReloadCommand
import me.samuel.launchpad.utils.TextUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class CommandManager : CommandExecutor, TabCompleter {

    private val permission = "launchpad.use"
    private val permissionDenied = "&cPermission denied."
    private val unknownCommand = "&cUnknown subcommand. Use '/launchpad help'."

    private val commands: Map<String, CommandInterface> = mapOf (
        "help" to HelpCommand(),
        "reload" to ReloadCommand()
    )

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {

        if (sender !is Player) return true

        if (!sender.hasPermission(permission)) {
            sender.sendMessage(TextUtils.color(permissionDenied))
        }

        val enteredCommand = args?.getOrNull(0)?.toLowerCase()

        when (val cmd = commands[enteredCommand]) {
            null -> sender.sendMessage(TextUtils.color(unknownCommand))
            else -> cmd.execute(sender, args)
        }

        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>?): List<String>? {

        if (sender !is Player) return null

        return when(args?.size) {
            1 -> ArrayList(commands.keys)
            else -> {
                val commandName = args?.getOrNull(0)
                val cmd = commands[commandName]
                cmd?.commandArgs(sender, args!!)
            }
        }

    }

}