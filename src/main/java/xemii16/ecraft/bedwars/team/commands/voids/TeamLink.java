package xemii16.ecraft.bedwars.team.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;
import static xemii16.ecraft.bedwars.team.commands.TeamCMD.playerLinkTeam;

public class TeamLink {

    public void command(Player player, String[] args){
        if (args[0].equalsIgnoreCase("link")){
            if (args.length == 2){
                if (playerLinkArena.containsKey(player)){
                    if (!playerLinkTeam.containsKey(player)){
                        Arena arena = ArenaHashMap.get(playerLinkArena.get(player));
                        for (Team team : arena.getGame().getTeams()){
                            try {
                                String name = args[1];
                                if (team.getName().equalsIgnoreCase(name)){
                                    playerLinkTeam.put(player, team.getName());
                                    player.sendMessage(ChatColor.GREEN + "Команда " + team.getName() + " успішно приєднана до вашого ніку");
                                }
                            } catch (Exception e){
                                e.printStackTrace();
                                player.sendMessage(ChatColor.RED + "Критична помилка!");
                            }
                        }
                    }
                }else{
                    player.sendMessage(ChatColor.GOLD + "На вас не записана ніяка арена!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Мало аргументів!");
            }
        }

    }
}
