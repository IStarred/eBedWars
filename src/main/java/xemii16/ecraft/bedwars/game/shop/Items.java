package xemii16.ecraft.bedwars.game.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class Items {

    Inventory shop = Bukkit.createInventory(null, 27);
    private ItemStack itemStack (Material material, Integer amount, String displayName, List<String> lore, Map<Enchantment, Integer> enchantmentIntegerMap){
        ItemStack itemStack = new ItemStack(material, amount);
        itemStack.addUnsafeEnchantments(enchantmentIntegerMap);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private ItemStack itemStack (Material material, Integer amount, String displayName, List<String> lore){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private ItemStack itemStack (Material material, Integer amount, String displayName){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private ItemStack itemStack (Material material, Integer amount){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private ItemStack itemStack (Material material, Integer amount, String displayName, Map<Enchantment, Integer> enchantmentIntegerMap){
        ItemStack itemStack = new ItemStack(material, amount);
        itemStack.addUnsafeEnchantments(enchantmentIntegerMap);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private ItemStack itemStack (Material material, Integer amount, List<String> lore, Map<Enchantment, Integer> enchantmentIntegerMap){
        ItemStack itemStack = new ItemStack(material, amount);
        itemStack.addUnsafeEnchantments(enchantmentIntegerMap);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private ItemStack itemStack (Material material, Integer amount, List<String> lore){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
