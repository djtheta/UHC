package com.uhcchampions.uhc.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();
        e.getFormat();
        e.setFormat(" " + player.getDisplayName() + " " + ChatColor.DARK_GRAY + "»" + ChatColor.RESET + " " + ChatColor.GRAY + e.getMessage());
    }

}
