package dev.nanosync.xmutante.util;

import org.bukkit.ChatColor;

public class MessageUtil {
    public static String prefix = ChatColor.YELLOW + "[XMutante] ";
    public static String noPermissionCommand = prefix + ChatColor.RED +  "Você não têm permissão para executar esse comando.";
    public static String youNotMutantCommand = prefix + ChatColor.RED + "Você não é um mutante, então não pode executar esse comando";
    public static String onlyPlayerCommand = prefix + ChatColor.RED + "Somente jogadores podem executar esse comando.";
}
