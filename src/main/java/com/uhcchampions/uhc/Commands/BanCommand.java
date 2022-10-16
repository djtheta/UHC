package com.uhcchampions.uhc.Commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

import static com.uhcchampions.uhc.Util.s;


public class BanCommand implements CommandExecutor {

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("ban.use")) {

                if(args.length == 2) {
                    if(Bukkit.getOfflinePlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        player.sendMessage(s + ChatColor.AQUA + "You have banned " + ChatColor.GOLD + target.getName() + ChatColor.AQUA + ".");

                        if ("-t".equals(args[1].toLowerCase())) {
                            Calendar cal = Calendar.getInstance();
                            cal.add(Calendar.MINUTE, 20);
                            target.kickPlayer(ChatColor.RED + "You have been temporarily banned from this UHC." + "\nAppeal on Discord.");
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have been temporarily banned from this UHC." + "\nAppeal on Discord.", cal.getTime(), null);
                        } else {
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "You have been banned from this UHC." + "\nAppeal on Discord.", null, null);
                            target.kickPlayer(ChatColor.RED + "You have been banned from this UHC." + "\nAppeal on Discord.");
                        }





                    }




                } else {
                    player.sendMessage(s + ChatColor.RED + "Invalid usage! Use /ban player -t/-s time.");
                }





            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }





        }
        return false;
    }
}
