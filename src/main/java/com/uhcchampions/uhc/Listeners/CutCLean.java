package com.uhcchampions.uhc.Listeners;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class CutCLean implements Listener {
    HashMap<Integer, ItemStack> leftOver = new HashMap<Integer, ItemStack>();


    @Deprecated
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.IRON_ORE) {
            e.getBlock().setType(Material.AIR);
            e.getPlayer().giveExp(4);
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 10, 2);
            leftOver.putAll((e.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1))));
            if (!leftOver.isEmpty()) {
                Location loc = e.getPlayer().getLocation();
                e.getPlayer().getWorld().dropItem(loc, new ItemStack(Material.getMaterial(leftOver.get(0).getTypeId()), leftOver.get(0).getAmount()));
            }
        }
        if (e.getBlock().getType() == Material.GOLD_ORE) {
            e.getBlock().setType(Material.AIR);;
            e.getPlayer().giveExp(5);
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 10, 2);
            leftOver.putAll((e.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1))));
            if (!leftOver.isEmpty()) {
                Location loc = e.getPlayer().getLocation();
                e.getPlayer().getWorld().dropItem(loc, new ItemStack(Material.getMaterial(leftOver.get(0).getTypeId()), leftOver.get(0).getAmount()));
            }
        }
        if(e.getBlock().getType() == Material.DIAMOND_ORE) {
            e.getBlock().setType(Material.AIR);
            e.getPlayer().giveExp(6);
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 10, 2);
            leftOver.putAll((e.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND, 1))));
            if (!leftOver.isEmpty()) {
                Location loc = e.getPlayer().getLocation();
                e.getPlayer().getWorld().dropItem(loc, new ItemStack(Material.getMaterial(leftOver.get(0).getTypeId()), leftOver.get(0).getAmount()));
            }
        }
    }

    @EventHandler
    public void onFarmKill(EntityDeathEvent e) {
        if(e.getEntity() instanceof Pig) {
            e.getDrops().clear();
            e.getDrops().add(new ItemStack(Material.GRILLED_PORK, 4));
            e.setDroppedExp(5);
        }
        if(e.getEntity() instanceof Cow) {
            e.getDrops().clear();
            e.getDrops().add(new ItemStack(Material.COOKED_BEEF, 3));
            e.getDrops().add(new ItemStack(Material.LEATHER, 2));
            e.setDroppedExp(5);
        }
        if(e.getEntity() instanceof Chicken) {
            e.getDrops().clear();
            e.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, 3));
            e.getDrops().add(new ItemStack(Material.FEATHER, 3));
            e.setDroppedExp(5);
        }
        if(e.getEntity() instanceof Sheep) {
            e.getDrops().clear();
            e.getDrops().add(new ItemStack(Material.COOKED_MUTTON, 3));
            e.getDrops().add(new ItemStack(Material.WOOL, 4));
            e.setDroppedExp(5);
        }
    }


}