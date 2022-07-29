package com.uhcchampions.uhc.Listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class pceDeath implements Listener {

    @Deprecated
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        player.getWorld().strikeLightningEffect(player.getLocation());
        player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()).setType(Material.FENCE);
        player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ() - 1).setType(Material.FENCE);
        Block skullBlock = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() + 1, (player.getLocation().getBlockZ()));
        skullBlock.setType(Material.SKULL);
        skullBlock.setData((byte) 3);
        Skull skull = (Skull) skullBlock.getState();
        skull.setRotation(BlockFace.NORTH);

        skull.setSkullType(SkullType.PLAYER);
        skull.setOwner(player.getName());

        skull.update();
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.playSound(players.getLocation(), Sound.AMBIENCE_THUNDER, 10, 10);
        }

        Entity victim = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        int kills = e.getEntity().getKiller().getStatistic(Statistic.PLAYER_KILLS);


        if(e.getEntity().getKiller() != null) {
                e.setDeathMessage(ChatColor.RED + victim.getName() + ChatColor.YELLOW + " was slain by " + ChatColor.RED + killer.getName() + ChatColor.GRAY + "[" + ChatColor.WHITE + kills++ + ChatColor.GRAY + "]" + ChatColor.YELLOW + ".");
        }

    }

}
