package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class TeamAdder {

    public void event (InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        for (Arena arena : ArenaHashMap.values()){
            if (!arena.getLobbySpawn().equals(player.getWorld())) return;
            for (Team team : arena.getGame().getTeams()){
                if (team.getBedMaterial().equals(e.getCurrentItem())){
                    if (!(team.getPlayers().size() < arena.getPlayersPerTeam())) return;
                    team.getPlayers().add(player);
                    player.sendMessage("Ви вибрали команду" + team.getChatColor() + team.getGameName());
                }
            }
        }
    }

}
