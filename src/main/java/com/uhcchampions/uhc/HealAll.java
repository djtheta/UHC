package com.uhcchampions.uhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class HealAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("healall.use")) {
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setHealth(players.getMaxHealth());
                    players.setFoodLevel(20);
                    players.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 10, 10, false, false));
                    for (int i = 0; i < 180; i++) {
                        Bukkit.dispatchCommand(console, "particle heart " + (players.getLocation().getX() + (1 * (cos((i - 90) * -1)))) + " " + (players.getLocation().getY() + (0.01 * i)) + " " + (players.getLocation().getZ() + (1 * (sin((i - 90) * -1)))) + " 0 0 0 1");
                    }

                    players.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 1.0f, 1.0f);

                    players.sendMessage(ChatColor.RED + "You have been healed!");
                    player.sendMessage(ChatColor.RED + "You have healed " + ChatColor.LIGHT_PURPLE + players.getName());
                }
            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }
        }



        return false;
    }
}
