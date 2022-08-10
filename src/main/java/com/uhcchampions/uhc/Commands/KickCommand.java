package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.uhcchampions.uhc.Main.s;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("kick.use")) {
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.kickPlayer(ChatColor.RED + "You have been kicked.");
                    player.sendMessage(s + ChatColor.AQUA + "You have kicked " + ChatColor.GOLD + target.getName());


                } else {
                    player.sendMessage(ChatColor.RED + "Invalid usage. /kick [playername]");
                }






            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }







        }




        return false;
    }
}
