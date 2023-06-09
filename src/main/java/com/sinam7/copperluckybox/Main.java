package com.sinam7.copperluckybox;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

// create new minecraft java plugin project
public class Main extends JavaPlugin {
    // onEnable() is called when the plugin is enabled
    @Override
    public void onEnable() {
        // print to console
        getLogger().info("Hello, Minecraft!");
        Objects.requireNonNull(getCommand("clb")).setExecutor(new CommandManager());
        getServer().getPluginManager().registerEvents(new EventManager(), this);

        RecipeManager.init();
        ConfigManager.init(this);
        ConfigManager.loadConfig();
        LuckyBox.init();
    }

}
