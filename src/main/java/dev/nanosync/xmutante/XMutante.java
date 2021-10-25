package dev.nanosync.xmutante;

import dev.nanosync.xmutante.command.XMutantUserCommand;
import dev.nanosync.xmutante.command.XMutanteAdminCommand;
import dev.nanosync.xmutante.events.XMenuCancelEvent;
import dev.nanosync.xmutante.custom.XMenuGlowEnchant;
import dev.nanosync.xmutante.events.XMenuPowersEvent;
import dev.nanosync.xmutante.entities.XPlayer;
import dev.nanosync.xmutante.schendules.XPlayerMutantScheduler;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class XMutante extends JavaPlugin {

    @Override
    public void onEnable() {
        registerGlow();
        saveDefaultConfig();

        getCommand("mutante").setExecutor(new XMutantUserCommand());
        getCommand("setmutante").setExecutor(new XMutanteAdminCommand());

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new XMenuCancelEvent(), this);
        pm.registerEvents(new XMenuPowersEvent(), this);

        pm.registerEvents(new XPlayer(), this);

        new XPlayerMutantScheduler();
    }

    @Override
    public void onDisable() {
    }

    public static XMutante getInstance(){
        return getPlugin(XMutante.class);
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
