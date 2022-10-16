package com.uhcchampions.uhc.Commands;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.uhcchampions.uhc.Util.s;

public class LootCrateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("crate.use")) {
                int x = player.getLocation().getBlockX();
                int y = (int) (player.getLocation().getY() + 50);
                int z = player.getLocation().getBlockZ();
                Location loc = player.getLocation();
                loc.setY(loc.getY() + 50);
                player.sendMessage(s + ChatColor.GOLD + "Loot Crate Set!");
                Bukkit.broadcastMessage(s + ChatColor.GOLD + "There is a loot crate at X: " + ChatColor.AQUA + x + ChatColor.GOLD + " Y: " + ChatColor.AQUA + y + ChatColor.GOLD + " Z: " + ChatColor.AQUA + z);
                Block block = loc.getBlock();
                loc.getBlock().setType(Material.CHEST);
                Chest chest = (Chest)block.getState();













                Random ran = new Random();
                ItemStack aphrodites = new ItemStack(Material.POTION, 1, (short) 8197);
                PotionMeta AWDmeta = (PotionMeta) aphrodites.getItemMeta();
                PotionEffect pec = new PotionEffect(PotionEffectType.ABSORPTION, 600, 0, false, false);
                PotionEffect pec2 = new PotionEffect(PotionEffectType.REGENERATION, 200, 1, false, false);
                AWDmeta.addCustomEffect(pec, false);
                AWDmeta.addCustomEffect(pec2, false);
                AWDmeta.setDisplayName(ChatColor.DARK_PURPLE + "Aphrodite's Elixir");
                ArrayList<String> lorea = new ArrayList<>();
                lorea.add(ChatColor.DARK_RED + ChatColor.ITALIC.toString() + "-Made with love <3.");
                AWDmeta.setLore(lorea);
                aphrodites.setItemMeta(AWDmeta);
                ItemStack hpot = new ItemStack(Material.POTION, 1, (short) 8194);
                PotionMeta hmeta = (PotionMeta) hpot.getItemMeta();
                PotionEffect hec2 = new PotionEffect(PotionEffectType.SPEED, 300, 1, false, false);
                hmeta.addCustomEffect(hec2, false);
                hmeta.setDisplayName(ChatColor.AQUA + "Hermes' Potion.");
                ArrayList<String> hlore1 = new ArrayList<>();
                hlore1.add(ChatColor.BLUE + ChatColor.ITALIC.toString() + "Speed it up.");
                hmeta.setLore(hlore1);
                hpot.setItemMeta(hmeta);
                ItemStack is = new ItemStack(Material.POTION, 1, (short) 8259);
                PotionMeta meta = (PotionMeta) is.getItemMeta();
                PotionEffect pe = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120, 0, false, false);
                PotionEffect pe2 = new PotionEffect(PotionEffectType.REGENERATION, 160, 2, false, false);
                PotionEffect pe3 = new PotionEffect(PotionEffectType.ABSORPTION, 300, 0, false, false);
                PotionEffect pe4 = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 0, false, false);
                meta.addCustomEffect(pe, false);
                meta.addCustomEffect(pe2, false);
                meta.addCustomEffect(pe3, false);
                meta.addCustomEffect(pe4, false);
                meta.setDisplayName(ChatColor.GREEN + "Ambrosia");
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.AQUA + ChatColor.ITALIC.toString() + "The food of the gods.");
                meta.setLore(lore);
                is.setItemMeta(meta);
                ItemStack hermes = new ItemStack(Material.DIAMOND_BOOTS, 1);
                ItemMeta hermesmeta = hermes.getItemMeta();
                hermesmeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
                hermesmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                hermesmeta.setDisplayName(ChatColor.AQUA + "Winged Boots");
                ArrayList<String> hlore = new ArrayList<>();
                hlore.add(ChatColor.WHITE + ChatColor.ITALIC.toString() + "-From the messenger of the gods.");
                hermesmeta.setLore(hlore);
                hermes.setItemMeta(hermesmeta);
                ItemStack cupid = new ItemStack(Material.BOW, 1);
                ItemMeta cupidmeta = cupid.getItemMeta();
                cupidmeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
                cupidmeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
                cupidmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Cupid's Bow");
                ArrayList<String> clore = new ArrayList<>();
                clore.add(ChatColor.RED + ChatColor.ITALIC.toString() + "❤");
                cupidmeta.setLore(clore);
                cupid.setItemMeta(cupidmeta);
                ItemStack protbook = new ItemStack(Material.ENCHANTED_BOOK, 1);
                EnchantmentStorageMeta meta2 = (EnchantmentStorageMeta) protbook.getItemMeta();
                meta2.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
                protbook.setItemMeta(meta2);
                ItemStack sharpbook = new ItemStack(Material.ENCHANTED_BOOK, 1);
                EnchantmentStorageMeta meta3 = (EnchantmentStorageMeta) sharpbook.getItemMeta();
                meta3.addStoredEnchant(Enchantment.DAMAGE_ALL, 1, false);
                sharpbook.setItemMeta(meta3);
                ItemStack powerbook = new ItemStack(Material.ENCHANTED_BOOK, 1);
                EnchantmentStorageMeta meta4 = (EnchantmentStorageMeta) powerbook.getItemMeta();
                meta4.addStoredEnchant(Enchantment.ARROW_DAMAGE, 1, false);
                powerbook.setItemMeta(meta4);
                ItemStack firebook = new ItemStack(Material.ENCHANTED_BOOK, 1);
                EnchantmentStorageMeta meta5 = (EnchantmentStorageMeta) firebook.getItemMeta();
                meta5.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, false);
                firebook.setItemMeta(meta5);
                ArrayList<ItemStack> list = new ArrayList<>();
                list.add(new ItemStack(Material.GOLDEN_APPLE, 2));
                list.add(new ItemStack(Material.GOLDEN_CARROT, 5));
                list.add(new ItemStack(Material.DIAMOND, 6));
                list.add(protbook);
                list.add(is);
                list.add(new ItemStack(Material.COOKED_BEEF, 32));
                list.add(sharpbook);
                list.add(powerbook);
                list.add(firebook);
                list.add(new ItemStack(Material.ARROW, 32));
                list.add(new ItemStack(Material.IRON_INGOT, 5));
                list.add(new ItemStack(Material.STICK, 12));
                list.add(new ItemStack(Material.LEATHER, 6));
                list.add(new ItemStack(Material.SUGAR_CANE, 16));
                list.add(hermes);
                list.add(new ItemStack(Material.GOLD_INGOT, 4));
                list.add(cupid);
                list.add(aphrodites);
                list.add(hpot);

                for(int i = 0; i < 8; i++) {
                    chest.getInventory().addItem(new ItemStack(list.get(ran.nextInt(19))));
                }


            }
        }



        return false;
    }
}
