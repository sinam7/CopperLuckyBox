package com.sinam7.copperluckybox;

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
import java.util.List;

public class RecipeManager {

    public static final List<ItemStack> luckyBoxes = new ArrayList<>();

    public static void init() {
        addCopperLuckyBox();
        addIronLuckyBox();
        addGoldLuckyBox();
        addDiamondLuckyBox();
        addEmeraldLuckyBox();

    }

    // create method with add a recipe with 8 copper ingots surrounding one raw copper
    public static void addCopperLuckyBox() {
        // create new ItemStack with enchanted copper block
        ItemStack copperbox = new ItemStack(Material.COPPER_BLOCK);
        renameBox(copperbox, "Copper Lucky Box", "#e0729c");
        getMaterialLuckyBox(copperbox, "lucky_box_copper", Material.RAW_COPPER);
    }

    // create method with add a recipe with 8 copper ingots surrounding one iron ingot
    public static void addIronLuckyBox() {
        // create new ItemStack with enchanted iron block
        ItemStack ironbox = new ItemStack(Material.IRON_BLOCK);
        renameBox(ironbox, "Iron Lucky Box", "#d6c4fb");
        getMaterialLuckyBox(ironbox, "lucky_box_iron", Material.IRON_INGOT);
    }
    // create method with add a recipe with 8 copper ingots surrounding one gold ingot
    public static void addGoldLuckyBox() {
        // create new ItemStack with enchanted gold block
        ItemStack goldbox = new ItemStack(Material.GOLD_BLOCK);
        renameBox(goldbox, "Gold Lucky Box", "#ffec74");
        getMaterialLuckyBox(goldbox, "lucky_box_gold", Material.GOLD_INGOT);
    }

    public static void addDiamondLuckyBox() {
        // create new ItemStack with enchanted diamond block
        ItemStack diamondbox = new ItemStack(Material.DIAMOND_BLOCK);
        renameBox(diamondbox, "Diamond Lucky Box", "#28c4f4");
        getMaterialLuckyBox(diamondbox, "lucky_box_diamond", Material.DIAMOND);
    }

    public static void addEmeraldLuckyBox() {
        // create new ItemStack with enchanted emerald block
        ItemStack emeraldbox = new ItemStack(Material.EMERALD_BLOCK);
        renameBox(emeraldbox, "Emerald Lucky Box", "#26c669");
        getMaterialLuckyBox(emeraldbox, "lucky_box_emerald", Material.EMERALD);
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
        luckyBoxes.add(luckyboxRecipe.getResult());
        Bukkit.getServer().addRecipe(luckyboxRecipe);

    }


}
