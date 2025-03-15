package org.ztkitpvp.ztKitPvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DamageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player) {
            if(strings.length == 0){
                commandSender.sendMessage(ChatColor.RED + "[Server] - Invalid Arguments");
                return false;
            }
            Player targetPlayer = Bukkit.getPlayer(strings[0]);
            if(targetPlayer == null || !targetPlayer.isOnline()){
                commandSender.sendMessage(ChatColor.RED + "[Server] - Player Not Found");
                return true;
            }
            try {
                double amount = Double.parseDouble(strings[1]);
                targetPlayer.damage(amount);
            } catch(Exception e){
                targetPlayer.damage(1);
            }

        } else {
            commandSender.sendMessage("This command can only be run by a player.");
            return false;
        }
        return true;
    }
}
