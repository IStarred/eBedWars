package xemii16.ecraft.bedwars.arena.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import xemii16.ecraft.bedwars.arena.events.voids.Leave;
import xemii16.ecraft.bedwars.arena.events.voids.TeamAdderGUI;

public class PlayerInteractListener implements Listener {

    TeamAdderGUI teamAdderGUI = new TeamAdderGUI();
    Leave leave = new Leave();

    @EventHandler
    public void playerInteract (PlayerInteractEvent e){
        teamAdderGUI.event(e);
        leave.event(e);
    }
}
