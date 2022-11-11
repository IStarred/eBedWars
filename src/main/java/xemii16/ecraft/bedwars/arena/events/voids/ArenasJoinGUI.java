package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xemii16.ecraft.bedwars.arena.Arena;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class ArenasJoinGUI {

    public void event (InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Арени БедВарсу")){
                if(e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)){
                    String arenaName = e.getCurrentItem().getItemMeta().getDisplayName();
                    Arena arena = ArenaHashMap.get(arenaName);
                    Location location = arena.getLobbySpawn();
                    player.teleport(location);
                    ArrayList<Player> players = arena.getPlayers();
                    players.add(player);
                    ArenaHashMap.get(arena).setPlayers(players);
                    e.setCancelled(true);
                    player.closeInventory();
                    int NumberOfTeams = arena.getNumberOfTeams();
                    int PlayersPerTeam = arena.getPlayersPerTeam();
                    int allPlayers = NumberOfTeams * PlayersPerTeam;
                    if (arena.getPlayers().size() == allPlayers){
                        arena.startTimer(5);
                    }
                }
        }

    }
}
