package xemii16.ecraft.bedwars.arena.events.voids;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xemii16.ecraft.bedwars.arena.Arena;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;
import static xemii16.ecraft.bedwars.arena.Arena.prefix;

public class ArenasJoinGUI {

    private Arena arena;

    public void event (InventoryClickEvent e){


        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Арени БедВарсу")){
            if(e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)){
                String arenaName = e.getCurrentItem().getItemMeta().getDisplayName();
                String[] name = ChatColor.stripColor(arenaName).split(" ");
                Arena arena = ArenaHashMap.get(name[0]);
                BossBar bossBar = arena.getBossBar();
                Inventory inventory = player.getInventory();
                Location location = arena.getLobbySpawn();
                player.teleport(location);
                ArrayList<Player> players = arena.getPlayers();
                players.add(player);
                arena.setPlayers(players);
                bossBar.addPlayer(player);
                arena.joinPlayer(player);
                e.setCancelled(true);
                player.closeInventory();
                inventory.clear();
                itemStack(inventory, Material.RED_BED, "Команди", 36);
                itemStack(inventory, Material.IRON_DOOR, "Вийти", 46);
                player.updateInventory();
                int NumberOfTeams = arena.getNumberOfTeams();
                int PlayersPerTeam = arena.getPlayersPerTeam();
                int allPlayers = NumberOfTeams * PlayersPerTeam;
                if (arena.getPlayers().size() == allPlayers){
                        arena.startTimer(15, arena);
                }
                if (arena.getPlayers().size() < allPlayers){
                    double size = arena.getPlayers().size();
                    double progress = size / allPlayers;
                    bossBar.setProgress(progress);

                }
            }
        }

    }

    private void itemStack (Inventory inventory, Material material, String displayName, Integer index){
        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(index, itemStack);
    }
}
