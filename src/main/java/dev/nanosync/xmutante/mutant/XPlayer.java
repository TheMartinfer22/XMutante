package dev.nanosync.xmutante.mutant;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XPlayer implements CommandExecutor {
    private org.bukkit.entity.Player player;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        this.player = p;

        new XMenu(player).openMenu();

        return false;
    }
}
