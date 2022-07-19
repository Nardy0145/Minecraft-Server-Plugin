package me.nardy.commands.cmds.warp;

import me.nardy.commands.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class delwarp implements CommandExecutor {
    private final Main main;

    public delwarp(Main main) {
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
            return true;
        }
        String name = args[0].toLowerCase();
        if (main.getConfig().get("Warps." + name)==null){
            p.sendMessage("There is no warp with given name!");
            return true;
        }
        String todel = args[0];
        main.getConfig().set("Warps." + name, null);
        p.sendMessage("Warp has been successfully deleted.");
        return true;
    }
}