package com.top1.mimicodecustomrestarttitle.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TitleUtil {

    /**
     * Title utils
     */

    public static void sendTitle(CommandSender sender, String title, String subtitle) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendTitle(
                    ChatColor.translateAlternateColorCodes('&', title),
                    ChatColor.translateAlternateColorCodes('&', subtitle),
                    10, 70, 20
            );
        }
    }
}
