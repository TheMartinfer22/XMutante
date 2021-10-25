package dev.nanosync.xmutante.mutant;

import org.bukkit.entity.Player;

public class XPowers {
    private Player player;
    public XPowers(Player player){
        this.player = player;
    }

    public void enableColisor(){
        player.setCollidable(false);
    }

    public void disableColisor(){
        player.setCollidable(true);
    }

    public void enableHighSpeed(){
        player.setWalkSpeed(2);
        player.setFlySpeed(2);
    }

    public void disableHighSpeed(){
        player.setWalkSpeed(0.1f);
        player.setFlySpeed(0.2f);
    }
}
