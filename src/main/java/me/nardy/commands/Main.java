package me.nardy.commands;

import me.nardy.commands.cmds.CountNearbyEntities;
import me.nardy.commands.cmds.FeedAnimals;
import me.nardy.commands.cmds.GoHome;
import me.nardy.commands.cmds.WhistleMob;
import me.nardy.commands.cmds.warp.delwarp;
import me.nardy.commands.cmds.warp.setwarp;
import me.nardy.commands.cmds.warp.warp;
import me.nardy.commands.listeners.GoBed;
import me.nardy.commands.listeners.IfCatFed;
import me.nardy.commands.listeners.IfPlayerJoin;
import me.nardy.commands.listeners.WolfTarget;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("whistle").setExecutor(new WhistleMob(this));
        getServer().getPluginCommand("home").setExecutor(new GoHome(this));
        getServer().getPluginCommand("count").setExecutor(new CountNearbyEntities(this));
        getServer().getPluginCommand("setwarp").setExecutor(new setwarp(this));
        getServer().getPluginCommand("warp").setExecutor(new warp(this));
        getServer().getPluginCommand("delwarp").setExecutor(new delwarp(this));
        getServer().getPluginCommand("feed").setExecutor(new FeedAnimals(this));
        getServer().getPluginManager().registerEvents(new GoBed(), this);
        getServer().getPluginManager().registerEvents(new IfPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new IfCatFed(), this);
        getServer().getPluginManager().registerEvents(new WolfTarget(), this);
        loadConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    
    public void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveConfig();
    }
}
