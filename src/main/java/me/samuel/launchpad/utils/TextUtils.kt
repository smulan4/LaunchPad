package me.samuel.launchpad.utils

import org.bukkit.ChatColor

class TextUtils {

    companion object {
        fun color(string: String): String {
            return ChatColor.translateAlternateColorCodes('&', string)
        }
    }

}