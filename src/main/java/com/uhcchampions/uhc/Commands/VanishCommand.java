package com.uhcchampions.uhc.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor, Listener {

    private final List<UUID> vanished = new ArrayList<>();
    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("vanish.use")) {

                if (vanished.contains(player.getUniqueId())) { // they are vanished
                    vanished.remove(player.getUniqueId());
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.showPlayer(player);
                        player.setAllowFlight(false);
                    }
                    player.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + ChatColor.AQUA + "You are no longer " + ChatColor.GOLD + "vanished" + ChatColor.AQUA + ".");

                } else { // they are not vanished
                    vanished.add(player.getUniqueId());
                    Bukkit.dispatchCommand(console, "particle explode " + player.getLocation().getX() + " " + (player.getLocation().getY() + 0.9) + " " + player.getLocation().getZ() + " 0.075 0.225 0.075 0 100");
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.hidePlayer(player);
                        player.setAllowFlight(true);
                    }
                    ItemStack is = new ItemStack(Material.CARPET, 1, (short) 5);
                    ItemMeta im = is.getItemMeta();
                    im.setDisplayName(ChatColor.GREEN + "Teleport");
                    is.setItemMeta(im);
                    player.getInventory().addItem(is);
                    player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0f, 1.0f);
                    player.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + (ChatColor.AQUA + "You are now " + ChatColor.GOLD + "vanished" + ChatColor.AQUA + "."));
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

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInHand().isSimilar(is)) {
                player.performCommand("tp @r");
                player.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + "UHC " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + ChatColor.GOLD + "Teleporting...");
        }
    }
}
}
