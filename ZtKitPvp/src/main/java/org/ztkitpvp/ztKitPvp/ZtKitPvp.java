package org.ztkitpvp.ztKitPvp;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.ztkitpvp.ztKitPvp.commands.DamageCommand;
import org.ztkitpvp.ztKitPvp.commands.HealCommand;
import org.ztkitpvp.ztKitPvp.commands.KitCommand;

import java.util.Objects;

public final class ZtKitPvp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        try{
            Objects.requireNonNull(this.getCommand("heal"), "Command 'heal' is not defined in plugin.yml").setExecutor(new HealCommand());
            Objects.requireNonNull(this.getCommand("damage"), "Command 'damage' is not defined in plugin.yml").setExecutor(new DamageCommand());
            Objects.requireNonNull(this.getCommand("kit"), "Command 'kit' is not defined in plugin.yml").setExecutor(new KitCommand());

        } catch(Exception e){
            getLogger().info("Something Failed, Exception" + e);
        }
    }



    @Override
    public void onDisable() {
        System.console().printf("Hi\n");
    }
}
