package com.uhcchampions.uhc;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

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
                    FireworkMeta meta = (FireworkMeta) firework.getFireworkMeta();
                    meta.addEffect(FireworkEffect.builder().withColor(Color.ORANGE).withColor(Color.AQUA).with(FireworkEffect.Type.STAR).build());
                    meta.setPower(3);
                    firework.setFireworkMeta(meta);
                }
            }
            }










        }




        return false;
    }
}
