package me.nardy.commands.cmds.warp;

import me.nardy.commands.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class setwarp implements CommandExecutor {
    private final Main main;

    public setwarp(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0){
            p.sendMessage("Please enter warp name!");
            return true;
        }
        String name = args[0].toLowerCase();
        if (main.getConfig().get(name) != null) {
            p.sendMessage("There is already warp with that name!");
            return true;
        }
        Location loc = p.getLocation();
        main.getConfig().set("Warps." + name + ".World", loc.getWorld().getName());
        main.getConfig().set("Warps." + name + ".X", loc.getX());
        main.getConfig().set("Warps." + name + ".Y", loc.getY());
        main.getConfig().set("Warps." + name + ".Z", loc.getZ());
        main.getConfig().set("Warps." + name + ".Pitch", loc.getPitch());
        main.getConfig().set("Warps." + name + ".Yaw", loc.getYaw());
        main.saveConfig();
        p.sendMessage("Warp has been added!");
        return true;
    }
}