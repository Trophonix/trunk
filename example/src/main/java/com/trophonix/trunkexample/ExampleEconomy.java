package com.trophonix.trunkexample;

import com.trophonix.trunk.api.economy.EconomyResponse;
import com.trophonix.trunk.api.economy.TrunkEconomy;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
public class ExampleEconomy extends TrunkEconomy {

    private final DecimalFormat decimalFormat = new DecimalFormat("0.##");

    private final TrunkExample main;

    public ExampleEconomy(TrunkExample main) {
        super(main);
        this.main = main;
    }

    @Override
    public int getDigits() {
        return 3;
    }

    @Override
    public String format(Number amount) {
        return decimalFormat.format(amount.doubleValue());
    }

    @Override
    public String currencyNamePlural() {
        return "dollars";
    }

    @Override
    public String currencyNameSingular() {
        return "dollar";
    }

    @Override
    public String currencySymbol() {
        return "$";
    }

    @Override
    public boolean hasAccount(UUID uniqueId) {
        return main.getConfig().contains("balances." + uniqueId.toString());
    }

    @Override
    public EconomyResponse createAccount(UUID uniqueId) {
        if (hasAccount(uniqueId)) {
            double balance = getBalance(uniqueId).doubleValue();
            return new EconomyResponse(EconomyResponse.Result.FAILURE, "Player already has an account!", balance, balance);
        }
        main.getConfig().set("balances." + uniqueId.toString(), 0);
        return new EconomyResponse(EconomyResponse.Result.SUCCESS, 0, 0);
    }

    @Override
    public Number getBalance(UUID uniqueId) {
        return hasAccount(uniqueId) ? main.getConfig().getDouble("balances." + uniqueId.toString()) : createAccount(uniqueId).getNewBalance();
    }

    @Override
    public EconomyResponse setBalance(UUID uniqueId, Number balance) {
        if (balance.doubleValue() < 0) {
            return new EconomyResponse(EconomyResponse.Result.FAILURE, balance.doubleValue() + " is less than 0!");
        }
        double oldBalance = getBalance(uniqueId).doubleValue();
        main.getConfig().set("balances." + uniqueId.toString(), balance.doubleValue());
        return new EconomyResponse(EconomyResponse.Result.SUCCESS, oldBalance, balance);
    }

    @Override
    public boolean has(UUID uniqueId, Number amount) {
        return getBalance(uniqueId).doubleValue() >= amount.doubleValue();
    }

    @Override
    public EconomyResponse deposit(UUID uniqueId, Number amount) {
        return setBalance(uniqueId, getBalance(uniqueId).doubleValue() + amount.doubleValue());
    }

    @Override
    public EconomyResponse withdraw(UUID uniqueId, Number amount) {
        return setBalance(uniqueId, getBalance(uniqueId).doubleValue() - amount.doubleValue());
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

}
