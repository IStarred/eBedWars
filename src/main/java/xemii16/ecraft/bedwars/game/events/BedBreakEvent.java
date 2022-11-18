package xemii16.ecraft.bedwars.game.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import xemii16.ecraft.bedwars.game.Game;

public class BedBreakEvent implements Listener {

    private Game game;

    @EventHandler
    public void event (BlockBreakEvent e){
        if (e.getBlock().getType() != Material.BEDROCK && e.getBlock().getType().toString().contains("BED")){
            game.onBedBreak(e.getBlock().getType());
        }
    }
}
