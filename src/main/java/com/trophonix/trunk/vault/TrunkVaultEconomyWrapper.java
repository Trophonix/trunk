package com.trophonix.trunk.vault;

import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.economy.EconomyResponse;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
@SuppressWarnings("deprecation")
public class TrunkVaultEconomyWrapper extends TrunkEconomy {

    private final Economy wrapped;

    public TrunkVaultEconomyWrapper(Plugin plugin, Economy wrapped) {
        super(plugin);
        this.wrapped = wrapped;
    }


    @Override
    public int getDigits() {
        return wrapped.fractionalDigits();
    }

    @Override
    public String format(Number amount) {
        return wrapped.format(amount.doubleValue());
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
    public String currencySymbol() {
        return "$";
    }

    @Override
    public boolean hasAccount(UUID uniqueId) {
        return wrapped.hasAccount(UUIDStore.getName(uniqueId));
    }

    @Override
    public EconomyResponse createAccount(UUID uniqueId) {
        return new EconomyResponse(wrapped.createPlayerAccount(UUIDStore.getName(uniqueId)));
    }

    @Override
    public Number getBalance(UUID uniqueId) {
        return wrapped.getBalance(UUIDStore.getName(uniqueId));
    }

    @Override
    public EconomyResponse setBalance(UUID uniqueId, Number balance) {
        double current = getBalance(uniqueId).doubleValue();
        if (balance.doubleValue() > current) {
            return EconomyResponse.fromVault(wrapped.depositPlayer(UUIDStore.getName(uniqueId), balance.doubleValue() - current));
        } else if (balance.doubleValue() < current) {
            double newValue = current - balance.doubleValue();
            if (newValue < 0) newValue = 0;
            return EconomyResponse.fromVault(wrapped.withdrawPlayer(UUIDStore.getName(uniqueId), newValue));
        } else {
            return new EconomyResponse(EconomyResponse.Result.FAILURE);
        }
    }

    @Override
    public boolean has(UUID uniqueId, Number amount) {
        return wrapped.has(UUIDStore.getName(uniqueId), amount.doubleValue());
    }

    @Override
    public EconomyResponse deposit(UUID uniqueId, Number amount) {
        return EconomyResponse.fromVault(wrapped.depositPlayer(UUIDStore.getName(uniqueId), amount.doubleValue()));
    }

    @Override
    public EconomyResponse withdraw(UUID uniqueId, Number amount) {
        return EconomyResponse.fromVault(wrapped.withdrawPlayer(UUIDStore.getName(uniqueId), amount.doubleValue()));
    }

    @Override
    public boolean hasBankSupport() {
        return wrapped.hasBankSupport();
    }
}
