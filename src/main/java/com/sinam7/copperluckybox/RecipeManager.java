package com.sinam7.copperluckybox;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeManager {

    public static final List<ItemStack> luckyBoxes = new ArrayList<>();
    @Getter
    private static final Map<String, ItemStack> itemStackMap = new HashMap<>();


    public static void init() {
        addCopperLuckyBox();
        addIronLuckyBox();
        addGoldLuckyBox();
        addDiamondLuckyBox();
        addEmeraldLuckyBox();

    }

    public static void addCopperLuckyBox() {
        // create new ItemStack with enchanted copper block
        ItemStack copperbox = new ItemStack(Material.COPPER_BLOCK);
        renameBox(copperbox, Constants.copperLuckyBox, Constants.copperLuckyBoxColor);
        getMaterialLuckyBox(copperbox, Constants.luckyBoxCopperItemKey, Material.RAW_COPPER);
    }

    public static void addIronLuckyBox() {
        // create new ItemStack with enchanted iron block
        ItemStack ironbox = new ItemStack(Material.IRON_BLOCK);
        renameBox(ironbox, Constants.ironLuckyBox, Constants.ironLuckyBoxColor);
        getMaterialLuckyBox(ironbox, Constants.luckyBoxIronItemKey, Material.IRON_INGOT);
    }

    // create method with add a recipe with 8 copper ingots surrounding one gold ingot
    public static void addGoldLuckyBox() {
        // create new ItemStack with enchanted gold block
        ItemStack goldbox = new ItemStack(Material.GOLD_BLOCK);
        renameBox(goldbox, Constants.goldLuckyBox, Constants.goldLuckyBoxColor);
        getMaterialLuckyBox(goldbox, Constants.luckyBoxGoldItemKey, Material.GOLD_INGOT);
    }

    public static void addDiamondLuckyBox() {
        // create new ItemStack with enchanted diamond block
        ItemStack diamondbox = new ItemStack(Material.DIAMOND_BLOCK);
        renameBox(diamondbox, Constants.diamondLuckyBox, Constants.diamondLuckyBoxColor);
        getMaterialLuckyBox(diamondbox, Constants.luckyBoxDiamondItemKey, Material.DIAMOND);
    }


    public static void addEmeraldLuckyBox() {
        // create new ItemStack with enchanted emerald block
        ItemStack emeraldbox = new ItemStack(Material.EMERALD_BLOCK);
        renameBox(emeraldbox, Constants.emeraldLuckyBox, Constants.emeraldLuckyBoxColor);
        getMaterialLuckyBox(emeraldbox, Constants.luckyBoxEmeraldItemKey, Material.EMERALD);
    }

    private static void renameBox(ItemStack luckybox, String boxName, String hexcode) {
        ItemMeta itemMeta = luckybox.getItemMeta();
        itemMeta.displayName(Component.text(boxName, Style.style(TextColor.fromHexString(hexcode))));
        luckybox.setItemMeta(itemMeta);
    }

    private static void getMaterialLuckyBox(ItemStack box, String itemKey, Material specificMaterial) {
        box.addUnsafeEnchantment(org.bukkit.enchantments.Enchantment.LUCK, 1);

        // hide enchantment to item
        box.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS);

        // create new shaped recipe
        ShapedRecipe luckyboxRecipe = new ShapedRecipe(NamespacedKey.minecraft(itemKey), box)
                .shape("AAA", "ABA", "AAA")
                .setIngredient('A', Material.COPPER_INGOT)
                .setIngredient('B', specificMaterial);
        luckyBoxes.add(box);
        itemStackMap.put(itemKey, box);
        Bukkit.getServer().addRecipe(luckyboxRecipe);

    }


    public static ItemStack getLuckyBox(String boxkey) {
        return itemStackMap.get(boxkey);
    }
}
