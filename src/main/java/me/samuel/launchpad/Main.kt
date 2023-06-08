package me.samuel.launchpad

import me.samuel.launchpad.commands.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        registerCommands()
        registerListeners()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun registerCommands() {
        getCommand("launchpad")?.setExecutor(CommandManager())
    }

    private fun registerListeners() {

    }
}
