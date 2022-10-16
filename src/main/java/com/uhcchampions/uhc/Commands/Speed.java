package com.uhcchampions.uhc.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.uhcchampions.uhc.Util.s;

public class Speed implements CommandExecutor {

    //Credit to this bro: https://github.com/Skiftstar
    //https://www.youtube.com/watch?v=Ep0nJjT4ZyE
    //https://github.com/Skiftstar/SpigotCodingTutorials

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("speed.use")) {
                if(args.length == 0) {
                    player.sendMessage(s + ChatColor.RED + "Please enter a value from 1-10");
                    return false;
                }
                int speed;
                try {
                    speed = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    player.sendMessage(s + ChatColor.RED + "Please enter a value from 1-10");
                    return false;
                }
                if (speed < 1 || speed > 10) {
                    player.sendMessage(s + ChatColor.RED + "Please enter a value from 1-10");
                    return false;
                }
                if(player.isFlying()) {
                    player.setFlySpeed((float) speed / 10);
                } else {
                    player.setWalkSpeed((float) speed / 10);
                }
                player.sendMessage(s + ChatColor.AQUA + "Your speed has been set to " + ChatColor.GOLD.toString() + speed + ChatColor.AQUA + ".");












            } else {
                player.sendMessage(ChatColor.RED + "No permission.");
            }




        }




        return false;
    }
}
