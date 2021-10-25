package dev.nanosync.xmutante.events;

import dev.nanosync.xmutante.mutant.XMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class XMenuCancelEvent implements Listener {

    XMenu xMenu = new XMenu();

    @EventHandler
    public void onClickMenuCancel(InventoryClickEvent event){
        if (event.getInventory().getName().equals(xMenu.getInventoryName())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onMoveMenuItemCancel(InventoryMoveItemEvent event){
        if (event.getSource().getName().equals(xMenu.getInventoryName())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickupMenuItemCancel(InventoryPickupItemEvent event){
        if (event.getInventory().getName().equals(xMenu.getInventoryName())){
            event.setCancelled(true);
        }
    }
}
