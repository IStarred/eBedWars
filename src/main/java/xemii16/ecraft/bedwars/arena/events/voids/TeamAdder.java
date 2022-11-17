package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.inventory.InventoryClickEvent;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class TeamAdder {

    public void event (InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        for (Arena arena : ArenaHashMap.values()){
            for (Team team : arena.getGame().getTeams()){
                if (arena.getPlayersPerTeam() > team.getPlayers().size()){
                    if (arena.getLobbySpawn().getWorld().equals(player.getWorld())){
                        if (team.getBedMaterial().equals(e.getCurrentItem())){
                            team.getPlayers().add(player);
                            player.sendMessage("Ви вибрали команду" + team.getChatColor() + team.getGameName());
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }

    }

}
