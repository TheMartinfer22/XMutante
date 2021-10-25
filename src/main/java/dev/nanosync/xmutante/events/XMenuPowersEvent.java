package dev.nanosync.xmutante.events;

import dev.nanosync.xmutante.custom.XMenuGlowEnchant;
import dev.nanosync.xmutante.mutant.XMenu;
import dev.nanosync.xmutante.mutant.XPowers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class XMenuPowersEvent implements Listener {

    XMenuGlowEnchant xMenuGlowEnchant = new XMenuGlowEnchant();
    XMenu xMenu = new XMenu();
//    XPowers xPowers = new XPowers();

    private boolean isEnabledHighSpeed = false;
    private boolean isEnabledColisor = false;

    @EventHandler
    public void onOpenInventory(InventoryOpenEvent event){
        if (event.getInventory().getName().equals(xMenu.getInventoryName())){
            if (isEnabledHighSpeed){
                xMenuGlowEnchant.setGlow(0, event.getInventory(), true);
            }

            if (isEnabledColisor){
                xMenuGlowEnchant.setGlow(1, event.getInventory(), true);
            }
        }
    }

    @EventHandler
    public void clickPowers(InventoryClickEvent event){
        if (!event.getInventory().getName().equals(xMenu.getInventoryName())) return;
        switch (event.getSlot()) {
            case 0:
                if (isEnabledHighSpeed) {
                    event.getView().getPlayer().sendMessage("V Desabilitado");
                    isEnabledHighSpeed = false;
                } else {
                    event.getView().getPlayer().sendMessage("V Habilitado");
                    isEnabledHighSpeed = true;
                }
                break;
            case 1:
                if (isEnabledColisor) {
                    event.getView().getPlayer().sendMessage("C Desabilitado");
                    isEnabledColisor = false;
                } else {
                    event.getView().getPlayer().sendMessage("C Habilitado");
                    isEnabledColisor = true;
                }
                break;
        }
        event.getView().getPlayer().closeInventory();
    }
}
