package com.uhcchampions.uhc;

import com.connorlinfoot.titleapi.TitleAPI;
import com.uhcchampions.uhc.Commands.*;
import com.uhcchampions.uhc.Listeners.*;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Main extends JavaPlugin implements CommandExecutor, Listener {

    //Main class
    public BowStuff other;

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

   private HashMap<UUID, Integer> kills1 = new HashMap<>();

   private HashMap<UUID, UUID> recentMessages;

    public static String s = (ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " ");
    private final String z = (ChatColor.GOLD + ChatColor.BOLD.toString() + "BORDER " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " ");

    @Deprecated
    @Override
    public void onEnable() {
        other = new BowStuff(this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
        Bukkit.dispatchCommand(console, "gamerule sendCommandFeedback false");
        console.sendMessage("Gamerule Disabled!");
        //Bukkit.getPluginManager().registerEvents(new Gapples(), this);
        getCommand("message").setExecutor(new MessageCommand(this));
        getCommand("reply").setExecutor(new ReplyCommand(this));
        Bukkit.getPluginManager().registerEvents(new Staff(), this);
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("w0w").setExecutor(new w0w());
        getCommand("gmsp").setExecutor(new GMSP());
        getCommand("healall").setExecutor(new HealAll());
        getCommand("release").setExecutor(new WhitelistCommand());
        getCommand("staff").setExecutor(new Staff());
        getCommand("victory").setExecutor(new Victory());
        Bukkit.getPluginManager().registerEvents(other, this);
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new Fly());
        getCommand("gmc").setExecutor(new GMC());
        getCommand("gms").setExecutor(new GMS());
        ItemStack is = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = is.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Separate me!");
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


        getCommand("speed").setExecutor(new Speed());
        Bukkit.getPluginManager().registerEvents(new CutCLean(), this);
        getCommand("uhc").setExecutor(this);
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "KingdomsHQ UHC Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "KingdomsHQ UHC Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "KingdomsHQ UHC Enabled!");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "!_! Theta's UHC");
        getCommand("pvp").setExecutor(new PvPCommand());
        getCommand("pvpe").setExecutor(new PvPCommand2());
        Bukkit.getPluginManager().registerEvents(new pceDeath(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new Chat(), this);

        recentMessages = new HashMap<>();

        }

        public HashMap<UUID, UUID> getRecentMessages() { return recentMessages; }



    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("uhc.use")) {
                //teleports players

                //AUGUST RIGHT HERE BEFORE SPREADPLAYERS

                for (int i = 0; i < Bukkit.getOnlinePlayers().size() / 3; i++) {
                    Bukkit.dispatchCommand(console, "scoreboard teams add " + i);
                    Bukkit.dispatchCommand(console, "scoreboard teams join " + i + " @r[team=]");
                    Bukkit.dispatchCommand(console, "scoreboard teams join " + i + " @r[team=]");
                }
                Bukkit.dispatchCommand(console, "scoreboard teams add odd_take_the_L");
                Bukkit.dispatchCommand(console, "scoreboard teams join odd_take_the_L @r[team=]");

                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.sendMessage(ChatColor.GOLD + "Teleporting..." + "\nWaiting for TPS to stabilize..");
                }

                player.performCommand("spreadplayers 0 0 1000 1498 true @a");
                player.performCommand("worldborder center 0 0");
                player.performCommand("worldborder set 3000");
                player.performCommand("gamerule naturalRegeneration false");
                player.performCommand("pvp");
                player.performCommand("difficulty hard");

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 1000000, false, false));
                        players.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 400, 1000000, false, false));
                        players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, -100, false, false));
                        players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 1000000, false, false));
                    }
                }, 0);
                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(ChatColor.DARK_RED + "5", ChatColor.GRAY + "Starting in...");
                        players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.DARK_RED + "5" + ChatColor.GRAY + ".");
                        players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 5, 0);
                    }
                }, 200);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(ChatColor.RED + "4", ChatColor.GRAY + "Starting in...");
                        players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.RED + "4" + ChatColor.GRAY + ".");
                        players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 5, 0);
                    }
                }, 220);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(ChatColor.GOLD + "3", ChatColor.GRAY + "Starting in...");
                        players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.GOLD + "3" + ChatColor.GRAY + ".");
                        players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 5, 0);
                    }
                }, 240);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(ChatColor.YELLOW + "2", ChatColor.GRAY + "Starting in...");
                        players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.YELLOW + "2" + ChatColor.GRAY + ".");
                        players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 5, 0);
                    }
                }, 260);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendTitle(ChatColor.GREEN + "1", ChatColor.GRAY + "Starting in...");
                            players.sendMessage(ChatColor.GRAY + "UHC starts in " + ChatColor.GREEN + "1" + ChatColor.GRAY + ".");
                            players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 5, 0);
                        }
                }, 280);



                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(ChatColor.GREEN + "BEGIN!", ChatColor.YELLOW + "Good luck & have fun!");
                        players.sendMessage(ChatColor.GRAY + "\n§m-------------------------------------------------------------- §r" + ChatColor.GOLD + ChatColor.BOLD + "                                                                       KingdomsHQ UHC Season 2 has begun!                                  " + ChatColor.AQUA + "\n                                         ✦ CutClean enabled!                " + ChatColor.AQUA + "\n                                         ✦ Notches enabled!            " + ChatColor.AQUA + "\n                                         ✦ Random teams set!            " + ChatColor.AQUA + "\n                                         ✦ Custom ore generation set!            " + ChatColor.GRAY + "\n§m--------------------------------------------------------------   §r");
                        players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 10, 10);
                        players.setHealth(players.getMaxHealth());
                        players.setFoodLevel(20);
                    }
                }, 300);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    player.performCommand("worldborder set 100 1800"); //30m to shrink to 100x100
                    for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                        players.sendTitle(ChatColor.DARK_RED + "Border Shrinking", ChatColor.RED + "Head towards 0 0.");
                        players.sendMessage(z + ChatColor.GOLD + "Border has begun to shrink.");
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 10, 10);
                    }
                }, 48000); //40m till border begins to shrink

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendTitle(ChatColor.YELLOW + "Border set!", ChatColor.GRAY + "Border is now 100x100");
                        players.playSound(players.getLocation(), Sound.NOTE_PLING, 10, 10);
                    }
                }, 84000);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 20 minutes.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 25200);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 10 minutes.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 36000);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 5 minutes.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 42000);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 1 minute.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 46800);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 5 seconds.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 47900);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 4 seconds.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 47920);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 3 seconds.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 47940);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 2 seconds.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 47960);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage(z + ChatColor.GOLD + "Border will be begin to shrink in 1 seconds.");
                        players.playSound(players.getLocation(), Sound.NOTE_PIANO, 10, 10);
                    }
                }, 47980);



                Bukkit.getScheduler().runTaskLater(this, () -> {
                    player.performCommand("pvpe");
                    for (Player players : Bukkit.getServer().getOnlinePlayers()) {

                        players.sendTitle(ChatColor.GREEN + "PvP ENABLED!", ChatColor.GRAY + "Good luck.");
                        players.playSound(players.getLocation(), Sound.NOTE_PLING, 10, 10);
                    }
                }, 24000); //pvp enabled!

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                        players.sendTitle(ChatColor.DARK_GREEN + "Grace Period!", ChatColor.GRAY + "PVP Disabled for 20 minutes!");
                        players.playSound(players.getLocation(), Sound.NOTE_BASS, 10, 10);
                    }
                }, 600);

                Bukkit.getScheduler().runTaskLater(this, () -> {
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        players.setHealth(players.getMaxHealth());
                        players.setFoodLevel(20);
                        players.sendTitle(ChatColor.GOLD + "Final Heal!", ChatColor.GRAY + "Absorption for 5 minutes.");
                        players.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 6000, 0, false, false));
                        players.playSound(players.getLocation(), Sound.NOTE_PLING, 10, 10);
                    }
                }, 1200);


            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }
        }
        return false;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        ItemStack is = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta meta = is.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Separate me!");
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


        if(player.getName().equals("Nans12_")) {
                player.setDisplayName(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "Streamer" + ChatColor.GRAY + "]" + ChatColor.RESET + " " + ChatColor.WHITE + player.getName() + ChatColor.RESET);
        }

        if(!player.hasPlayedBefore()) {
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setTitle(ChatColor.GOLD + ChatColor.BOLD.toString() + "KingdomsHQ UHC " + ChatColor.AQUA + ChatColor.BOLD + "S2");
            meta.setAuthor(ChatColor.RED + "Theta & Fin");
            meta.addPage(
                    ChatColor.GOLD + "Thank you for playing Season 2 of KingdomsHQ's UHC." +
                    "      \n\nWe hope you enjoy the new additions to the game, as well as the numerous bug fixes that we have taken time to repair." +
                                                "\n\nHave fun & Good luck.");
            book.setItemMeta(meta);
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + "20 steak" + ChatColor.GRAY + ".");
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + "10 feathers" + ChatColor.GRAY + ".");
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + "12 sugar cane" + ChatColor.GRAY + ".");
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + "3 books" + ChatColor.GRAY + ".");
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + "3 string" + ChatColor.GRAY + ".");
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + "20 flint" + ChatColor.GRAY + ".");
            player.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + ChatColor.BOLD.toString() + "KingdomsHQ UHC " + ChatColor.AQUA + ChatColor.BOLD + "S2" + ChatColor.GRAY + ".");
            player.getInventory().addItem(book);
            player.getInventory().addItem(new ItemStack(Material.STRING, 3));
            player.getInventory().addItem(new ItemStack(Material.BOOK, 3));
            player.getInventory().addItem(new ItemStack(Material.SUGAR_CANE, 12));
            player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 20));
            player.getInventory().addItem(new ItemStack(Material.FEATHER, 10));
            player.getInventory().addItem(new ItemStack(Material.FLINT, 20));
        }

        if(player.getGameMode().equals(GameMode.SPECTATOR)) {
            player.setDisplayName(ChatColor.GRAY + ChatColor.ITALIC.toString() + player.getName());
        }

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            int tps = (int) Lag.getTPS();
            TitleAPI.sendTabTitle(player, ChatColor.GOLD + ChatColor.BOLD.toString() + "           KingdomsHQ " + ChatColor.AQUA + ChatColor.BOLD + "UHC " + "S2           " + "\n", ChatColor.GOLD + "                         \n           TPS" + ChatColor.RESET + " " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + ChatColor.AQUA + tps + ChatColor.RESET + "           ");
        }, 20, 20);


            if (player.getName().equals("SebHobbit")) {
                player.setDisplayName(ChatColor.GRAY + "[" + ChatColor.RED + "Host" + ChatColor.GRAY + "]" + ChatColor.RESET + " " + ChatColor.WHITE + player.getName() + ChatColor.RESET);
            } else if (player.getName().equals("FinlayAtom13")) {
                player.setDisplayName(ChatColor.GRAY + "[" + ChatColor.RED + "Host" + ChatColor.GRAY + "]" + ChatColor.RESET + " " + ChatColor.WHITE + player.getName() + ChatColor.RESET);
            }


            e.setJoinMessage(ChatColor.DARK_GRAY + "(" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + ")" + ChatColor.RESET + " " + player.getDisplayName());

            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();


            Objective health = board.registerNewObjective("Health", Criterias.HEALTH);
            health.setDisplaySlot(DisplaySlot.BELOW_NAME);
            health.setDisplayName(ChatColor.RED + "❤");

            Objective obj = board.registerNewObjective("KingdomsHQ", "UHC");
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
            obj.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "KingdomsHQ " + ChatColor.AQUA + ChatColor.BOLD + "UHC" + " S2");

            Score space = obj.getScore(ChatColor.GRAY + "§m----------------------");
            space.setScore(5);

            Score Host = obj.getScore(ChatColor.GOLD + "Host: " + ChatColor.AQUA + "SebHobbit");
            Host.setScore(4);


        int stat = player.getStatistic(Statistic.PLAYER_KILLS);
        Team Kills = board.registerNewTeam("kills");
        Kills.addEntry(ChatColor.RED.toString());
        Kills.setPrefix(ChatColor.GOLD + "Kills: ");
        Kills.setSuffix(ChatColor.AQUA.toString() + stat);
        obj.getScore(ChatColor.RED.toString()).setScore(3);


        kills1.put(player.getUniqueId(), stat);


            int border = (int) getServer().getWorld("world").getWorldBorder().getSize();

            Team Border = board.registerNewTeam("border1");
            Border.addEntry(ChatColor.GREEN.toString());
            Border.setPrefix(ChatColor.GOLD + "Border: ");
            Border.setSuffix(ChatColor.AQUA.toString() + border);
            obj.getScore(ChatColor.GREEN.toString()).setScore(2);

            Bukkit.getScheduler().runTaskTimer(this, () -> {
                int border1 = (int) getServer().getWorld("world").getWorldBorder().getSize();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.getScoreboard().getTeam("border1").setSuffix(ChatColor.AQUA.toString() + border1);
                }
            }, 20, 20);


            Score space2 = obj.getScore(ChatColor.GRAY + "§m---------------------- §r");
            space2.setScore(1);

            player.setScoreboard(board);
        }


    @Deprecated
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        player.setGameMode(GameMode.SPECTATOR);
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(player);
        }
        player.sendMessage(s + ChatColor.GOLD + "Thank you for playing!\n" + s + ChatColor.YELLOW + "Come back next game!");
        player.sendMessage(s + ChatColor.GOLD + "Your gamemode has been set to " + ChatColor.AQUA + "spectator" + ChatColor.GOLD + ".");
        player.setDisplayName(ChatColor.GRAY + ChatColor.ITALIC.toString() + player.getName());

    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {

        Player killer = e.getEntity().getKiller();

        int kills = this.kills1.get(killer.getUniqueId());


        if (e.getEntity().getKiller() != null) {
            kills++;
            this.kills1.put(killer.getUniqueId(), kills);
            killer.getScoreboard().getTeam("kills").setSuffix(ChatColor.AQUA.toString() + kills);
            e.setDeathMessage(ChatColor.RED + e.getEntity().getPlayer().getName() + ChatColor.YELLOW + " was slain by " + ChatColor.RED + killer.getName() + ChatColor.YELLOW + " using " + ChatColor.GRAY + "[" + ChatColor.WHITE + killer.getEquipment().getItemInHand().getItemMeta().getDisplayName() + ChatColor.GRAY + "]" + ChatColor.YELLOW + ".");
            Bukkit.broadcastMessage(ChatColor.RED + e.getEntity().getPlayer().getName() + ChatColor.GRAY + " has been eliminated.");
        }
    }




    //credit to WarmakerT -->
    @EventHandler
//When player breaks a block:
    public void onBlockBreak(BlockBreakEvent event) {
//if Block is a leaf Block and Player's held item
        if(event.getBlock().getType().equals(Material.LEAVES) && event.getPlayer().getItemInHand().getType().equals(Material.SHEARS)) {
            /*Cancel this event. Meaning, don't let the block break.*/
            event.setCancelled(true);
//Remove the blocks, or effectively just set it to air.
            event.getBlock().setType(Material.AIR);
//Do some fancy doo-dad algorithm, probably just using Random
            Random rand = new Random();
            int randomNumber = rand.nextInt(10);
            switch(randomNumber){
                //credit to WarmakerT
                default:
                    break;
                case 1:
                    event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.APPLE, 1));
                case 2:
                    break;
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY + "(" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + ")" + ChatColor.RESET + " " + player.getDisplayName());
        recentMessages.remove(e.getPlayer().getUniqueId());
    }


    @EventHandler
    public void onPing(ServerListPingEvent e) {
        e.setMaxPlayers(420);
    }


}


