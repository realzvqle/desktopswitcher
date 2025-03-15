package org.ztkitpvp.ztKitPvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.setHealth(player.getMaxHealth());
            player.sendMessage(ChatColor.GREEN + "[Server] - You have been healed!");
            return true;
        } else {
            commandSender.sendMessage("This command can only be run by a player.");
            return false;
        }
    }
}
