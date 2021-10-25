package dev.nanosync.xmutante.mutant;

import dev.nanosync.xmutante.XMutante;
import dev.nanosync.xmutante.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class XPlayer implements Listener {
    // Classe reponsável por efinir quem é o mutante
    private Player player;

    public Player getMutant(){
        if (XMutante.getInstance().getConfig().getString("Mutante").equals("Nenhum")){
            randomMutant();
        }
        return Bukkit.getPlayer(XMutante.getInstance().getConfig().getString("Mutante"));
    }

    public void setMutant(Player player){
        XMutante.getInstance().getConfig().set("Mutante", player.getName());
        XMutante.getInstance().saveConfig();
        this.player = player;
    }

    public void randomMutant(){
        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
        Player player = players.get(new Random().nextInt(Bukkit.getOnlinePlayers().size()));
        setMutant(player);
        players.forEach(jogador -> {
            jogador.sendTitle(MessageUtil.prefix, "O jogador " + player.getName() + " agora é mutante!", 1, 15, 1);
            jogador.playNote(player.getPlayer().getLocation(), Instrument.BELL, Note.flat(1, Note.Tone.E));
        });
        player.sendMessage(MessageUtil.prefix + "Veja seus comandos em /mutante!");
    }

    public void clearMutant(){
        XMutante.getInstance().getConfig().set("Mutante", "Nenhum");
        XMutante.getInstance().saveConfig();
    }

    @EventHandler
    public void onPlayerLeft(PlayerQuitEvent event) {
        if (XMutante.getInstance().getConfig().getString("Mutante").equals("Nenhum")) return;

        if (getMutant().getPlayer().equals(event.getPlayer())) {
            XPowers xPowers = new XPowers(getMutant());
            xPowers.disableAll();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (XMutante.getInstance().getConfig().getString("Mutante").equals("Nenhum")) return;

        if (getMutant().getPlayer().equals(event.getPlayer())) {
            XPowers xPowers = new XPowers(getMutant());
            xPowers.disableAll();
        }
    }
}
