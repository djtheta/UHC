package com.uhcchampions.uhc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    private boolean enabled = false;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("fly.use")) {

                if(enabled) {
                    enabled = false;
                    player.sendMessage(ChatColor.GOLD + "You may no longer " + ChatColor.AQUA + "fly" + ChatColor.GOLD + ".");
                    player.setAllowFlight(false);
                } else {
                    enabled = true;
                    player.sendMessage(ChatColor.GOLD + "You may now " + ChatColor.AQUA + "fly" + ChatColor.GOLD + ".");
                    player.setAllowFlight(true);
                }














            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }










        }






        return false;
    }
}
