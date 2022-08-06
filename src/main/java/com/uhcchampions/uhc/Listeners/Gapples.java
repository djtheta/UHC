package com.uhcchampions.uhc.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class Gapples implements Listener {
//credit to ArowShot for this one. https://www.spigotmc.org/members/arowshot.20692/
    @Deprecated
    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        Material g = e.getRecipe().getResult().getType();
        Byte ItemData = e.getRecipe().getResult().getData().getData();
        if(g == Material.GOLDEN_APPLE&&ItemData==1) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    ((Player)he).sendMessage(ChatColor.RED + "No permission.");
                }
            }
        }
    }
}
