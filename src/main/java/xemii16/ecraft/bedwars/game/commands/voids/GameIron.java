package xemii16.ecraft.bedwars.game.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.game.Game;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;

public class GameIron {


    public void command (Player player, String[] args){
        Arena arena = ArenaHashMap.get(playerLinkArena.get(player));
        Game game = arena.getGame();

        if (args[0].equalsIgnoreCase("iron")){
            if (playerLinkArena.containsKey(player)){
                ArrayList<Location> locations = game.getIronSpawner();
                locations.add(player.getLocation());
                game.setIronSpawner(locations);
                player.sendMessage(ChatColor.GREEN + "Успішно доданий спавнер заліза до арени" + arena.getArenaName());
            } else {
                player.sendMessage(ChatColor.GOLD + "До вас не під'єднана арена!");
            }

        }

    }
}
