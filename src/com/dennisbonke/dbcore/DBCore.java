package com.dennisbonke.dbcore;

import com.dennisbonke.dbcore.util.Chat;
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

    }

    @Override
    public void onDisable() {

    }
}
