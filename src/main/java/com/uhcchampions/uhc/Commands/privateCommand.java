package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.uhcchampions.uhc.Util.s;

public class privateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("private.use")) {
                Bukkit.getServer().setWhitelist(true);
                player.sendMessage(s + ChatColor.GOLD + "Server is now private.");
            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }
        }


        return false;
    }
}
