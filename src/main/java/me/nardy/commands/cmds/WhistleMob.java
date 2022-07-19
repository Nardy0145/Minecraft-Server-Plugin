package me.nardy.commands.cmds;

import me.nardy.commands.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.util.List;

public class WhistleMob implements CommandExecutor {
    private final Main main;

    public WhistleMob(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return true;
        }
        Player p = (Player) sender;
        World w = p.getWorld();
        for (Entity ents : w.getEntitiesByClass(Wolf.class))
        {
            if (((Tameable)ents).isTamed() && (((Tameable)ents).getOwner().getName().equals(p.getName())))
            {
                if (!((Sittable)ents).isSitting()) {
                    Location loc = p.getLocation();
                    ents.teleport(loc);
                }
            }
        }
        for (Entity ents : w.getEntitiesByClass(Cat.class))
        {
            if (((Tameable)ents).isTamed() && (((Tameable)ents).getOwner().getName().equals(p.getName())))
            {
                if (!((Sittable)ents).isSitting()) {
                    Location loc = p.getLocation();
                    ents.teleport(loc);
                }
            }
        }
        p.sendMessage(ChatColor.GREEN + "Твои любимчики здесь!");
        return true;
    }
}
