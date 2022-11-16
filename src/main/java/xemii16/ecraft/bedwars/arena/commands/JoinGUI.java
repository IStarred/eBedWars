package xemii16.ecraft.bedwars.arena.commands;

import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xemii16.ecraft.bedwars.arena.Arena;

import java.awt.*;
import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class JoinGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory inventory = Bukkit.createInventory(player,27, ChatColor.AQUA + "Арени БедВарсу");
            int index = 10;
            for (Arena arena : ArenaHashMap.values()){
                if (index <= 16){
                    ItemStack itemStack = new ItemStack(Material.EMERALD_BLOCK, 1);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(ChatColor.of(new Color(255, 213, 0)) + "" + ChatColor.BOLD + arena.getArenaName() + " " +  arena.getPlayersPerTeam() + "x" + arena.getNumberOfTeams());
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.WHITE + "Гравців: " + arena.getPlayers().size());
                    itemMeta.setLore(lore);
                    itemStack.setItemMeta(itemMeta);
                    inventory.setItem(index, itemStack);
                    index += 1;
                }




            }



            player.openInventory(inventory);
        }
        return true;
    }
}
