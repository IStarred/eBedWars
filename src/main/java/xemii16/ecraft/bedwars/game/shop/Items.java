package xemii16.ecraft.bedwars.game.shop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {



    public void setShop (Inventory shop, Player player){
        Inventory main = Bukkit.createInventory(player, 54, ChatColor.BOLD + "" + ChatColor.YELLOW + "Супермаркет");
        main.setItem(0 , itemStack(Material.NETHERITE_CHESTPLATE, 1, "Броня"));
        main.setItem(1, itemStack(Material.NETHERITE_SWORD, 1, "Зброя"));
        main.setItem(2, itemStack(Material.NETHERITE_PICKAXE, 1, "Кайла"));
        main.setItem(3, itemStack(Material.COOKED_PORKCHOP, 1, "Їжа"));
        main.setItem(5, itemStack(Material.SANDSTONE, 1, "Блоки"));
        main.setItem(6, itemStack(Material.TNT, 1, "Штучки"));
        main.setItem(7, itemStack(Material.ENCHANTING_TABLE, 1, "Зачарування"));
        main.setItem(8, itemStack(Material.BEACON, 1, "Ефекти"));
        for (int i = 9; i < 17; i++){
            main.setItem(i, itemStack(Material.ORANGE_STAINED_GLASS, 1, ""));
        }
    }

    public void setArmor (Inventory main, Player player){
        HashMap <Enchantment, Integer> enchantment = new HashMap<>();
        enchantment.clear();
        main.clear();
        setShop(main, player);
        enchantment.put(Enchantment.ARROW_DAMAGE, 1);
        main.setItem(0, itemStack(Material.NETHERITE_CHESTPLATE, 1, "Броня", enchantment));
        enchantment.clear();

        main.setItem(18, itemStack(Material.LEATHER_HELMET, 1));
        main.setItem(27, itemStack(Material.LEATHER_CHESTPLATE, 1));
        main.setItem(36, itemStack(Material.LEATHER_LEGGINGS, 1));
        main.setItem(45, itemStack(Material.LEATHER_BOOTS, 1));

        main.setItem(20, itemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        main.setItem(29, itemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        main.setItem(38, itemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        main.setItem(47, itemStack(Material.CHAINMAIL_CHESTPLATE, 1));

        main.setItem(22, itemStack(Material.IRON_HELMET, 1));
        main.setItem(31, itemStack(Material.IRON_CHESTPLATE, 1));
        main.setItem(40, itemStack(Material.IRON_LEGGINGS, 1));
        main.setItem(49, itemStack(Material.IRON_BOOTS, 1));

        main.setItem(24, itemStack(Material.DIAMOND_HELMET, 1));
        main.setItem(33, itemStack(Material.DIAMOND_CHESTPLATE, 1));
        main.setItem(42, itemStack(Material.DIAMOND_LEGGINGS, 1));
        main.setItem(51, itemStack(Material.DIAMOND_BOOTS, 1));

        main.setItem(26, itemStack(Material.NETHERITE_CHESTPLATE, 1));
        main.setItem(35, itemStack(Material.NETHERITE_CHESTPLATE, 1));
        main.setItem(44, itemStack(Material.NETHERITE_CHESTPLATE, 1));
        main.setItem(53, itemStack(Material.NETHERITE_CHESTPLATE, 1));


    }

    public void setWeapon (Inventory main, Player player){
        HashMap<Enchantment, Integer> enchantment = new HashMap<>();
        enchantment.clear();
        main.clear();
        setShop(main, player);
        enchantment.put(Enchantment.ARROW_DAMAGE, 1);
        main.setItem(2, itemStack(Material.NETHERITE_SWORD, 1, "Зброя", enchantment));
        enchantment.clear();

        main.setItem(19, itemStack(Material.WOODEN_AXE, 1));
        main.setItem(20 , itemStack(Material.STICK, 1));
        main.setItem(21, itemStack(Material.GOLDEN_SWORD, 1));
        main.setItem(22, itemStack(Material.GOLDEN_SWORD, 1));
        main.setItem(23, itemStack(Material.IRON_SWORD, 1));
        main.setItem(24, itemStack(Material.DIAMOND_SWORD, 1));
        main.setItem(25, itemStack(Material.NETHERITE_SWORD, 1));

        main.setItem(38, itemStack(Material.BOW, 1));
        main.setItem(39, itemStack(Material.BOW, 1));
        main.setItem(40, itemStack(Material.BOW, 1));
        main.setItem(41, itemStack(Material.BOW, 1));
        main.setItem(42, itemStack(Material.BOW, 1));
        main.setItem(49, itemStack(Material.ARROW, 1));


    }

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
