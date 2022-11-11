package xemii16.ecraft.bedwars.team.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;
import static xemii16.ecraft.bedwars.team.commands.TeamCMD.playerLinkTeam;

public class TeamPublish {
    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("publish")){
            if (playerLinkTeam.containsKey(player)){
                Arena arena = ArenaHashMap.get(playerLinkArena.get(player));
                for (Team team : arena.getGame().getTeams()){
                    if (team.getName().equalsIgnoreCase(playerLinkTeam.get(player))){
                        if (team.getGameName() != null){
                            if (team.getSpawnLocation() != null){
                                if (team.getBedLocation() != null){
                                    playerLinkTeam.remove(player);
                                    player.sendMessage(ChatColor.GREEN + "Команда " + team.getName() + " успішно опублікована!");
                                } else {
                                    player.sendMessage(ChatColor.GOLD + "У команди " + team.getName() + " немає локації ліжка!");
                                }
                            } else {
                                player.sendMessage(ChatColor.GOLD + "У команди " + team.getName() + " немає спавну!");
                            }
                        } else {
                            player.sendMessage(ChatColor.GOLD + "У команди " + team.getName() + " немає ігрового імені!");
                        }
                    }
                }
            } else {
                player.sendMessage(ChatColor.GOLD + "У вас немає під'єднаної команди!");
            }
        }
    }
}
