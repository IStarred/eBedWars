package xemii16.ecraft.bedwars.arena.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import xemii16.ecraft.bedwars.arena.events.voids.ArenasJoinGUI;
import xemii16.ecraft.bedwars.arena.events.voids.TeamAdder;

public class InventoryClickListener implements Listener {

    ArenasJoinGUI arenasJoinGUI = new ArenasJoinGUI();
    TeamAdder teamAdder = new TeamAdder();
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e ){
        Player player = (Player) e.getWhoClicked();
        arenasJoinGUI.event(e);
        teamAdder.event(e);
    }
}







