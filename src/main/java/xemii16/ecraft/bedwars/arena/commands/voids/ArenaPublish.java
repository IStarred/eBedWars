package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.game.Game;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;

public class ArenaPublish {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("publish") && playerLinkArena.containsKey(player)){
            Arena arena = ArenaHashMap.get(playerLinkArena.get(player));
            Game game = arena.getGame();
            if (null != ArenaHashMap.get(playerLinkArena.get(player)).getLobbySpawn()){
                if (!(game.getBronzeSpawner().isEmpty() && game.getIronSpawner().isEmpty() && game.getGoldSpawner().isEmpty())){
                    if (game.getWorld() != null){
                        if (game.getTeams().size() == arena.getNumberOfTeams()){
                            for (Team team : game.getTeams()){
                                if (team.getBedLocation() != null){
                                    if (team.getSpawnLocation() != null){
                                        if (team.getGameName() != null){
                                            arena.setActive(true);
                                            playerLinkArena.remove(player);
                                            player.sendMessage(ChatColor.GREEN + "Арена" + arena.getArenaName() + " опублікована!");
                                        } else {
                                            player.sendMessage(ChatColor.GOLD + "У команди" + team.getName() + "немає ігрового імені (під час гри)");
                                        }

                                    } else {
                                        player.sendMessage(ChatColor.GOLD + "У команди" + team.getName() + "немає точки спавну!");
                                    }
                                } else {
                                    player.sendMessage(ChatColor.GOLD +"Команда" + team.getName() + "немає ліжка");
                                }
                            }
                        } else {
                            player.sendMessage(ChatColor.GOLD + "Недостатньо створено команд!");
                        }
                    } else {
                        player.sendMessage(ChatColor.GOLD + "До гри не під'єднано ніякого світу :c");
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "У вас немає спавнерів ресурсів");
                }
            } else {
                player.sendMessage(ChatColor.GOLD + "У вашої арени немає лоббі :c");
            }
        }

    }
}
