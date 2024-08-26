package com.top1.mimicodecustomrestarttitle.event;

import com.top1.mimicodecustomrestarttitle.Main;
import com.top1.mimicodecustomrestarttitle.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.entity.Player;

public class RestartEvent implements Listener {

    /**
     * Restart Event
     */

    @EventHandler
    public void onServerCommand(ServerCommandEvent event) {
        String command = event.getCommand().toLowerCase();
        if (command.equals("restart") || command.equals("stop")) {
            String line1 = Main.getInstance().getConfig().getString("restart-message.line1");
            String line2 = Main.getInstance().getConfig().getString("restart-message.line2");
            String line3 = Main.getInstance().getConfig().getString("restart-message.line3");
            String line4 = Main.getInstance().getConfig().getString("restart-message.line4");

            String fullMessage = String.join("\n",
                    MessageUtil.colorize(line1),
                    MessageUtil.colorize(line2),
                    MessageUtil.colorize(line3),
                    MessageUtil.colorize(line4));

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.kickPlayer(fullMessage);
            }
        }
    }
}
