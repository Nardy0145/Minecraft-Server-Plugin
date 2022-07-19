package me.nardy.commands.cmds.warp;

import me.nardy.commands.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warp implements CommandExecutor {
    private final Main main;

    public warp(Main main) {
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
        if (args.length == 0)
        {
            p.sendMessage("Enter warp name!");
            return true;
        }
        if (args[0].equals("list")) {
            for (String key : main.getConfig().getConfigurationSection("Warps").getKeys(false)) {
                p.sendMessage(key);
            }
            return true;
        }

        String name = args[0].toLowerCase();
        if (main.getConfig().get("Warps." + name)==null){
            p.sendMessage("There is no warp with given name!");
            return true;
        }
        Location loc;
        String world = main.getConfig().getString("Warps." + name + ".World");
        double x = main.getConfig().getDouble("Warps." + name + ".X");
        double y = main.getConfig().getDouble("Warps." + name + ".Y");
        double z = main.getConfig().getDouble("Warps." + name + ".Z");
        float yaw = (float) main.getConfig().getDouble("Warps." + name + ".Yaw");
        float pitch = (float) main.getConfig().getDouble("Warps." + name + ".Pitch");
        loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        p.teleport(loc);
        p.sendMessage("You've been teleported to " + name);
        return true;
    }
}