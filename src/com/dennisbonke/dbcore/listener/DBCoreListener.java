package com.dennisbonke.dbcore.listener;

import com.dennisbonke.dbcore.DBCore;

import org.bukkit.event.Listener;

/**
 * Created by Dennisbonke on 19-1-2015.
 */
public class DBCoreListener implements Listener {

    public DBCore plugin;

    public DBCoreListener(DBCore pl) {
        plugin = pl;
    }

}
