package com.dennisbonke.dbcore;

import com.dennisbonke.dbcore.listener.player.PlayerJoin;
import com.dennisbonke.dbcore.util.Chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Dennisbonke on 19-1-2015.
 */
public class DBCore extends JavaPlugin {

    public static Chat chat = new Chat("DBCORE");
    private static DBCore plugin;

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
}
