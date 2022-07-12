package com.uhcchampions.uhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            for(Player players : Bukkit.getOnlinePlayers()) {
                if(players.isOp()) {
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.sendMessage(ChatColor.GREEN + ChatColor.BOLD.toString() + "A bug has been found!");
                    players.teleport(player.getLocation());

                }
            }





        }





        return false;
    }
}
