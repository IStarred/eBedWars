package xemii16.ecraft.bedwars.team.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;
import static xemii16.ecraft.bedwars.team.commands.TeamCMD.playerLinkTeam;

public class TeamCreate {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("create")){
            if (playerLinkArena.containsKey(player)){
                if (args.length == 2){
                    if(ArenaHashMap.get(playerLinkArena.get(player)).getNumberOfTeams() >= ArenaHashMap.get(playerLinkArena.get(player)).getGame().getTeams().size()){
                        try {
                            String team = args[1];
                            Arena arena = ArenaHashMap.get(playerLinkArena.get(player));
                            arena.getGame().addTeam(team,null, null, null, null , 1, null);
                            playerLinkTeam.put(player, team);
                            player.sendMessage(ChatColor.GREEN + "Команда " + team + " успішно створена!");
                        }catch (Exception e){
                            e.printStackTrace();
                            player.sendMessage(ChatColor.RED + "Введені неправильні дані");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Перевищення ліміту команд! (макс " + ArenaHashMap.get(playerLinkArena.get(player)).getNumberOfTeams() + ")");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Мало аргументів!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "У вас немає арени!");
            }
        }
    }
}
