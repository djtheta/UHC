package com.uhcchampions.uhc;

import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.*;

import java.util.*;

public final class Main extends JavaPlugin implements CommandExecutor, Listener {

    private HashMap<UUID, Integer> kills = new HashMap<>();





    @Deprecated
    @Override
    public void onEnable() {

        getCommand("vanish").setExecutor(new VanishCommand());

        Bukkit.getPluginManager().registerEvents(new BowStuff(), this);
        getCommand("heal").setExecutor(new HealCommand());

        ItemStack is = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = is.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "Separate me!");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Golden Head");
        is.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(is);
        recipe.shape(
                "GGG",
                "GHG",
                "GGG");


        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('H', Material.SKULL_ITEM, (byte) 3);

        Bukkit.addRecipe(recipe);


        Bukkit.getPluginManager().registerEvents(new CutCLean(), this);
        getCommand("uhc").setExecutor(this);
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "KingdomsHQ UHC Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "KingdomsHQ UHC Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "KingdomsHQ UHC Enabled!");
        getCommand("pvp").setExecutor(new PvPCommand());
        getCommand("pvpe").setExecutor(new PvPCommand2());
        Bukkit.getPluginManager().registerEvents(new pceDeath(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new Chat(), this);




        }
    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("uhc.use")) {
                //teleports players

                //AUGUST RIGHT HERE BEFORE SPREADPLAYERS


                player.performCommand("spreadplayers 0 0 750 900 false @a");
                player.performCommand("worldborder center 0 0");
                player.performCommand("worldborder set 2000");
                player.performCommand("gamerule naturalRegeneration false");



                //for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                //  players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180, 1000000, false, false));
                // players.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 180, 1000000, false, false));
                //players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180, -100, false, false));
                //players.sendTitle(ChatColor.GOLD + "Teleporting...", ChatColor.AQUA + "Please wait 10 seconds."); //start
                //}

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for(Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.AQUA + "Teleporting...", ChatColor.YELLOW + "Please wait 10 seconds.");
                        }
                    }
                }, 0);

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for(Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.DARK_RED + "5", ChatColor.GRAY + "Starting in...");
                            players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.DARK_RED + "5" + ChatColor.GRAY + ".");
                            players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 180, 1000000, false, false));
                            players.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 180, 1000000, false, false));
                            players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180, -100, false, false));
                        }
                    }
                }, 20);

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.RED + "4", ChatColor.GRAY + "Starting in...");
                            players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.RED + "4" + ChatColor.GRAY + ".");
                        }
                    }
                }, 40);

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.GOLD + "3", ChatColor.GRAY + "Starting in...");
                            players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.GOLD + "3" + ChatColor.GRAY + ".");
                        }
                    }
                }, 60);

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.YELLOW + "2", ChatColor.GRAY + "Starting in...");
                            players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.YELLOW + "2" + ChatColor.GRAY + ".");
                        }
                    }
                }, 80);

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendTitle(ChatColor.GREEN + "1", ChatColor.GRAY + "Starting in...");
                                players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.GREEN + "1" + ChatColor.GRAY + ".");
                            }
                    }
                }, 100);


                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.GREEN + "BEGIN!", ChatColor.YELLOW + "Good luck & have fun!");
                            players.sendMessage(ChatColor.GRAY + "\n§m-------------------------------------------------------------- §r" + ChatColor.GOLD + ChatColor.BOLD + "                                                  Season 1 of KingdomsHQ UHC has begun!                       " + ChatColor.AQUA + "\n                                         * CutClean enabled!                " + ChatColor.AQUA + "\n                                         * Mumble enabled!            " + ChatColor.AQUA + "\n                                         * Random teams set!            " + ChatColor.AQUA + "\n                                         * Ore spawns set!            " + ChatColor.GRAY + "\n§m--------------------------------------------------------------   §r");
                        }
                    }
                }, 120);

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        player.performCommand("worldborder set 150 3600"); //1 hour to shrink to 150
                        for (Player players : Bukkit.getServer().getOnlinePlayers()) {

                            players.sendTitle(ChatColor.DARK_RED + "Border has begun to shrink! Head towards 0 0.", ChatColor.RED + "\nBorder: 150x150");

                        }
                    }
                }, 72000); //1 hour till border shrinks

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        player.performCommand("pvpe");
                        for (Player players : Bukkit.getServer().getOnlinePlayers()) {

                            players.sendTitle(ChatColor.RED + "PvP ENABLED!", ChatColor.GRAY + "Good luck.");
                        }
                    }
                }, 24000); //pvp enabled!

                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        player.performCommand("pvp");
                        for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                            players.sendTitle(ChatColor.DARK_GREEN + "Grace Period!", ChatColor.GRAY + "PVP Disabled for 20 minutes!");
                            players.sendMessage(ChatColor.GRAY + "All players have received " + ChatColor.GOLD + "20 steak" + ChatColor.GRAY + ".");
                            players.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 20));
                        }
                    }
                }, 300);


                Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                    @Override
                    public void run() {
                        for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                            players.setHealth(players.getMaxHealth());
                            players.sendTitle(ChatColor.GOLD + "Final Heal!", ChatColor.RED + "All players have been healed. Don't die!");
                            players.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 300, 0, false, false));
                        }
                    }
                }, 6000);


            } else {
                player.sendMessage(ChatColor.RED + "No Permission!");
            }
        }
        return false;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        ItemStack is = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = is.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "Separate me!");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Golden Head");
        is.setItemMeta(meta);
            if (e.getItem().equals(is)) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
            }
    }


    @Deprecated
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.setStatistic(Statistic.PLAYER_KILLS, 1);

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective health = board.registerNewObjective("Health", Criterias.HEALTH);
        health.setDisplaySlot(DisplaySlot.BELOW_NAME);
        health.setDisplayName(ChatColor.RED + "❤");

        Objective obj = board.registerNewObjective("KingdomsHQ", "UHC");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "KingdomsHQ " + ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC" + " S1");

        Score space = obj.getScore(ChatColor.GRAY + "§m----------------------");
        space.setScore(5);

        Score Host = obj.getScore(ChatColor.GOLD + "Host: " + ChatColor.AQUA + "SebHobbit");
        Host.setScore(4);


        Team Kills = board.registerNewTeam("kills");
        Kills.addEntry(ChatColor.RED.toString());
        Kills.setPrefix(ChatColor.GOLD + "Kills: ");
        Kills.setSuffix(ChatColor.AQUA + "0");
        obj.getScore(ChatColor.RED.toString()).setScore(3);

        kills.put(player.getUniqueId(), 0);

        int border = (int) getServer().getWorld("world").getWorldBorder().getSize();

        Team Border = board.registerNewTeam("border1");
        Border.addEntry(ChatColor.GREEN.toString());
        Border.setPrefix(ChatColor.GOLD + "Border: ");
        Border.setSuffix(ChatColor.AQUA.toString() + border);
        obj.getScore(ChatColor.GREEN.toString()).setScore(2);

        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                int border = (int) getServer().getWorld("world").getWorldBorder().getSize();
                player.getScoreboard().getTeam("border1").setSuffix(ChatColor.AQUA.toString() + border);
            }
        }, 20, 20);


        Score space2 = obj.getScore(ChatColor.GRAY + "§m---------------------- §r");
        space2.setScore(1);

        player.setScoreboard(board);


    }

    @Deprecated
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {


        int playersremaining = Bukkit.getOnlinePlayers().size();
        playersremaining--;

        Bukkit.broadcastMessage(ChatColor.RED.toString() + playersremaining + " players remain.");

        e.getEntity().getPlayer().setBanned(true);
        e.getEntity().getPlayer().kickPlayer(ChatColor.GOLD + "Thank you for playing!" + "\nCome back next Season!");





    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {

        Player killer = e.getEntity().getKiller();

        int kills = this.kills.get(killer.getUniqueId());


        if(e.getEntity().getKiller() != null) {
            kills++;
            this.kills.put(killer.getUniqueId(), kills);
            killer.getScoreboard().getTeam("kills").setSuffix(ChatColor.GOLD.toString() + kills);
        }




    }

    @Deprecated
    @EventHandler
    public void OnQuit(PlayerQuitEvent e) {
        for(Player players : Bukkit.getOnlinePlayers()) {
            if (Bukkit.getOnlinePlayers().size() == 1) {
                players.sendTitle(ChatColor.GREEN + "VICTORY!", ChatColor.DARK_GREEN + players.getDisplayName() + " has won this UHC!");
            }
        }
    }

}