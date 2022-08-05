package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (player.hasPermission("gmc.use")) {
                    player.sendMessage(ChatColor.GOLD + "Your gamemode has been set to " + ChatColor.AQUA + "creative" + ChatColor.GOLD + ".");
                    player.setGameMode(GameMode.CREATIVE);

                } else {
                    player.sendMessage(ChatColor.RED + "No permission!");
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                player.sendMessage(ChatColor.GOLD + "Set " + target.getName() + "'s gamemode to " + ChatColor.AQUA + "creative" + ChatColor.GOLD + ".");
                target.sendMessage(ChatColor.GOLD + "Your gamemode has been set to " + ChatColor.AQUA + "creative" + ChatColor.GOLD + ".");
                target.setGameMode(GameMode.CREATIVE);

            }
        }

        return false;
    }
}
