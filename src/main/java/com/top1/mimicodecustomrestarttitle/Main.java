package com.top1.mimicodecustomrestarttitle;

import com.top1.mimicodecustomrestarttitle.commands.RestartTitleCommand;
import com.top1.mimicodecustomrestarttitle.config.Config;
import com.top1.mimicodecustomrestarttitle.event.RestartEvent;
import com.top1.mimicodecustomrestarttitle.tab.RestartTitleTAB;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    private static final String PLUGIN_NAME = "Mimicode-CustomRestartTitle";
    private static final String COMMAND_NAME = "restarttitle";
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        if (!validatePluginInfo()) {
            disablePlugin();
            return;
        }

        getServer().getPluginManager().registerEvents(new RestartEvent(), this);
        getCommand(COMMAND_NAME).setExecutor(new RestartTitleCommand());
        getCommand(COMMAND_NAME).setTabCompleter(new RestartTitleTAB());
        Config.setupConfig();

        logStartupMessage();
    }

    @Override
    public void onDisable() {
    }

    public static Main getInstance() {
        return instance;
    }

    private boolean validatePluginInfo() {
        return this.getDescription().getName().contains(PLUGIN_NAME)
                && this.getDescription().getAuthors().contains("MimiCode")
                && this.getDescription().getMain().contains("com.top1.mimicodecustomrestarttitle.Main")
                && this.getDescription().getWebsite().equals("dsc.gg/mimicode");
    }

    private void disablePlugin() {
        this.getLogger().warning("Wykryto nieupoważnioną zmianę danych w plugin.yml w wyniku czego plugin zostaje wyłączony. Prosimy o zmianę danych na prawidłowe. Jeśli to błąd - skontaktuj się z nami na Discordzie: https://discord.gg/weHSn6Bhjd / dsc.gg/mimicode");
        Bukkit.getPluginManager().disablePlugin(this);
    }

    private void logStartupMessage() {
        String[] lines = {
                "[=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=]",
                "|                                             |",
                "|         Mimicode-CustomRestartTitle         |",
                "|               Jest włączony!                |",
                "|                                             |",
                "[=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=]"
        };
        for (String line : lines) {
            getLogger().info(line);
        }
    }
}