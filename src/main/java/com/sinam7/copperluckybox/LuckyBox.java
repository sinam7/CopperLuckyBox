package com.sinam7.copperluckybox;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class LuckyBox {

    public static Map<String, ItemStack> gifts = new HashMap<>();
    @Getter
    private static List<LuckyBox> boxList = new ArrayList<>();
    @Getter
    private static Map<ItemStack, LuckyBox> itemStackLuckyBoxMap = new HashMap<>();

    private final String name;
    private final Map<String, Double> chances;

    private double sum;

    private Map<Double, String> chanceTable = new LinkedHashMap<>();

    public static void init() {
        gifts.put("dirt", new ItemStack(Material.DIRT));
        gifts.put("gravel", new ItemStack(Material.GRAVEL));
        gifts.put("coal", new ItemStack(Material.COAL));
        gifts.put("iron_ingot", new ItemStack(Material.IRON_INGOT));
        gifts.put("gold_ingot", new ItemStack(Material.GOLD_INGOT));
        gifts.put("diamond", new ItemStack(Material.DIAMOND));
        gifts.put("emerald", new ItemStack(Material.EMERALD));
        gifts.put("cobblestone", new ItemStack(Material.COBBLESTONE));
        gifts.put("copper_ore", new ItemStack(Material.COPPER_ORE));
        gifts.put("diamond_block", new ItemStack(Material.DIAMOND_BLOCK));
        gifts.put("lucky_box_copper", RecipeManager.getLuckyBox("lucky_box_copper"));
        gifts.put("lucky_box_iron", RecipeManager.getLuckyBox("lucky_box_iron"));
        gifts.put("lucky_box_gold", RecipeManager.getLuckyBox("lucky_box_gold"));
        gifts.put("lucky_box_diamond", RecipeManager.getLuckyBox("lucky_box_diamond"));
        gifts.put("lucky_box_emerald", RecipeManager.getLuckyBox("lucky_box_emerald"));
    }

    public LuckyBox(String name, Map<String, Double> chances) {
        this.name = name;
        this.chances = chances;

        sum = 0;
        for (String gift : chances.keySet()) {
            sum += chances.get(gift);
            chanceTable.put(sum, gift);
        }
    }

    // use lucky box and get a gift by chances map
    public String useBox() {
        double random = Math.random() * sum;
        for (double chance : chanceTable.keySet()) {
            if (random <= chance) {
                return chanceTable.get(chance);
            }
        }
        return null;
    }
}
