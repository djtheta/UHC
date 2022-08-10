package com.uhcchampions.uhc.Commands;

import com.google.common.cache.CacheBuilder;
import com.uhcchampions.uhc.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sun.security.util.Cache;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.uhcchampions.uhc.Main.s;

public class Staff implements CommandExecutor, Listener {

    private boolean enabled = true;
    private boolean enabled2 = false;

    Map<String, Long> cooldowns = new HashMap<String, Long>();
    private final List<UUID> vanished = new ArrayList<>();
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("staff.use")) {

                if (vanished.contains(player.getUniqueId())) { // they are vanished
                    vanished.remove(player.getUniqueId());
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.showPlayer(player);
                    }
                    player.setAllowFlight(false);
                    player.getInventory().clear();
                    player.sendMessage(s + ChatColor.AQUA + "You are no longer " + ChatColor.GOLD + "vanished" + ChatColor.AQUA + ".");
                    player.sendMessage(s + ChatColor.AQUA + "You are no longer in " + ChatColor.GOLD + "staff mode" + ChatColor.AQUA + ".");
                    player.setGameMode(GameMode.SURVIVAL);

                } else { // they are not vanished
                    vanished.add(player.getUniqueId());
                    Bukkit.dispatchCommand(console, "particle explode " + player.getLocation().getX() + " " + (player.getLocation().getY() + 0.9) + " " + player.getLocation().getZ() + " 0.075 0.225 0.075 0 100");
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.hidePlayer(player);
                    }
                    player.setGameMode(GameMode.ADVENTURE);
                    player.setAllowFlight(true);

                    ItemStack is = new ItemStack(Material.CARPET, 1, (short) 5);
                    ItemMeta im = is.getItemMeta();
                    im.setDisplayName(ChatColor.GREEN + "Teleport");
                    is.setItemMeta(im);

                    ItemStack is2 = new ItemStack(Material.NETHER_STAR);
                    ItemMeta im2 = is2.getItemMeta();
                    im2.setDisplayName(ChatColor.RED + "Disable Chat");
                    is2.setItemMeta(im2);

                    ItemStack is3 = new ItemStack(Material.ANVIL);
                    ItemMeta im3 = is3.getItemMeta();
                    im3.setDisplayName(ChatColor.GOLD + "Fly Speed");
                    is3.setItemMeta(im3);

                    player.getInventory().setItem(8, is3);
                    player.getInventory().setItem(4, is);
                    player.getInventory().setItem(0, is2);
                    player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0f, 1.0f);
                    player.sendMessage(s + ChatColor.AQUA + "You are now " + ChatColor.GOLD + "vanished" + ChatColor.AQUA + ".");
                    player.sendMessage(s + ChatColor.AQUA + "You are now in " + ChatColor.GOLD + "staff mode" + ChatColor.AQUA + ".");
                }


            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }


        }


        return false;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack is = new ItemStack(Material.CARPET, 1, (short) 5);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "Teleport");
        is.setItemMeta(im);

        ItemStack is2 = new ItemStack(Material.NETHER_STAR);
        ItemMeta im2 = is2.getItemMeta();
        im2.setDisplayName(ChatColor.RED + "Disable Chat");
        is2.setItemMeta(im2);

        ItemStack is3 = new ItemStack(Material.ANVIL);
        ItemMeta im3 = is3.getItemMeta();
        im3.setDisplayName(ChatColor.GOLD + "Fly Speed");
        is3.setItemMeta(im3);

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInHand().isSimilar(is)) {
                player.performCommand("tp @r");
                player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 10, 2);
                player.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + ChatColor.GOLD + "Teleporting...");
            }
        }
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(player.getInventory().getItemInHand().isSimilar(is2)) {
                if(enabled) {
                    enabled = false;
                    player.sendMessage(s + ChatColor.AQUA + "You have disabled the " + ChatColor.GOLD + "chat" + ChatColor.AQUA + ".");
                    Bukkit.broadcastMessage(s + ChatColor.RED + "The chat has been disabled.");
                } else {
                    enabled = true;
                    player.sendMessage(s + ChatColor.AQUA + "You have enabled the " + ChatColor.GOLD + "chat" + ChatColor.AQUA + ".");
                    Bukkit.broadcastMessage(s + ChatColor.GREEN + "The chat has been enabled.");
                }
            }
        }

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(player.getInventory().getItemInHand().isSimilar(is3)) {
                if(!enabled2) {
                    enabled2 = true;
                    player.performCommand("speed 10");
                } else {
                    enabled2 = false;
                    player.performCommand("speed 1");
                }
            }
        }
}

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if(!enabled) {
            e.setCancelled(true);
            player.sendMessage(s + ChatColor.RED + "Chat is currently disabled.");
        }

    }
}
