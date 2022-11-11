package xemii16.ecraft.bedwars.game.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.game.Game;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;

public class GameSet {

    public void command (Player player, String[] args) {
        if (args[0].equalsIgnoreCase("set")) {
            if (args[1].equalsIgnoreCase("world")) {
                if (playerLinkArena.containsKey(player)){
                    World world = player.getWorld();

                    Game game = ArenaHashMap.get(playerLinkArena.get(player)).getGame();
                    game.setWorld(world);
                    player.sendMessage(ChatColor.GREEN + "Успішно встановлений світ гри до арени " + ArenaHashMap.get(playerLinkArena.get(player)).getArenaName());
                } else {
                    player.sendMessage(ChatColor.GOLD + "До вас не під'єднана арена!");
                }

            }
        }
    }
}
