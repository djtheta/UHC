package com.uhcchampions.uhc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhitelistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("whitelist.use")) {
                player.performCommand("whitelist add rominer_11");
                player.performCommand("whitelist add finlayatom13");
                player.performCommand("whitelist add falconblader");
                player.performCommand("whitelist add nans12_");
                player.performCommand("whitelist add ALALF");
                player.performCommand("whitelist add cliver222");
                player.performCommand("whitelist add ogblockbuster08");
                player.performCommand("whitelist add ihavemyhat");
                player.performCommand("whitelist add jackie0978");
            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }
        }


        return false;
    }
}
