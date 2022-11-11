package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class ArenaList {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("list")){
            player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Список арен:");
            for (Arena arena : ArenaHashMap.values() ){
                player.sendMessage(arena.getArenaName());
            }
        }
    }
}
