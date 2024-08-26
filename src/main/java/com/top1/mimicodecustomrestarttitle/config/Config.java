package com.top1.mimicodecustomrestarttitle.config;

import com.top1.mimicodecustomrestarttitle.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static void setupConfig() {

        /**
         * Config
         */

        Main plugin = Main.getInstance();
        FileConfiguration config = plugin.getConfig();

        config.addDefault("restart-message.line1", "&4RESTART SERWERA >_<");
        config.addDefault("restart-message.line2", "");
        config.addDefault("restart-message.line3", "&cZapewnie coś poprawiamy, więc uzbrój się w cierpliwość");
        config.addDefault("restart-message.line4", "&cCały przebieg restartu znajdziesz na &4dsc.gg/mimicode");

        config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    public static void reloadConfig() {
        Main.getInstance().reloadConfig();
    }
}
