package com.trophonix.trunk.api.economy;

import com.trophonix.trunk.api.TrunkHook;
import com.trophonix.trunk.UUIDStore;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * Created by Lucas on 4/12/17.
 */
public abstract class TrunkEconomy implements TrunkHook {

    private Plugin plugin;

    public TrunkEconomy(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * @return How many digits to round fractions to
     */
    public abstract int getDigits();

    /**
     * Format a number into a 'pretty string'
     * @param amount Number to format
     * @return Formatted number
     */
    public abstract String format(Number amount);

    /**
     * @return The currency's name in plural form
     */
    public abstract String currencyNamePlural();

    /**
     * @return The currency's name in singular form
     */
    public abstract String currencyNameSingular();

    /**
     * @return The currency's representative symbol
     */
    public abstract String currencySymbol();

    /**
     * Check whether a player has an account (saved balance)
     * @param uniqueId The player's uuid
     * @return Whether the player has an account
     */
    public abstract boolean hasAccount(UUID uniqueId);

    /**
     * Check whether a player has an account (saved balance)
     * @param player The player
     * @return Whether the player has an account
     */
    public boolean hasAccount(OfflinePlayer player) {
        return hasAccount(player.getUniqueId());
    }

    /**
     * Check whether a player has an account (saved balance) in a specific world
     * Returns whether they have a global account if not overridden
     * @param uniqueId The player's uuid
     * @param world The world
     * @return Whether the player has an account
     */
    public boolean hasAccount(UUID uniqueId, String world) {
        return hasAccount(uniqueId);
    }

    /**
     * Check whether a player has an account (saved balance) in a specific world
     * Returns whether they have a global account if not overridden
     * @param player The player
     * @param world The world
     * @return Whether the player has an account
     */
    public boolean hasAccount(OfflinePlayer player, String world) {
        return hasAccount(player.getUniqueId(), world);
    }

    /**
     * Create an account for a player
     * @param uniqueId The player's uuid
     * @return A response
     */
    public abstract EconomyResponse createAccount(UUID uniqueId);

    /**
     * Create an account for a player
     * @param player The player
     * @return A response
     */
    public EconomyResponse createAccount(OfflinePlayer player) {
        return createAccount(player.getUniqueId());
    }

    /**
     * Create an account for a player in a specific world
     * Redirects to creating a global account if not overridden
     * @param uniqueId The player's uuid
     * @param world The world
     * @return A response
     */
    public EconomyResponse createAccount(UUID uniqueId, String world) {
        return createAccount(uniqueId);
    }

    /**
     * Create an account for a player in a specific world
     * Redirects to creating a global account if not overridden
     * @param player The player
     * @param world The world
     * @return A response
     */
    public EconomyResponse createAccount(OfflinePlayer player, String world) {
        return createAccount(player.getUniqueId(), world);
    }

    /**
     * Get a player's global balance
     * @param uniqueId The player's unique id
     * @return The player's global balance
     */
    public abstract Number getBalance(UUID uniqueId);

    /**
     * Get a player's global balance
     * @param player The player
     * @return The player's global balance
     */
    public Number getBalance(OfflinePlayer player) {
        return getBalance(player.getUniqueId());
    }

    public Number getBalance(String name) { return getBalance(UUIDStore.getUniqueIdIgnoreCase(name)); }

    /**
     * Get a player's balance in a specific world
     * Returns the player's global balance if not overridden
     * @param uniqueId The player's unique id
     * @param world The world
     * @return The player's balance in the world
     */
    public Number getBalance(UUID uniqueId, String world) {
        return getBalance(uniqueId);
    }

    /**
     * Get a player's balance in a specific world
     * Returns the player's global balance if not overridden
     * @param player The player
     * @param world The world
     * @return The player's balance in the world
     */
    public Number getBalance(OfflinePlayer player, String world) {
        return getBalance(player.getUniqueId(), world);
    }

    public Number getBalance(String name, String world) { return getBalance(UUIDStore.getUniqueIdIgnoreCase(name), world); }

    /**
     * Set a player's balance
     * @param uniqueId The player's uuid
     * @param balance The player's new balance
     * @return A response
     */
    public abstract EconomyResponse setBalance(UUID uniqueId, Number balance);

    public EconomyResponse setBalance(String name, Number balance) {
        return setBalance(UUIDStore.getUniqueIdIgnoreCase(name), balance);
    }

    /**
     * Set a player's balance
     * @param player The player
     * @param balance The player's new balance
     * @return A response
     */
    public EconomyResponse setBalance(OfflinePlayer player, Number balance) {
        return setBalance(player.getUniqueId(), balance);
    }

    /**
     * Set a player's balance in a specific world
     * Redirects to setting the player's global balance if not overridden
     * @param uniqueId The player's uuid
     * @param balance The player's new balance
     * @param world The world
     * @return A response
     */
    public EconomyResponse setBalance(UUID uniqueId, Number balance, String world) {
        return setBalance(uniqueId, balance);
    }

    /**
     * Set a player's balance in a specific world
     * Redirects to setting the player's global balance if not overridden
     * @param player The player
     * @param balance The player's new balance
     * @param world The world
     * @return A response
     */
    public EconomyResponse setBalance(OfflinePlayer player, Number balance, String world) {
        return setBalance(player.getUniqueId(), balance, world);
    }

    public EconomyResponse setBalance(String name, Number balance, String world) {
        return setBalance(UUIDStore.getUniqueIdIgnoreCase(name), balance, world);
    }

    /**
     * Check whether a player's balance exceeds an amount
     * @param uniqueId The player's uuid
     * @param amount Amount to check
     * @return Whether the player has the amount
     */
    public abstract boolean has(UUID uniqueId, Number amount);

    /**
     * Check whether a player's balance exceeds an amount
     * @param player The player
     * @param amount Amount to check
     * @return Whether the player has the amount
     */
    public boolean has(OfflinePlayer player, Number amount) {
        return has(player.getUniqueId(), amount);
    }

    public boolean has(String name, Number amount) { return has(UUIDStore.getUniqueIdIgnoreCase(name), amount); }

    /**
     * Check whether a player's balance in a specific world exceeds an amount
     * Redirects to global balance if not overridden
     * @param uniqueId The player's uuid
     * @param amount Amount to check
     * @param world The world
     * @return Whether the player has the amount
     */
    public boolean has(UUID uniqueId, Number amount, String world) {
        return has(uniqueId, amount);
    }

    /**
     * Check whether a player's balance in a specific world exceeds an amount
     * Redirects to global balance if not overridden
     * @param player The player
     * @param amount Amount to check
     * @param world The world
     * @return Whether the player has the amount
     */
    public boolean has(OfflinePlayer player, Number amount, String world) {
        return has(player.getUniqueId(), amount, world);
    }

    public boolean has(String name, Number amount, String world) {
        return has(UUIDStore.getUniqueIdIgnoreCase(name), amount, world);
    }

    /**
     * Deposit into a player's balance
     * @param uniqueId The player's uuid
     * @param amount Amount to deposit
     * @return A response
     */
    public abstract EconomyResponse deposit(UUID uniqueId, Number amount);

    /**
     * Deposit into a player's balance
     * @param player The player's uuid
     * @param amount Amount to deposit
     * @return A response
     */
    public EconomyResponse deposit(OfflinePlayer player, Number amount) {
        return deposit(player.getUniqueId(), amount);
    }

    public EconomyResponse deposit(String name, Number amount) {
        return deposit(UUIDStore.getUniqueIdIgnoreCase(name), amount);
    }

    /**
     * Deposit into a player's balance in a specific world
     * Redirects to global balance if not overridden
     * @param uniqueId The player's uuid
     * @param amount Amount to deposit
     * @param world The world
     * @return A response
     */
    public EconomyResponse deposit(UUID uniqueId, Number amount, String world) {
        return deposit(uniqueId, amount);
    }

    /**
     * Deposit into a player's balance in a specific world
     * @param player The player's uuid
     * @param amount Amount to deposit
     * @param world The world
     * @return A response
     */
    public EconomyResponse deposit(OfflinePlayer player, Number amount, String world) {
        return deposit(player.getUniqueId(), amount, world);
    }

    public EconomyResponse deposit(String name, Number amount, String world) {
        return deposit(UUIDStore.getUniqueIdIgnoreCase(name), amount, world);
    }

    /**
     * Withdraw from a player's balance
     * @param uniqueId The player's uuid
     * @param amount Amount to withdraw
     * @return A response
     */
    public abstract EconomyResponse withdraw(UUID uniqueId, Number amount);

    /**
     * Withdraw from a player's balance
     * @param player The player
     * @param amount Amount to withdraw
     * @return A response
     */
    public EconomyResponse withdraw(OfflinePlayer player, Number amount) {
        return withdraw(player.getUniqueId(), amount);
    }

    /**
     * Withdraw from a player's balance in a specific world
     * Redirects to global balance if not overridden
     * @param uniqueId The player's uuid
     * @param amount Amount to withdraw
     * @param world The world
     * @return A response
     */
    public EconomyResponse withdraw(UUID uniqueId, Number amount, String world) {
        return withdraw(uniqueId, amount);
    }

    /**
     * Withdraw from a player's balance in a specific world
     * Redirects to global balance if not overridden
     * @param player The player
     * @param amount Amount to withdraw
     * @param world The world
     * @return A response
     */
    public EconomyResponse withdraw(OfflinePlayer player, Number amount, String world) {
        return withdraw(player.getUniqueId(), amount, world);
    }

    public EconomyResponse withdraw(String name, Number amount, String world) {
        return withdraw(UUIDStore.getUniqueIdIgnoreCase(name), amount, world);
    }

    /**
     * @return Whether the hook supports banks
     */
    public abstract boolean hasBankSupport();

    /**
     * Create a bank
     * Returns failure if not overridden
     * @param name Name of bank
     * @return A response
     */
    public EconomyResponse createBank(String name) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Delete a bank
     * Returns failure if not overridden
     * @param name Name of bank
     * @return A response
     */
    public EconomyResponse deleteBank(String name) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Get the current balance of a bank (for supporting banks having limited money)
     * Returns Double.MAX_VALUE if not overridden
     * @param bank The bank
     * @return The bank's current balance
     */
    public Number getBankBalance(String bank) {
        return Double.MAX_VALUE;
    }

    /**
     * Set the current balance of a bank (for supporting banks having limited money)
     * Returns failure if not overridden
     * @param bank The bank
     * @param balance New balance
     * @return A response
     */
    public EconomyResponse setBankBalance(String bank, Number balance) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Check whether a bank's balance exceeds an amount
     * Returns getBankBalance >= amount if not overridden
     * @param bank The bank
     * @param amount Amount to check
     * @return Whether the bank has the amount
     */
    public boolean bankHas(String bank, Number amount) {
        return getBankBalance(bank).doubleValue() >= amount.doubleValue();
    }

    /**
     * Get an Iterable of all the banks
     * Returns null if not overridden
     * @return A list of all the banks
     */
    public Iterable<String> getBanks() {
        return null;
    }

    /**
     * Check whether a player has an account (saved balance) in a bank
     * Returns false if hook doesn't support banks
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return Whether the player has an account in the bank
     */
    public boolean hasBankAccount(UUID uniqueId, String bank) {
        return false;
    }

    /**
     * Check whether a player has an account (saved balance) in a bank
     * Returns false if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return Whether the player has an account in the bank
     */
    public boolean hasBankAccount(OfflinePlayer player, String bank) {
        return hasBankAccount(player.getUniqueId(), bank);
    }

    public boolean hasBankAccount(String name, String bank) {
        return hasBankAccount(UUIDStore.getUniqueIdIgnoreCase(name), bank);
    }

    /**
     * Create a bank account in a bank for a player
     * Returns failure if hook doesn't support banks
     * @param uniqueId The player's unique id
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse createBankAccount(UUID uniqueId, String bank) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Create a bank account in a bank for a player
     * Returns failure if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse createBankAccount(OfflinePlayer player, String bank) {
        return createBankAccount(player.getUniqueId(), bank);
    }

    public EconomyResponse createBankAccount(String name, String bank) {
        return createBankAccount(UUIDStore.getUniqueIdIgnoreCase(name), bank);
    }

    /**
     * Delete bank account in a bank for a player
     * Returns failure if hook doesn't support banks
     * @param uniqueId The player's unique id
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse deleteBankAccount(UUID uniqueId, String bank) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Delete bank account in a bank for a player
     * Returns failure if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse deleteBankAccount(OfflinePlayer player, String bank) {
        return deleteBankAccount(player.getUniqueId(), bank);
    }

    public EconomyResponse deleteBankAccount(String name, String bank) {
        return deleteBankAccount(UUIDStore.getUniqueIdIgnoreCase(name), bank);
    }

    /**
     * Get a player's balance in a bank
     * Returns 0 if hook doesn't support banks
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return The player's balance in the bank
     */
    public Number getBankAccountBalance(UUID uniqueId, String bank) {
        return 0;
    }

    /**
     * Get a player's balance in a bank
     * Returns 0 if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return The player's balance in the bank
     */
    public Number getBankAccountBalance(OfflinePlayer player, String bank) {
        return getBankAccountBalance(player.getUniqueId(), bank);
    }

    public Number getBankAccountBalance(String name, String bank) {
        return getBankAccountBalance(UUIDStore.getUniqueIdIgnoreCase(name), bank);
    }

    /**
     * Set a player's balance in a bank
     * Returns failure if hook doesn't support banks
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse setBankAccountBalance(UUID uniqueId, String bank, Number balance) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Set a player's balance in a bank
     * Returns failure if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse setBankAccountBalance(OfflinePlayer player, String bank, Number balance) {
        return setBankAccountBalance(player.getUniqueId(), bank, balance);
    }

    public EconomyResponse setBankAccountBalance(String name, String bank, Number balance) {
        return setBankAccountBalance(UUIDStore.getUniqueIdIgnoreCase(name), bank, balance);
    }

    /**
     * Check whether a player's balance in a bank exceeds an amount
     * Returns false if hook doesn't support banks
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @param amount The amount
     * @return Whether the player's balance in the bank exceeds the amount
     */
    public boolean bankAccountHas(UUID uniqueId, String bank, Number amount) {
        return false;
    }

    /**
     * Check whether a player's balance in a bank exceeds an amount
     * Returns false if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @param amount The amount
     * @return Whether the player's balance in the bank exceeds the amount
     */
    public boolean bankAccountHas(OfflinePlayer player, String bank, Number amount) {
        return bankAccountHas(player.getUniqueId(), bank, amount);
    }

    public boolean bankAccountHas(String name, String bank, Number amount) {
        return bankAccountHas(UUIDStore.getUniqueIdIgnoreCase(name), bank, amount);
    }

    /**
     * Deposit into a player's balance in a bank
     * Returns failure if hook doesn't support banks
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse depositBankAccount(UUID uniqueId, String bank, Number amount) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Deposit into a player's balance in a bank
     * Returns failure if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse depositBankAccount(OfflinePlayer player, String bank, Number amount) {
        return depositBankAccount(player.getUniqueId(), bank, amount);
    }

    public EconomyResponse depositBankAccount(String name, String bank, Number amount) {
        return depositBankAccount(UUIDStore.getUniqueIdIgnoreCase(name), bank, amount);
    }

    /**
     * Withdraw from a player's balance in a bank
     * Returns failure if hook doesn't support banks
     * @param uniqueId The player's uuid
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse withdrawBankAccount(UUID uniqueId, String bank, Number amount) {
        return new EconomyResponse(EconomyResponse.Result.FAILURE, getPlugin().getName() + " does not support this feature!");
    }

    /**
     * Withdraw from a player's balance in a bank
     * Returns failure if hook doesn't support banks
     * @param player The player
     * @param bank The bank
     * @return A response
     */
    public EconomyResponse withdrawBankAccount(OfflinePlayer player, String bank, Number amount) {
        return withdrawBankAccount(player.getUniqueId(), bank, amount);
    }

    public EconomyResponse withdrawBankAccount(String name, String bank, Number amount) {
        return withdrawBankAccount(UUIDStore.getUniqueIdIgnoreCase(name), bank, amount);
    }

}
