package com.sinam7.copperluckybox;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventManager implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            LuckyBox luckyBox = isLuckyBox(item);
            if (luckyBox != null) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                item.setAmount(item.getAmount() - 1);
                String giftcode = luckyBox.useBox();
                if (giftcode != null) {
                    player.sendMessage("You got " + giftcode + "!");
                    player.getInventory().addItem(LuckyBox.gifts.get(giftcode));
                } else {
                    player.sendMessage("You got nothing!");
                }
            }
        }
    }

    private LuckyBox isLuckyBox(ItemStack item) {
        if (item == null) return null;

        for (ItemStack box : RecipeManager.luckyBoxes) {
            if (item.isSimilar(box)) {
                return LuckyBox.getItemStackLuckyBoxMap().get(box);
            }

        }
        return null;
    }


}
