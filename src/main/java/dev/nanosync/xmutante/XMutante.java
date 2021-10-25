package dev.nanosync.xmutante;

import dev.nanosync.xmutante.events.XMenuCancelEvent;
import dev.nanosync.xmutante.custom.XMenuGlowEnchant;
import dev.nanosync.xmutante.events.XMenuPowersEvent;
import dev.nanosync.xmutante.mutant.XPlayer;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class XMutante extends JavaPlugin {

    @Override
    public void onEnable() {
        registerGlow();

        getCommand("mutant").setExecutor(new XPlayer());

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new XMenuCancelEvent(), this);
        pm.registerEvents(new XMenuPowersEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            XMenuGlowEnchant glow = new XMenuGlowEnchant();
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
