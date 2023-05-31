package com.sinam7.copperluckybox;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Set;

public class ConfigManager {

    private static JavaPlugin plugin;

    public static void init(JavaPlugin plugin) {
        ConfigManager.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    // load config data from config.yml
    public static void loadConfig() {
        // get config.yml
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();

        // get config.yml data
        ConfigurationSection root = config.getConfigurationSection("luckybox");
        Set<String> keys = root.getKeys(false);
        for (String boxkey : keys) { // lucky_box_copper, lucky_box_iron, ...
            HashMap<String, Double> chanceMap = new HashMap<>();
            ConfigurationSection box = root.getConfigurationSection(boxkey);
            Set<String> giftkey = box.getKeys(false);
            for (String gift : giftkey) { // each gift in each box
                chanceMap.put(gift, box.getDouble(gift));
            }
            ItemStack luckyBox = RecipeManager.getLuckyBox(boxkey);
            LuckyBox value = new LuckyBox(boxkey, chanceMap);
            LuckyBox.getItemStackLuckyBoxMap().put(luckyBox, value);
            LuckyBox.getBoxList().add(new LuckyBox(boxkey, chanceMap));
        }
    }


}
