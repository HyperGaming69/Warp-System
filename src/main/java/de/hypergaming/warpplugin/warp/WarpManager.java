package de.hypergaming.warpplugin.warp;

import de.hypergaming.warpplugin.WarpPlugin;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(String name){
        return  WarpPlugin.getCfg().getConfiguration().getLocation(name);
    }

    public static void createWarp(String name, Location location){
        WarpPlugin.getCfg().set(name , location);
        WarpPlugin.getCfg().save();
    }

    public static void deleteWarp(String name){
        WarpPlugin.getCfg().set(name, null);
        WarpPlugin.getCfg().save();
    }

}

