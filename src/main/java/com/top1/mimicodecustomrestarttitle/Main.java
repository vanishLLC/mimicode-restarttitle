package com.top1.mimicodecustomrestarttitle;

import com.top1.mimicodecustomrestarttitle.commands.RestartTitleCommand;
import com.top1.mimicodecustomrestarttitle.config.Config;
import com.top1.mimicodecustomrestarttitle.event.RestartEvent;
import com.top1.mimicodecustomrestarttitle.tab.RestartTitleTAB;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    /**
     * Main
     */

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        if (!this.getDescription().getName().equals("Plugin na custom title dla gracza podczas restarotwania serwera!")
                && !this.getDescription().getAuthors().contains("MimiCode")
                && !this.getDescription().getName().contains("Mimicode-CustomRestartTitle")
                && !this.getDescription().getMain().contains("com.top1.mimicodecustomrestarttitle.Main")
                && !this.getDescription().getWebsite().equals("dsc.gg/mimicode")) {
            this.getLogger().warning("Wykryto nieupoważnioną zmianę danych w plugin.yml w wyniku czego plugin zostaje wyłączony. Prosimy o zmianę danych na prawidłowe. Jeśli to błąd - skontaktuj się z nami na Discordzie: https://discord.gg/weHSn6Bhjd / dsc.gg/mimicode");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getServer().getPluginManager().registerEvents(new RestartEvent(), this);
        getCommand("restarttitle").setExecutor(new RestartTitleCommand());
        getCommand("restarttitle").setTabCompleter(new RestartTitleTAB());
        Config.setupConfig();

        getLogger().info("[=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=]");
        getLogger().info("|                                             |");
        getLogger().info("|         Mimicode-CustomRestartTitle         |");
        getLogger().info("|               Jest włączony!                |");
        getLogger().info("|                                             |");
        getLogger().info("[=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=]");
    }

    @Override
    public void onDisable() {
    }

    public static Main getInstance() {
        return instance;
    }
}
