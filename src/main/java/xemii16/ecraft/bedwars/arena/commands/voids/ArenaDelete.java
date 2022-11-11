package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;
import static xemii16.ecraft.bedwars.team.commands.TeamCMD.playerLinkTeam;

public class ArenaDelete {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("delete")){
            if (args.length == 2){
                if (ArenaHashMap.containsKey(args[1])){
                    try {
                        String name = args[1];
                        for (Player playerArena : playerLinkArena.keySet()){
                            if (playerLinkArena.get(playerArena).equalsIgnoreCase(name)){
                                playerLinkArena.remove(playerArena);
                            }
                        }
                        for (Team team : ArenaHashMap.get(name).getGame().getTeams()){
                            for (Player playerTeam : playerLinkTeam.keySet()){
                                if (team.getName().equalsIgnoreCase(playerLinkTeam.get(playerTeam))){
                                    playerLinkTeam.remove(playerTeam);
                                }
                            }
                        }
                        ArenaHashMap.remove(name);
                        player.sendMessage(ChatColor.GREEN + "Арена " + name + " успішно видалена!");
                    } catch (Exception e){
                        e.printStackTrace();
                        player.sendMessage(ChatColor.RED + "Критична помилка!");
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Такої арени не існує!");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Замало аргументів!");
            }



        }
    }
}
