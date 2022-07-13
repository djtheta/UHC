package com.uhcchampions.uhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("heal.use")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.setHealth(target.getMaxHealth());
                    target.sendMessage(ChatColor.LIGHT_PURPLE + "You have been healed!");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have healed " + ChatColor.RED + target.getName());




                }
            }









        }






        return false;
    }
}
