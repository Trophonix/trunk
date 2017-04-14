package com.trophonix.trunkexample;

import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.UUIDStore;
import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.economy.EconomyResponse;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import com.trophonix.trunk.exceptions.HookRegisterException;
import com.trophonix.trunk.exceptions.UnknownPlayerException;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.UUID;

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
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) { // Check if sender is player for commands that require player object
            Player player = (Player) sender; // Make player object from sender
            if (command.getName().equals("balance")) { // Balance command
                player.sendMessage(ChatColor.GREEN + "Your balance is: " +
                        ChatColor.DARK_GREEN + economy.currencySymbol() + economy.format(economy.getBalance(player)));
                return true;
            } else if (command.getName().equals("pay") && args.length >= 2) {
                try {
                    if (!economy.hasAccount(player)) {
                        economy.createAccount(player);
                    }
                    if (!economy.hasAccount(args[0])) {
                        economy.createAccount(args[0]);
                    }
                    double amount = Double.parseDouble(args[1]);
                    EconomyResponse withdraw = economy.withdraw(player, amount);
                    if (withdraw.getResult().equals(EconomyResponse.Result.SUCCESS)) {
                        EconomyResponse deposit = economy.deposit(args[0], amount);
                        if (deposit.getResult().equals(EconomyResponse.Result.SUCCESS)) {
                            player.sendMessage(ChatColor.GREEN + "Sent " + ChatColor.DARK_GREEN + economy.currencySymbol() + economy.format(amount) + ChatColor.GREEN + " to " + args[0]);
                            attemptMessage(args[0], ChatColor.GREEN + player.getName() + " sent you " + ChatColor.DARK_GREEN + economy.currencySymbol() + economy.format(amount));
                        } else {
                            player.sendMessage(ChatColor.RED + (deposit.hasMessage() ? deposit.getMessage() : "Something went wrong!"));
                            economy.deposit(player, amount);
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + (withdraw.hasMessage() ? withdraw.getMessage() : "Something went wrong!"));
                    }
                } catch (UnknownPlayerException ex) {
                    player.sendMessage(ChatColor.RED + "Couldn't find player: " + args[0]);
                } catch (NumberFormatException ex) {
                    player.sendMessage(ChatColor.RED + "Not a number: " + args[1]);
                }
                return true;
            }
        }

        if (command.getName().equals("ecoset") && args.length >= 2) {
            try {
                double amount = Double.parseDouble(args[1]);
                EconomyResponse response = economy.setBalance(args[0], amount);
                if (response.getResult().equals(EconomyResponse.Result.SUCCESS)) {
                    sender.sendMessage(ChatColor.GREEN + "Set " + args[0] + "'s balance to " + ChatColor.DARK_GREEN + economy.currencySymbol() + economy.format(amount));
                    attemptMessage(args[0], ChatColor.GREEN + "Your balance has been set to " + ChatColor.DARK_GREEN + economy.currencySymbol() + economy.format(amount));
                } else {
                    sender.sendMessage(ChatColor.RED + (response.hasMessage() ? response.getMessage() : "Something went wrong!"));
                }
            }  catch (UnknownPlayerException ex) {
                sender.sendMessage(ChatColor.RED + "Couldn't find player: " + args[0]);
            } catch (NumberFormatException ex) {
                sender.sendMessage(ChatColor.RED + "Not a number: " + args[1]);
            }
            return true;
        }

        if (command.getName().equals("prefix") && args.length > 0) {
            try {
                if (args.length == 1) {
                    sender.sendMessage(ChatColor.BLUE + args[0] + "'s prefix: " + ChatColor.RESET + "\"" + chat.getPrefix(args[0]) + "\"");
                    return true;
                } else {
                    String prefix;
                    if (args.length == 2)
                        prefix = args[1].replace("\"", "");
                    else {
                        prefix = StringUtils.join(Arrays.copyOfRange(args, 1, args.length - 1), ' ').replace("\"", "");
                    }
                    chat.setPrefix(args[0], prefix + (args[args.length - 1].equals("\"") ? " " : ""));
                    sender.sendMessage(ChatColor.BLUE + "Set " + args[0] + "'s prefix to: " + ChatColor.RESET + "\"" + prefix + ((args[args.length - 1].equals("\"")) ? " " : "") + "\"");
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

    @EventHandler // This is the kind of code that would go into something like Essentials Chat
    public void onChat(AsyncPlayerChatEvent event) {
        String prefix = chat.getPrefix(event.getPlayer());
        if (prefix != null && !prefix.isEmpty()) {
            event.setFormat(event.getFormat().replace("%1$s", ChatColor.translateAlternateColorCodes('&', prefix) + "%1$s"));
        }
    }

    private static void attemptMessage(String name, String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) {
                player.sendMessage(message);
            }
        }
    }

}
