package xemii16.ecraft.bedwars.arena.commands.voids;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.Arena;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class ArenaAbout {

    public void command (Player player, String[] args){
        if (args[0].equalsIgnoreCase("about")){
            if (args.length == 2){
                try {
                    if (ArenaHashMap.containsKey(args[1])){
                        Arena arena = ArenaHashMap.get(args[1]);
                        player.sendMessage(ChatColor.BOLD + "Назва арени: " + arena.getArenaName());
                        player.sendMessage("ID арени: " + arena.getId());
                        player.sendMessage("Спавн команди: " + arena.getLobbySpawn().getWorld().getName());
                        player.sendMessage("Кількість гравців в команді: " + arena.getPlayersPerTeam());
                        player.sendMessage(" Кількість команд " + arena.getNumberOfTeams() + " (по факту " + arena.getGame().getTeams().size() + ")");
                        player.sendMessage("Стан арени " + arena.isActive());
                        player.sendMessage("Локації бронзи " + arena.getGame().getBronzeSpawner().size());
                        player.sendMessage("Локації заліза " + arena.getGame().getIronSpawner().size());
                        player.sendMessage("Локації золота " + arena.getGame().getGoldSpawner().size());
                        player.sendMessage("Світ гри " + arena.getGame().getWorld().getName());
                    } else {
                        player.sendMessage("Такої арени не існує!");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    player.sendMessage("Критична помилка!");
                }

            } else {
                player.sendMessage("Недостатньо аргументів!");
            }

        }

    }
}
