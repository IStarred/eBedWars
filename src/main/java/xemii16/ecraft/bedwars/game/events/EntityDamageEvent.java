package xemii16.ecraft.bedwars.game.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xemii16.ecraft.bedwars.game.Game;

public class EntityDamageEvent implements Listener {

    private Game game;

    @EventHandler
    public void event (org.bukkit.event.entity.EntityDamageEvent e){
        if (e.getEntityType().equals(EntityType.PLAYER)){
            Player player = (Player) e.getEntity();
            if (e.getDamage() >= player.getHealth()){
                e.setCancelled(true);
                game.onPlayerDeath(player);


            }
        }


    }
}
