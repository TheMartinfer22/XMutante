package dev.nanosync.xmutante.schendules;

import dev.nanosync.xmutante.XMutante;
import dev.nanosync.xmutante.entities.XPlayer;
import org.bukkit.Bukkit;

public class XPlayerMutantScheduler {
    public XPlayerMutantScheduler(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(XMutante.getInstance(), () -> {
            new XPlayer().randomMutant();
        }, 1, XMutante.getInstance().getConfig().getInt("TempoDeEscolhaMutanteMinutos") * 1200L);
    }
}
