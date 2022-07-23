package com.uhcchampions.uhc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPCommand implements CommandExecutor, Listener {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("pvp.use")) {

                player.sendMessage(ChatColor.RED + "PVP DISABLED!");
                player.getLocation().getWorld().setPVP(false);


            } else {
            player.sendMessage(ChatColor.RED + "No permission!");
        }

        }



        return false;
    }

    }
