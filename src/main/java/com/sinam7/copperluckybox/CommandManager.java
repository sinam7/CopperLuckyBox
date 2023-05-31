package com.sinam7.copperluckybox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 1) {
                int i;
                try {
                    i = Integer.parseInt(args[0]);
                    for (int j = 0; j < i; j++) {
                        RecipeManager.luckyBoxes.forEach(luckyBox -> player.getInventory().addItem(luckyBox));
                    }
                } catch (NumberFormatException e) {
                    RecipeManager.luckyBoxes.forEach(luckyBox -> player.getInventory().addItem(luckyBox));
                }

                return true;
            }
            RecipeManager.luckyBoxes.forEach(luckyBox -> player.getInventory().addItem(luckyBox));
            return true;
        }
        return false;
    }

}

