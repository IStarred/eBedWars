package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xemii16.ecraft.bedwars.arena.Arena;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class ArenasJoinGUI {

    public void event (InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Арени БедВарсу")){
                if(e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)){
                    String arenaName = e.getCurrentItem().getItemMeta().getDisplayName();
                    String[] name = arenaName.split(" ");
                    Arena arena = ArenaHashMap.get(name[0]);
                    Location location = arena.getLobbySpawn();
                    player.teleport(location);
                    ArrayList<Player> players = arena.getPlayers();
                    players.add(player);
                    arena.setPlayers(players);
                    for (Player player1 : arena.getPlayers()){
                        player1.sendMessage("До гри приєднався" + player1.getDisplayName());
                    }
                    e.setCancelled(true);
                    player.closeInventory();
                    player.getInventory().clear();
                    ItemStack itemStack = new ItemStack(Material.RED_BED, 1);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName("Команди");
                    itemStack.setItemMeta(itemMeta);
                    player.getInventory().setItem(36, itemStack);
                    ItemStack itemStack1 = new ItemStack(Material.IRON_DOOR, 1);
                    ItemMeta itemMeta1 = itemStack1.getItemMeta();
                    itemMeta1.setDisplayName("Вийти");
                    itemStack1.setItemMeta(itemMeta1);
                    player.getInventory().setItem(46, itemStack1);
                    int NumberOfTeams = arena.getNumberOfTeams();
                    int PlayersPerTeam = arena.getPlayersPerTeam();
                    int allPlayers = NumberOfTeams * PlayersPerTeam;
                    if (arena.getPlayers().size() == allPlayers){
                        arena.startTimer(5, arena);
                    }
                }
        }

    }
}
