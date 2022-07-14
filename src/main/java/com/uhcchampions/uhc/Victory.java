package com.uhcchampions.uhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Victory implements CommandExecutor {
    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            for(Player players : Bukkit.getOnlinePlayers()) {
                players.sendTitle(ChatColor.GREEN + "VICTORY!", ChatColor.DARK_GREEN + players.getDisplayName() + " has won this UHC!");
            }










        }




        return false;
    }
}
