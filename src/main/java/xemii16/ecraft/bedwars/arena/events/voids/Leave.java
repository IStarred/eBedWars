package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class Leave {

    public void event (PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (e.getItem() != null && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("Вийти")){
            for (Arena arena : ArenaHashMap.values()){
                if (!arena.getLobbySpawn().getWorld().equals(player.getWorld())) return;
                arena.getPlayers().remove(player);
                e.setCancelled(true);
                for (Team team : arena.getGame().getTeams()){
                    if (!team.getPlayers().contains(player)) return;
                    team.getPlayers().remove(player);
                    e.setCancelled(true);
                }
        }
        }
    }

}
