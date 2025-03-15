package org.ztkitpvp.ztKitPvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if(commandSender instanceof Player){
            if(strings.length == 0){
                commandSender.sendMessage(ChatColor.RED + "[Server] - No Kit Selected\nType /kit help for kit selection");
                return false;
            }
            Player player = (Player)commandSender;

            switch(strings[0]){
                case "pvp":
                    this.giveKitPvp(player, commandSender);
                    break;
                case "help":
                    help(commandSender);
                    break;
                default:
                    commandSender.sendMessage(ChatColor.RED + "[Server] - Invalid Kit\n");
                    break;
            }

        }
        return true;
    }

    private void giveKitPvp(Player player, CommandSender commandSender){
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemStack chestplace = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack legging = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 8);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);

        player.getInventory().addItem(sword, helmet, chestplace, legging, boots, gapple, steak);
        commandSender.sendMessage(ChatColor.GREEN + "[Server] - Given Kit PVP!");
    }


    private void help(CommandSender commandSender){
        commandSender.sendMessage(ChatColor.MAGIC + "KITS:\n/kit pvp - the basics\n/kit archer - for bow kings\n");
    }
}
