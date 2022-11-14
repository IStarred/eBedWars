package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class TeamAdderGUI {

    public void event (PlayerInteractEvent e){
        if (!e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("Команди")) return;
        Inventory inventory = Bukkit.createInventory(e.getPlayer(), 9);
        for (Arena arena : ArenaHashMap.values()){
            if (arena.getLobbySpawn().getWorld().equals(e.getPlayer().getWorld())){
                for (Team team : arena.getGame().getTeams()){
                    ItemStack itemStack = new ItemStack(team.getBedMaterial());
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(team.getChatColor() + team.getGameName());
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("Гравців" + team.getPlayers().size() + "/" + arena.getPlayersPerTeam());
                    itemStack.setItemMeta(itemMeta);
                    inventory.addItem(itemStack);
                }
            }

        }
        e.getPlayer().openInventory(inventory);
    }
}
