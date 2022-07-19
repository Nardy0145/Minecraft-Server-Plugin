package me.nardy.commands.cmds;

import me.nardy.commands.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FeedAnimals implements CommandExecutor {
    private final Main main;

    public FeedAnimals(Main main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (args[0].equals("")) {
            p.sendMessage("Выберите кого кормить. (cows ; sheeps ; chickens)");
        }
        List<Entity> x = new ArrayList<Entity>();
        if (args[0].equals("cows") || args[0].equals("sheeps") || args[0].equals("chickens")) {
            String animal = StringUtils.chop(args[0]);
            List<Entity> animals = p.getNearbyEntities(16, 16, 16);
            for (Entity ent : animals) {
                if (ent.getName().toLowerCase().equals(animal)) {
                    x.add(ent);
                }
            }
        }
        int many = x.size();
        if (many < 1) {
            p.sendMessage("Не обнаружено подходящих сущностей");
            return true;
        }
        ItemStack item;
        if (args[0].equals("cows") || args[0].equals("sheeps")) {
            item = new ItemStack(Material.WHEAT);
        } else {
            item = new ItemStack(Material.WHEAT_SEEDS);
        }
        int haveItems = 0;
        for (ItemStack i : p.getInventory().getContents()) {
            if(i != null){
                if (i.isSimilar(item)) {
                    haveItems += i.getAmount();
                }
            }
        }
        if (haveItems < many){
            p.sendMessage("Недостаточно предметов!");
            return true;
        }
        if (args[0].equals("cows") || args[0].equals("sheeps")) {
            p.getInventory().removeItem(new ItemStack(Material.WHEAT, many));
        }
        else{
            p.getInventory().removeItem(new ItemStack(Material.WHEAT_SEEDS, many));
        }
        for (Entity e : x){
            ((Animals)e).setLoveModeTicks(600);
        }
        p.sendMessage("Животные покормлены!");
        return true;
    }
}