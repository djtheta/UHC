package com.uhcchampions.uhc.Commands;

import com.uhcchampions.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand implements CommandExecutor {
    private Main main;

    public ReplyCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(sender instanceof Player) {
                Player player = (Player) sender;


                if(args.length >= 1) {
                    if(main.getRecentMessages().containsKey(player.getUniqueId())) {
                        UUID uuid = main.getRecentMessages().get(player.getUniqueId());
                        if (Bukkit.getPlayer(uuid) != null) {
                            Player target = Bukkit.getPlayer(uuid);

                            StringBuilder builder = new StringBuilder();
                            for(int i = 0; i < args.length; i++) {
                                builder.append(args[i]).append(" ");
                            }

                            player.sendMessage(ChatColor.GOLD + "(To " + target.getDisplayName() + ChatColor.GOLD + ") " + ChatColor.GRAY + builder);
                            target.sendMessage(ChatColor.GOLD + "(From " + player.getDisplayName() + ChatColor.GOLD + ") " + ChatColor.GRAY + builder);
                            target.playSound(target.getLocation(), Sound.SUCCESSFUL_HIT, 10, 2);
                        } else {
                            player.sendMessage(ChatColor.RED + "Player has gone offline.");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "No message.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid usage.");
                }










            }




        return false;
    }
}
