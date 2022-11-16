package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.game.Game;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;


public class ArenaSet {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("set")){

            //
            Arena arena = ArenaHashMap.get(playerLinkArena.get(player));


            if (playerLinkArena.containsKey(player.getPlayer())){
                if (args[1].equalsIgnoreCase("lobby")){
                    arena.setLobbySpawn(player.getLocation());
                    player.sendMessage(ChatColor.GREEN +"Успішно встановлене лоббі арени");
                }
                if (args[1].equalsIgnoreCase("players")){
                    int PlayersPerTeam = Integer.parseInt(args[2]);
                    int NumberOfTeams = Integer.parseInt(args[3]);
                    arena.setPlayersPerTeam(PlayersPerTeam);
                    arena.setNumberOfTeams(NumberOfTeams);
                    player.sendMessage(ChatColor.GREEN + "Успішно встановлена кількість команд і кількість гравців в команді: " + PlayersPerTeam + "x" + NumberOfTeams);
                }

            } else {
                player.sendMessage(ChatColor.GOLD + "На вас не записана ніяка арена!");
            }
        }
    }
}
