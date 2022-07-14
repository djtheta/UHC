package com.uhcchampions.uhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("vanish.use")) {

            if(vanished.contains(player.getUniqueId())) { // they are vanished
                vanished.remove(player.getUniqueId());
                for(Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(player);
                }
                player.sendMessage(ChatColor.AQUA + "You are no longer " + ChatColor.GOLD + "vanished" + ChatColor.AQUA + ".");

            } else { // they are not vanished
                vanished.add(player.getUniqueId());
                for(Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(player);
                }
                player.sendMessage(ChatColor.AQUA + "You are now " + ChatColor.GOLD + "vanished" + ChatColor.AQUA + ".");

            }






            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }






        }




        return false;
    }
}
