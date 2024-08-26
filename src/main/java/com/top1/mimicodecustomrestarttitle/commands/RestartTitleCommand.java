package com.top1.mimicodecustomrestarttitle.commands;

import com.top1.mimicodecustomrestarttitle.config.Config;
import com.top1.mimicodecustomrestarttitle.utils.MessageUtil;
import com.top1.mimicodecustomrestarttitle.utils.TitleUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RestartTitleCommand implements CommandExecutor {

    /**
     * Command
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("mimicode.restarttitle")) {
                Config.reloadConfig();
                MessageUtil.sendSucces(sender, "Config został pomyślnie przeładowany!");
            } else {
                MessageUtil.sendError(sender,"Brak permisji! &8(mimicode.restarttitle)");
                TitleUtil.sendTitle(sender, "&4Error", "&cBrak permisji!");
            }
            return true;
        } else {
            MessageUtil.sendError(sender, "Poprawne użycie: /restarttitle reload");
            return false;
        }
    }
}
