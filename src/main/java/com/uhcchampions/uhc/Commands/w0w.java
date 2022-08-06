package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class w0w implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("w0w.use")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.setVelocity(new Vector(target.getLocation().getX(), 200, target.getLocation().getZ()));
                    target.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + ChatColor.BLUE + "whoosh!");
                    target.playSound(target.getLocation(), Sound.WITHER_HURT, 10, -1);
                }


            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }
        }


        return false;
    }
}
