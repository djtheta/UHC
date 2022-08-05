package com.uhcchampions.uhc.Listeners;

import com.uhcchampions.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.text.DecimalFormat;


public class BowStuff implements Listener {

    private final Main mainClass;

    public BowStuff(Main main) {
        this.mainClass = main;
    }

    @EventHandler
    public void onShot(EntityDamageByEntityEvent e) {

                Bukkit.getScheduler().runTaskLater(mainClass, () -> {
                    Arrow arrow = (Arrow) e.getDamager();



                    Player shooter = (Player) arrow.getShooter();
                    Player player = (Player) e.getEntity();
                    double health = (player.getHealth());
                    if (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                        if (e.getDamager() instanceof Arrow && e.getEntity() instanceof Player) {
                            ((Player) arrow.getShooter()).playSound(((Player) arrow.getShooter()).getLocation(), Sound.SUCCESSFUL_HIT, 5, 1);
                            shooter.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + player.getDisplayName() + ChatColor.YELLOW + " is now at " + ChatColor.RED + Math.round(health) + " ❤");
                            if (!(arrow.getShooter() instanceof Player)) return;
                        }
                        player.isDead();
                    }
                }, 0);
            }



}









