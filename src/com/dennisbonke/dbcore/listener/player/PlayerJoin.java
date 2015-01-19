package com.dennisbonke.dbcore.listener.player;

import com.dennisbonke.dbcore.DBCore;
import com.dennisbonke.dbcore.listener.DBCoreListener;
import com.dennisbonke.dbcore.util.Chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Dennisbonke on 19-1-2015.
 */
public class PlayerJoin extends DBCoreListener {

    private static Chat chat;

    public PlayerJoin(DBCore pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        chat.sendMessage(player, "Welcome to the server " + player + "!");
    }

}
