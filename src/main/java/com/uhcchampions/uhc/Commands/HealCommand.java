package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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

public class HealCommand implements CommandExecutor {

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            location.setY(location.getY() + 2);

            if(player.hasPermission("heal.use")) {
                if (args.length == 0) {
                    player.setHealth(player.getMaxHealth());
                    player.setFoodLevel(20);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 10, 10, false, false));

                    for (int i = 0; i < 180; i++) {
                        Bukkit.dispatchCommand(console, "particle heart " + (player.getLocation().getX() + (1 * (cos((i - 90) * -1)))) + " " + (player.getLocation().getY() + (0.01 * i)) + " " + (player.getLocation().getZ() + (1 * (sin((i - 90) * -1)))) + " 0 0 0 1");
                    }

                    player.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 1.0f, 1.0f);

                    player.sendMessage(ChatColor.RED + "You have been healed!");
                    player.sendMessage(ChatColor.RED + "You have healed " + ChatColor.LIGHT_PURPLE + player.getName());
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.setHealth(target.getMaxHealth());
                    target.setFoodLevel(20);
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 10, 10, false, false));

                    for (int i = 0; i < 180; i++) {
                        Bukkit.dispatchCommand(console, "particle heart " + (target.getLocation().getX() + (1 * (cos((i - 90) * -1)))) + " " + (target.getLocation().getY() + (0.01 * i)) + " " + (target.getLocation().getZ() + (1 * (sin((i - 90) * -1)))) + " 0 0 0 1");
                    }

                    target.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 1.0f, 1.0f);

                    target.sendMessage(ChatColor.RED + "You have been healed!");
                    player.sendMessage(ChatColor.RED + "You have healed " + ChatColor.LIGHT_PURPLE + target.getName());
                }
            } else {
                player.sendMessage(ChatColor.RED + "No permission!");
            }









        }






        return false;
    }
}
