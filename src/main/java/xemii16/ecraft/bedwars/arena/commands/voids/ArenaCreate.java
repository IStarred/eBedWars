package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.game.Game;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class ArenaCreate {

    // arena create <name> <id> <active> <List Players> <locationSpawn> <Game> <int playersPerTeam> <int numberOfTeams>

    public void command (Player player, String[] args){

        if (args[0].equalsIgnoreCase("create")){
            if (args.length == 3){
                if (!ArenaHashMap.containsKey(args [1])){
                    try {
                        String name = args[1];
                        int id = Integer.parseInt(args[2]);
                        Arena arena = new Arena(name, id, false, new ArrayList<>(), null, new Game(new ArrayList<>(), false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null), 1, 2, Bukkit.createBossBar("Очікування гравців...", BarColor.BLUE, BarStyle.SOLID));
                        ArenaHashMap.put(name, arena);
                        player.sendMessage(ChatColor.GREEN + "Арена " + name + " успішно створена!");
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        player.sendMessage(ChatColor.RED + "Введені неправильні параметри");
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Така арена" + ArenaHashMap.get((args[1])).getArenaName() + " вже існує! Змініть ім'я арени на інше!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Мала кількість аргументів!");
            }

        }

    }
}
