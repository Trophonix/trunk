package com.trophonix.trunkexample;

import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.api.economy.EconomyResponse;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.exceptions.HookRegisterException;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lucas on 4/13/17.
 */
public class TrunkExample extends JavaPlugin {

    private TrunkEconomy economy;

    @Override
    public void onEnable() {
        try {
            economy = new ExampleEconomyHook(this);
            Trunk.register(economy);
        } catch (HookRegisterException e) {
            e.printStackTrace();
        }
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
                    double amount = Double.parseDouble(args[1]);
                    EconomyResponse response = economy.deposit(args[0], amount);
                    if (response.getResult().equals(EconomyResponse.Result.SUCCESS)) {
                        player.sendMessage(ChatColor.GREEN + "Sent " + ChatColor.DARK_GREEN + economy.currencySymbol() + economy.format(amount) + ChatColor.GREEN + " to " + args[0]);
                    } else {
                        player.sendMessage(ChatColor.RED + (response.hasMessage() ? response.getMessage() : "Something went wrong!"));
                    }
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
                } else {
                    sender.sendMessage(ChatColor.RED + (response.hasMessage() ? response.getMessage() : "Something went wrong!"));
                }
            } catch (NumberFormatException ex) {
                sender.sendMessage(ChatColor.RED + "Not a number: " + args[1]);
            }
            return true;
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
