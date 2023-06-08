package me.samuel.launchpad.commands.subcommands

import me.samuel.launchpad.commands.CommandInterface
import org.bukkit.entity.Player

class HelpCommand : CommandInterface {

    override fun desc(): String {
        return "Returns a list of the plugins commands and their usages."
    }

    override fun commandArgs(player: Player, args: Array<out String>): List<String> {
        TODO("Not yet implemented")
    }

    override fun execute(player: Player, args: Array<out String>?) {
        TODO("Not yet implemented")
    }
}