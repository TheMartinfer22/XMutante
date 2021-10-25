package dev.nanosync.xmutante.command;

import dev.nanosync.xmutante.XMutante;
import dev.nanosync.xmutante.mutant.XMenu;
import dev.nanosync.xmutante.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XMutantUserCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage(MessageUtil.onlyPlayerCommand);
            return true;
        }

        if (XMutante.getInstance().getConfig().getString("Mutant").equals(sender.getName())){
            new XMenu((Player) sender).openMenu();
        } else {
            sender.sendMessage(MessageUtil.youNotMutantCommand);
        }
        return false;
    }
}
