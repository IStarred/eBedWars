package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;

public class ArenaLink {

    public boolean command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("link")){
            if (args.length == 2){
                if (ArenaHashMap.containsKey(args[1])){
                    if (!(playerLinkArena.containsKey(player.getPlayer()))){
                        playerLinkArena.put(player.getPlayer(), args[1]);
                        player.sendMessage(ChatColor.GREEN + "Арена" + args[1] + " під'єднана до вашого гравця!");
                    }else{
                        player.sendMessage(ChatColor.GOLD + "На вас уже записана арена - " + ArenaHashMap.get(playerLinkArena.get(player)).getArenaName());
                    }
                }else{
                    player.sendMessage(ChatColor.RED + "Нажаль, такої арени не існує!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Замало аргументів");
            }
        }
        return true;
    }
}
