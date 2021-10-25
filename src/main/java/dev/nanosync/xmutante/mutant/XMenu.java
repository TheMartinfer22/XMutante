package dev.nanosync.xmutante.mutant;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class XMenu  {

    private Player player;

    public XMenu(Player player){
        this.player = player;
    }

    public XMenu(){
    }

    public Inventory getInventory(){
        Inventory inventory = Bukkit.createInventory(player, 9, "Menu do Mutante");
        inventory.addItem(getHighWalkSpeedItemStack());
        inventory.addItem(getColisorItemStack());
        return inventory;
    }

    public String getInventoryName(){
        return getInventory().getName();
    }

    public void openMenu(){
        player.openInventory(getInventory());
    }

    public ItemStack getHighWalkSpeedItemStack(){
        ItemStack itemStack = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Velocidade Alta");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getColisorItemStack(){
        ItemStack itemStack = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Colisor de Objetos");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
