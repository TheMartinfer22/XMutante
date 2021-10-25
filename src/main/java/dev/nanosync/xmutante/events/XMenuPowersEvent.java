package dev.nanosync.xmutante.events;

import dev.nanosync.xmutante.custom.XMenuGlowEnchant;
import dev.nanosync.xmutante.entities.XMenu;
import dev.nanosync.xmutante.entities.XPowers;
import dev.nanosync.xmutante.util.MessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class XMenuPowersEvent implements Listener {

    XMenuGlowEnchant xMenuGlowEnchant = new XMenuGlowEnchant();
    XMenu xMenu = new XMenu();

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
        XPowers xPowers = new XPowers((Player) event.getView().getPlayer());
        if (!event.getInventory().getName().equals(xMenu.getInventoryName())) return;
        switch (event.getSlot()) {
            case 0:
                if (isEnabledHighSpeed) {
                    event.getView().getPlayer().sendMessage(MessageUtil.prefix + ChatColor.RED + "Você desabilitou a velocidade rápida.");
                    xPowers.toggleHighSpeed(false);
                    isEnabledHighSpeed = false;
                } else {
                    event.getView().getPlayer().sendMessage(MessageUtil.prefix + ChatColor.GREEN + "Você habilitou a velocidade rápida.");
                    xPowers.toggleHighSpeed(true);
                    isEnabledHighSpeed = true;
                }
                break;
        }
        event.getView().getPlayer().closeInventory();
    }
}
