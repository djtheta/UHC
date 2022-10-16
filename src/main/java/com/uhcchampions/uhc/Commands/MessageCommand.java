package com.uhcchampions.uhc.Commands;

import com.uhcchampions.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MessageCommand implements CommandExecutor {

    private Main main;

    public MessageCommand(Main main) {
            this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length >= 2) {
                if(Bukkit.getPlayerExact(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);


                    StringBuilder builder = new StringBuilder();
                    for(int i = 1; i < args.length; i++) {
                        builder.append(args[i]).append(" ");
                    }

                    player.sendMessage(ChatColor.GOLD + "(To " + target.getDisplayName() + ChatColor.GOLD + ") " + ChatColor.GRAY + builder);
                    target.sendMessage(ChatColor.GOLD + "(From " + player.getDisplayName() + ChatColor.GOLD + ") " + ChatColor.GRAY + builder);
                    target.playSound(target.getLocation(), Sound.SUCCESSFUL_HIT, 10, 2);

                    main.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());
                } else {
                    player.sendMessage(ChatColor.RED + "Please specify an online player.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage.");
            }

        }





        return false;
    }
}
