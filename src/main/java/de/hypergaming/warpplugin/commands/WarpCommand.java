package de.hypergaming.warpplugin.commands;

import de.hypergaming.warpplugin.warp.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 1){
            if (WarpManager.getWarp(args[0]) != null){
                p.teleport(WarpManager.getWarp(args[0]));
                p.sendMessage("§aDu wurdest zu dem Warp " + args[0] + " teleportiert!");
            }else {
                p.sendMessage("§cDiesen Warp gibt es nicht");
            }
        }else if (args.length == 2) {
            if (!p.hasPermission("warp.manage")) {
                p.sendMessage("§cKeine Rechte!");
                return false;
            }
            if (args[0].equalsIgnoreCase("add")) {
                    WarpManager.createWarp(args[1], p.getLocation());
                    p.sendMessage("§aDu hast den Warp " + args[1] + " erstellt!");
            }
            if (args[0].equalsIgnoreCase("delete")) {
                    WarpManager.deleteWarp(args[1]);
                    p.sendMessage("§aDu hast den Warp " + args[1] + " gelöscht!");
            }
        }else if (args.length == 0){
            p.sendMessage("§7/warp [add / delete / name]");
        }

        return false;
    }
}
