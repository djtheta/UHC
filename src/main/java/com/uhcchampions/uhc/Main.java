package com.uhcchampions.uhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new CutCLean(), this);
        getCommand("uhc").setExecutor(this);
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC CHAMPIONS Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC CHAMPIONS Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC CHAMPIONS Enabled!");
        getCommand("pvp").setExecutor(new PvPCommand());
        Bukkit.getPluginManager().registerEvents(new PvPCommand(), this);
        Bukkit.getPluginManager().registerEvents(new PvPCommand2(), this);
        getCommand("pvpe").setExecutor(new PvPCommand2());
    }

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            //teleports players
            player.performCommand("spreadplayers ~ ~ 750 1200 true @a");
            player.performCommand("worldborder center 0 0");
            player.performCommand("worldborder set 2000");
            player.performCommand("gamerule naturalRegeneration false");

            for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180, 1000000, false, false));
                players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180, -100, false, false));
                players.sendTitle(ChatColor.GOLD + "Teleporting...", ChatColor.AQUA + "Please wait 10 seconds.");
            }

            Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                        players.sendTitle(ChatColor.GREEN + "BEGIN!", ChatColor.YELLOW + "Good luck & have fun!");
                        Bukkit.broadcastMessage(ChatColor.GOLD + "Season 1 of UHC Champions has begun!" + ChatColor.GREEN + "\n- CutClean enabled!" + ChatColor.GREEN + "\n- Mumble enabled!" + ChatColor.GREEN + "\n- Random teams set!" + ChatColor.GREEN + "\n- Ore spawns set!");
                        Bukkit.broadcastMessage(ChatColor.GRAY + "All players have received " + ChatColor.GOLD + "20 steak" + ChatColor.GRAY + ".");
                        players.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 20));
                        players.sendTitle(ChatColor.DARK_GREEN + "Grace Period!", ChatColor.GRAY + "PVP Disabled for 20 minutes!");
                        player.performCommand("pvp");

                    }
                }
            }, 100);

            Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    player.performCommand("worldborder set 150 3600"); //1 hour to shrink to 150
                    for(Player players : Bukkit.getServer().getOnlinePlayers()) {

                        players.sendTitle(ChatColor.DARK_RED + "Border has begun to shrink!", ChatColor.RED + "\nBorder: 150x150");

                    }
                }
            }, 72000); //1 hour till border shrinks

            Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    player.performCommand("pvpe");
                    for(Player players : Bukkit.getServer().getOnlinePlayers()) {

                        players.sendTitle(ChatColor.RED + "PvP ENABLED!", ChatColor.GRAY + "Stay safe.");
                    }
                }
            }, 24000);
        }


        return false;



    }
    }
