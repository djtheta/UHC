package com.uhcchampions.uhc.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PvPCommand2 implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("pvpe.use")) {
                player.sendMessage(ChatColor.GREEN + "PVP ENABLED!");
                player.getLocation().getWorld().setPVP(true);


            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }
        }



        return false;
    }
}