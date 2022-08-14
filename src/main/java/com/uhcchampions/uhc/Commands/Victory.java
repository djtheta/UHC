package com.uhcchampions.uhc.Commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.FireworkMeta;

import static com.uhcchampions.uhc.Main.s;

public class Victory implements CommandExecutor {
    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("victory.use")) {
            for(Player players : Bukkit.getOnlinePlayers()) {
                if (players.getGameMode().equals(GameMode.SURVIVAL)) {
                    players.sendTitle(ChatColor.GOLD + "VICTORY!", ChatColor.GRAY + "You have won this season's UHC!");
                    Firework firework = players.getWorld().spawn(players.getLocation(), Firework.class);
                    FireworkMeta meta = firework.getFireworkMeta();
                    meta.addEffect(FireworkEffect.builder().withColor(Color.ORANGE).withColor(Color.AQUA).with(FireworkEffect.Type.STAR).build());
                    meta.setPower(3);
                    firework.setFireworkMeta(meta);

                    ItemStack book2 = new ItemStack(Material.WRITTEN_BOOK);
                    BookMeta meta2 = (BookMeta) book2.getItemMeta();
                    meta2.setTitle(ChatColor.GOLD + ChatColor.BOLD.toString() + "UHC " + ChatColor.AQUA + ChatColor.BOLD + "WIN");
                    meta2.setAuthor(ChatColor.RED + "Theta & Fin");
                    meta2.addPage(
                            ChatColor.GOLD + ChatColor.BOLD.toString() + "Congratulations on winning this UHC!" +
                                    ChatColor.AQUA + "      \n\nPlease contact this game's hosts to receive your prize." +
                                    "\n\nThank you.");
                    book2.setItemMeta(meta2);
                    players.sendMessage(s + ChatColor.GRAY + "You have received " + ChatColor.GOLD + ChatColor.BOLD.toString() + "KingdomsHQ UHC " + ChatColor.AQUA + ChatColor.BOLD + "Win" + ChatColor.GRAY + ".");
                    players.getInventory().setItemInHand(book2);
                }
            }
            }










        }




        return false;
    }
}
