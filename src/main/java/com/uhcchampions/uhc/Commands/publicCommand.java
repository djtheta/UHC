package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.uhcchampions.uhc.Util.s;

public class publicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("public.use")) {
                Bukkit.getServer().setWhitelist(false);
                player.sendMessage(s + ChatColor.GOLD + "Server is now public.");
            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }
        }


        return false;
    }
}
