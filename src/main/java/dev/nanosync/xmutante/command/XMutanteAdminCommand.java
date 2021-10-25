package dev.nanosync.xmutante.command;

import dev.nanosync.xmutante.XMutante;
import dev.nanosync.xmutante.mutant.XPlayer;
import dev.nanosync.xmutante.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XMutanteAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(MessageUtil.noPermissionCommand);
            return true;
        }

        if (args.length < 1){
            new XPlayer().randomMutant();
            sender.sendMessage(MessageUtil.prefix + "O jogador escolhido foi " + XMutante.getInstance().getConfig().getString("Mutant") + "!");
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);
        new XPlayer().setMutant(player);
        sender.sendMessage(MessageUtil.prefix + "Você setou o jogador " + XMutante.getInstance().getConfig().getString("Mutant") + " como mutante");
        return false;
    }
}
