package me.nardy.commands.cmds;

import me.nardy.commands.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GoHome implements CommandExecutor {
    private final Main main;

    public GoHome(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            // World w = p.getWorld();
            Location bed = p.getBedSpawnLocation();
            p.teleport(bed);
            p.sendMessage(ChatColor.BLUE + "Теперь ты дома <3");
            return true;
        }
        return false;
    }
}
