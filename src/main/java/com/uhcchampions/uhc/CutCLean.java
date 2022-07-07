package com.uhcchampions.uhc;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CutCLean implements Listener {

    @EventHandler

    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.IRON_ORE) {
            Location location = e.getBlock().getLocation();
            World world = location.getWorld();
            e.getBlock().setType(Material.AIR);
            world.dropItem(location, new ItemStack(Material.IRON_INGOT));
            e.getPlayer().giveExp(4);
        }
        if (e.getBlock().getType() == Material.GOLD_ORE) {
            Location location = e.getBlock().getLocation();
            World world = e.getBlock().getWorld();
            e.getBlock().setType(Material.AIR);
            world.dropItem(location, new ItemStack(Material.GOLD_INGOT));
            e.getPlayer().giveExp(5);
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