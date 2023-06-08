package me.samuel.launchpad.commands

import org.bukkit.entity.Player

interface CommandInterface {

    fun desc(): String
    fun commandArgs(player: Player, args: Array<out String>): List<String>
    fun execute(player: Player, args: Array<out String>?)

}