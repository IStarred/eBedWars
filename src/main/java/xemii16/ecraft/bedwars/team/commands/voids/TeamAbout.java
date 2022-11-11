package xemii16.ecraft.bedwars.team.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;

public class TeamAbout {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("about")){
            if (playerLinkArena.containsKey(player)){
                Arena arena = ArenaHashMap.get(playerLinkArena.get(player));
                for (Team team : arena.getGame().getTeams()){
                    try {
                        player.sendMessage(ChatColor.BOLD + "Назва команди: " + (team.getChatColor() + team.getGameName()));
                        player.sendMessage(ChatColor.BOLD + "Спавн команди:");
                        player.sendMessage("Світ:" + team.getSpawnLocation().getWorld().getName());
                        player.sendMessage("Координати спавну: x = " + team.getSpawnLocation().getBlockX() + " ,y = " + team.getSpawnLocation().getBlockY() + " ,z = " + team.getSpawnLocation().getBlockZ());
                        player.sendMessage(ChatColor.BOLD + " Спавн ліжка команди:");
                        player.sendMessage("Світ: " + team.getBedLocation().getWorld().getName());
                        player.sendMessage(" Координати ліжка: x = " + team.getBedLocation().getBlockX() + " ,y = " + team.getBedLocation().getBlockY() + " ,z = " + team.getBedLocation().getBlockZ());
                    } catch (NullPointerException e){
                        e.printStackTrace();
                        player.sendMessage("Інформація не повна!");
                    }

                }
            }
        }
    }
}
