package com.dennisbonke.dbcore.commands;

import com.dennisbonke.dbcore.util.Chat;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Created by Dennisbonke on 19-1-2015.
 */
public class KillallCommand {

    private static Chat chat;

    @Command(aliases = {"killall"}, desc = "Removes all entities!", usage = "", min = 0, max = 0)
    public static void killall(final CommandContext args, CommandSender sender) throws CommandException {
        if (sender instanceof ConsoleCommandSender) {
                throw new CommandException("Consoles can't use this command!");
        }
        if (!sender.isOp()) {
                chat.sendMessage(sender, "[DBCore]" + ChatColor.RED + "You don't have permission to use this command!");
            return;
        }
        int i = 0;
        for (World world : Bukkit.getWorlds())
            for (Entity entity : world.getEntities())
                if (!(entity instanceof Player)) {
                    entity.remove();
                    i++;
                }
        chat.sendMessage(sender, "[DBCore]" + ChatColor.WHITE + "Removed " + i + " entities.");
    }

}
