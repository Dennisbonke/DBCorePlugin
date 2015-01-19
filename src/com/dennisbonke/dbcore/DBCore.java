package com.dennisbonke.dbcore;

import com.dennisbonke.dbcore.commands.KillallCommand;
import com.dennisbonke.dbcore.listener.player.PlayerJoin;
import com.dennisbonke.dbcore.util.Chat;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Dennisbonke on 19-1-2015.
 */
public class DBCore extends JavaPlugin {

    public static Chat chat = new Chat("DBCORE");
    private static DBCore plugin;
    private CommandsManager<CommandSender> commands;

    public static Chat getChat(){
        return chat;
    }

    public static DBCore getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        chat.sendConsoleMessage("Starting up DBCore, Please wait....");

        plugin = this;
        PluginManager pm = Bukkit.getPluginManager();

        chat.sendConsoleMessage("Registering events....");
        pm.registerEvents(new PlayerJoin(this), this);
        chat.sendConsoleMessage("Events registered.");

        chat.sendConsoleMessage("DBCore is ready to go!");
        chat.sendConsoleMessage("Enabled.");

    }

    @Override
    public void onDisable() {
        chat.sendConsoleMessage("Shutting down DBCore, This should only take a moment....");

        chat.sendConsoleMessage("Junk cleared, shutting down.");
        chat.sendConsoleMessage("Disabled.");
    }

    private void setupCommands() {
        this.commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender sender, String perm) {
                return sender instanceof ConsoleCommandSender
                        || sender.hasPermission(perm);
            }
        };
        CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, this.commands);
        cmdRegister.register(KillallCommand.class);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        try {
            this.commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException e) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
        } catch (MissingNestedCommandException e) {
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (CommandUsageException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (WrappedCommandException e) {
            if (e.getCause() instanceof NumberFormatException) {
                sender.sendMessage(ChatColor.RED
                        + "Number expected, string received instead.");
            } else {
                sender.sendMessage(ChatColor.RED
                        + "An error has occurred. See console.");
                e.printStackTrace();
            }
        } catch (CommandException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
        }

        return true;
    }

}
