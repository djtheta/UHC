package com.uhcchampions.uhc.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMSP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("gmsp.use")) {
                player.sendMessage(ChatColor.GOLD + "Your gamemode has been set to " + ChatColor.AQUA + "spectator" + ChatColor.GOLD + ".");
                player.setGameMode(GameMode.SPECTATOR);


            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }





        }




        return false;
    }
}
