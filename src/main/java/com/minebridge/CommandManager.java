package com.minebridge;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.security.SecureRandom;
import java.math.BigInteger;

public class CommandManager implements CommandExecutor {

    private final MineBridge plugin;

    public CommandManager(MineBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("minebridge.admin")) {
            sender.sendMessage("§cNo permission.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§6/mb api §7- Generate Key");
            sender.sendMessage("§6/mb reload §7- Reload Config & API");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "api":
                String key = new BigInteger(130, new SecureRandom()).toString(32);
                plugin.getConfig().set("api-key", key);
                plugin.saveConfig();
                sender.sendMessage("§aNew Key: §f" + key);
                break;

            case "reload":
                plugin.reloadConfig();
                plugin.stopApi();
                plugin.startApi();
                sender.sendMessage("§aMineBridge Reloaded!");
                break;
                
            case "test":
                sender.sendMessage("§aStatus: Online");
                break;
        }
        return true;
    }
}