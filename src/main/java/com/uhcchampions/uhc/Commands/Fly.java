package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Fly implements CommandExecutor {

    private boolean enabled = false;
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("fly.use")) {

                if(enabled) {
                    enabled = false;
                    player.setAllowFlight(false);

                    for (int i = 0; i < 180; i++) {
                        Bukkit.dispatchCommand(console, "particle cloud " + (player.getLocation().getX() + (1 * (cos((i - 90) * -1)))) + " " + (player.getLocation().getY()) + " " + (player.getLocation().getZ() + (1 * (sin((i - 90) * -1)))) + " 0 0 0 1");
                    }
                    player.sendMessage(ChatColor.GOLD + "You may no longer " + ChatColor.AQUA + "fly" + ChatColor.GOLD + ".");

                } else {
                    enabled = true;
                    player.setAllowFlight(true);

                    for (int i = 0; i < 180; i++) {
                        Bukkit.dispatchCommand(console, "particle cloud " + (player.getLocation().getX() + (1 * (cos((i - 90) * -1)))) + " " + (player.getLocation().getY()) + " " + (player.getLocation().getZ() + (1 * (sin((i - 90) * -1)))) + " 0 0 0 1");
                    }
                    player.sendMessage(ChatColor.GOLD + "You may now " + ChatColor.AQUA + "fly" + ChatColor.GOLD + ".");
                }














            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }










        }






        return false;
    }
}
