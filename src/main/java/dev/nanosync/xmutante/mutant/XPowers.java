package dev.nanosync.xmutante.mutant;

import org.bukkit.entity.Player;

public class XPowers {
    private Player player;
    public XPowers(Player player){
        this.player = player;
    }

    public void toggleHighSpeed(boolean enable){
        if (enable){
            player.setWalkSpeed(1);
            player.setFlySpeed(1);
        } else {
            player.setWalkSpeed(0.2f);
            player.setFlySpeed(0.1f);
        }

    }

    public void disableAll(){
        toggleHighSpeed(false);
    }
}
