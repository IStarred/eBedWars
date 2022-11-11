package xemii16.ecraft.bedwars.team.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.commands.ArenaCMD.playerLinkArena;
import static xemii16.ecraft.bedwars.team.commands.TeamCMD.playerLinkTeam;

public class TeamSet {


    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("set")){
            if (args[1].equalsIgnoreCase("color")){
                if (playerLinkTeam.containsKey(player)){
                    for (Team team : ArenaHashMap.get(playerLinkArena.get(player)).getGame().getTeams()){
                        if (team.getName().equalsIgnoreCase(playerLinkTeam.get(player))){
                            if (args[2].equalsIgnoreCase("WHITE")){
                                team.setChatColor(ChatColor.WHITE);
                                team.setBedMaterial(Material.WHITE_BED);
                                team.setGameName("Білі");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("ORANGE")){
                                team.setChatColor(ChatColor.GOLD);
                                team.setBedMaterial(Material.ORANGE_BED);
                                team.setGameName("Оранжеві");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("MAGENTA")){
                                team.setChatColor(ChatColor.DARK_PURPLE);
                                team.setBedMaterial(Material.MAGENTA_BED);
                                team.setGameName("Пурпурові");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("LIGHT_BLUE")){
                                team.setChatColor(ChatColor.BLUE);
                                team.setBedMaterial(Material.LIGHT_BLUE_BED);
                                team.setGameName("Світло-сині");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("YELLOW")){
                                team.setChatColor(ChatColor.YELLOW);
                                team.setBedMaterial(Material.YELLOW_BED);
                                team.setGameName("Жовті");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("LIME")){
                                team.setChatColor(ChatColor.GREEN);
                                team.setBedMaterial(Material.LIME_BED);
                                team.setGameName("Лаймові");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("PINK")){
                                team.setChatColor(ChatColor.LIGHT_PURPLE);
                                team.setBedMaterial(Material.PINK_BED);
                                team.setGameName("Рожеві");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("GRAY")){
                                team.setChatColor(ChatColor.GRAY);
                                team.setBedMaterial(Material.GRAY_BED);
                                team.setGameName("Сірі");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("PURPLE")){
                                team.setChatColor(ChatColor.DARK_PURPLE);
                                team.setBedMaterial(Material.PURPLE_BED);
                                team.setGameName("Фіолетові");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("BLUE")){
                                team.setChatColor(ChatColor.DARK_BLUE);
                                team.setBedMaterial(Material.BLUE_BED);
                                team.setGameName("Сині");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("CYAN")){
                                team.setChatColor(ChatColor.DARK_AQUA);
                                team.setBedMaterial(Material.CYAN_BED);
                                team.setGameName("Блакитні");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("RED")){
                                team.setChatColor(ChatColor.RED);
                                team.setBedMaterial(Material.RED_BED);
                                team.setGameName("Червоні");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            } else if (args[2].equalsIgnoreCase("BLACK")){
                                team.setChatColor(ChatColor.BLACK);
                                team.setBedMaterial(Material.BLACK_BED);
                                team.setGameName("Чорні");
                                player.sendMessage(ChatColor.GREEN + "Встановлено ігрове ім'я команди " + team.getName() + ": " + team.getChatColor() + team.getGameName());
                            }
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Немає під'єднаної команди!");
                }
            }
            if (args[1].equalsIgnoreCase("spawn")){
                if (playerLinkTeam.containsKey(player)){
                    for (Team team : ArenaHashMap.get(playerLinkArena.get(player)).getGame().getTeams()){
                        if (team.getName().equalsIgnoreCase(playerLinkTeam.get(player))){
                            team.setSpawnLocation(player.getLocation());
                            player.sendMessage(ChatColor.GREEN + "Локація спавну команди " + team.getName() + " успішно створена!");
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Немає під'єднаної команди!");
                }
            }
            if (args[1].equalsIgnoreCase("bed")){
                if (playerLinkTeam.containsKey(player)){
                    for (Team team : ArenaHashMap.get(playerLinkArena.get(player)).getGame().getTeams()){
                        if (team.getName().equalsIgnoreCase(playerLinkTeam.get(player))){
                            team.setBedLocation(player.getLocation());
                            player.sendMessage(ChatColor.GREEN + "Локація ліжка команди " + team.getName() + " успішно встановлене");
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Немає під'єднаної команди!");
                }
            }
        }
    }
}
