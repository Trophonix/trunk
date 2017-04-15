package com.trophonix.trunkexample;

import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import com.trophonix.trunk.exceptions.HookRegisterException;
import com.trophonix.trunk.exceptions.UnknownPlayerException;
import net.milkbowl.vault.chat.Chat;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

/**
 * Created by Lucas on 4/13/17.
 */
public class TrunkExample extends JavaPlugin implements Listener {

    private TrunkEconomy economy;
    private TrunkPermissions permissions;
    private TrunkChat chat;

    @Override
    public void onEnable() {
        try {
            // Register economy
            economy = new ExampleEconomy(this);
            Trunk.getInstance().register(economy);

            // Register permissions
            permissions = new ExamplePermissions(this);
            Trunk.getInstance().register(permissions);

            // Register chat
            Trunk.getInstance().register(new ExampleChat(this));

            // Get chat back from Trunk
            // Normally, this would be done in a separate plugin - one plugin sets it up, another uses it
            chat = Trunk.getInstance().getHook(TrunkChat.class);
        } catch (HookRegisterException e) {
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
        getServer().getPluginManager().registerEvents(this, this);
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        if (rsp != null) {
            Chat chat = rsp.getProvider();
            if (chat != null) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Gamer's Prefix: " + ChatColor.RESET + chat.getPlayerPrefix("world", "Gamer"));
            }
        }
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("prefix") && args.length > 0) {
            try {
                if (args.length == 1) {
                    sender.sendMessage(ChatColor.BLUE + args[0] + "'s prefix: " + ChatColor.RESET + "\"" + chat.getPrefix(args[0]) + "\"");
                    return true;
                } else {
                    String prefix;
                    if (args.length == 2)
                        prefix = args[1];
                    else
                        prefix = StringUtils.join(Arrays.copyOfRange(args, 1, args.length), ' ');
                    if (prefix.startsWith("\"") && prefix.endsWith("\"") && prefix.length() > 2)
                        prefix = prefix.substring(1, prefix.length() - 1);
                    chat.setPrefix(args[0], prefix);
                    sender.sendMessage(ChatColor.BLUE + "Set " + args[0] + "'s prefix to: " + ChatColor.RESET + "\"" + prefix + "\"");
                    return true;
                }
            } catch (UnknownPlayerException ex) {
                sender.sendMessage(ChatColor.RED + "Couldn't find player: " + args[0]);
            }
        }

        sender.sendMessage(new String[]{
                "",
                ChatColor.GREEN + "/bal " + ChatColor.WHITE + "Check your balance",
                ChatColor.GREEN + "/pay <player> <amount> " + ChatColor.WHITE + "Pay someone",
                ChatColor.RED + "(admins/console) " + ChatColor.GREEN + "/eco " + ChatColor.WHITE + "Admin commands",
                ""
        });
        return true;
    }

}
