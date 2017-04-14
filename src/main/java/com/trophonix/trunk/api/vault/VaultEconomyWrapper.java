package com.trophonix.trunk.api.vault;

import com.google.common.collect.Iterables;
import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.UUIDStore;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.exceptions.UnknownPlayerException;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
public class VaultEconomyWrapper implements Economy {

    private final TrunkEconomy wrapped;

    public VaultEconomyWrapper(TrunkEconomy wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public boolean isEnabled() {
        return wrapped.getPlugin().isEnabled();
    }

    @Override
    public String getName() {
        return wrapped.getPlugin().getName();
    }

    @Override
    public boolean hasBankSupport() {
        return wrapped.hasBankSupport();
    }

    @Override
    public int fractionalDigits() {
        return wrapped.getDigits();
    }

    @Override
    public String format(double v) {
        return wrapped.format(v);
    }

    @Override
    public String currencyNamePlural() {
        return wrapped.currencyNamePlural();
    }

    @Override
    public String currencyNameSingular() {
        return wrapped.currencyNameSingular();
    }

    @Override
    public boolean hasAccount(String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.hasAccount(uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer player) {
        return wrapped.hasAccount(player.getUniqueId());
    }

    @Override
    public boolean hasAccount(String player, String world) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.hasAccount(uniqueId, world);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer player, String world) {
        return wrapped.hasAccount(player.getUniqueId(), world);
    }

    @Override
    public double getBalance(String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getBalance(uniqueId).doubleValue();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getBalance(OfflinePlayer player) {
        return wrapped.getBalance(player.getUniqueId()).doubleValue();
    }

    @Override
    public double getBalance(String player, String world) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getBalance(uniqueId, world).doubleValue();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getBalance(OfflinePlayer player, String world) {
        return wrapped.getBalance(player.getUniqueId(), world).doubleValue();
    }

    @Override
    public boolean has(String player, double amount) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.has(uniqueId, amount);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean has(OfflinePlayer player, double amount) {
        return wrapped.has(player.getUniqueId(), amount);
    }

    @Override
    public boolean has(String player, String world, double amount) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.has(uniqueId, amount, world);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean has(OfflinePlayer player, String world, double amount) {
        return wrapped.has(player.getUniqueId(), amount, world);
    }

    @Override
    public EconomyResponse withdrawPlayer(String player, double amount) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.withdraw(uniqueId, amount).toVault();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer player, double amount) {
        return wrapped.withdraw(player.getUniqueId(), amount).toVault();
    }

    @Override
    public EconomyResponse withdrawPlayer(String player, String world, double amount) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.withdraw(uniqueId, amount, world).toVault();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer player, String world, double amount) {
        return wrapped.withdraw(player.getUniqueId(), amount, world).toVault();
    }

    @Override
    public EconomyResponse depositPlayer(String player, double amount) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.deposit(uniqueId, amount).toVault();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer player, double amount) {
        return wrapped.deposit(player.getUniqueId(), amount).toVault();
    }

    @Override
    public EconomyResponse depositPlayer(String player, String world, double amount) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.deposit(uniqueId, amount, world).toVault();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer player, String world, double amount) {
        return wrapped.deposit(player.getUniqueId(), amount, world).toVault();
    }

    @Override
    public EconomyResponse createBank(String bank, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.createBank(uniqueId.toString()).toVault();
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse createBank(String bank, OfflinePlayer player) {
        return wrapped.createBank(player.getUniqueId().toString()).toVault();
    }

    @Override
    public EconomyResponse deleteBank(String bank) {
        return wrapped.deleteBank(bank).toVault();
    }

    @Override
    public EconomyResponse bankBalance(String bank) {
        return new EconomyResponse(0, wrapped.getBankBalance(bank).doubleValue(), EconomyResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public EconomyResponse bankHas(String bank, double amount) {
        return new EconomyResponse(0, 0, bankBalance(bank).balance >= amount ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, "");
    }

    @Override
    public EconomyResponse bankWithdraw(String bank, double amount) {
        return wrapped.setBankBalance(bank, wrapped.getBankBalance(bank).doubleValue() - amount).toVault();
    }

    @Override
    public EconomyResponse bankDeposit(String bank, double amount) {
        return wrapped.setBankBalance(bank, wrapped.getBankBalance(bank).doubleValue() + amount).toVault();
    }

    @Override
    public EconomyResponse isBankOwner(String bank, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return new EconomyResponse(0, 0, bank.equals(uniqueId.toString()) ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, "");
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse isBankOwner(String bank, OfflinePlayer player) {
        return new EconomyResponse(0, 0, bank.equals(player.getUniqueId().toString()) ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, "");
    }

    @Override
    public EconomyResponse isBankMember(String bank, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return new EconomyResponse(0, 0, wrapped.hasBankAccount(uniqueId, bank) ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, "");
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Outdated methods!");
    }

    @Override
    public EconomyResponse isBankMember(String bank, OfflinePlayer player) {
        return new EconomyResponse(0, 0, wrapped.hasBankAccount(player.getUniqueId(), bank) ? EconomyResponse.ResponseType.SUCCESS : EconomyResponse.ResponseType.FAILURE, "");
    }

    @Override
    public List<String> getBanks() {
        return Arrays.asList(Iterables.toArray(wrapped.getBanks(), String.class));
    }

    @Override
    public boolean createPlayerAccount(String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.hasAccount(uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer player) {
        return wrapped.hasAccount(player.getUniqueId());
    }

    @Override
    public boolean createPlayerAccount(String player, String world) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.createAccount(uniqueId, world).getResult().equals(com.trophonix.trunk.api.economy.EconomyResponse.Result.SUCCESS);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer player, String world) {
        return wrapped.createAccount(player.getUniqueId(), world).getResult().equals(com.trophonix.trunk.api.economy.EconomyResponse.Result.SUCCESS);
    }

}
