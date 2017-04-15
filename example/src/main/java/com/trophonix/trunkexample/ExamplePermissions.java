package com.trophonix.trunkexample;

import com.trophonix.trunk.api.permissions.TrunkPermissions;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.UUID;

/**
 * Created by Lucas on 4/14/17.
 */
public class ExamplePermissions extends TrunkPermissions {

    private TrunkExample main;

    public ExamplePermissions(TrunkExample main) {
        super(main);
        this.main = main;
    }

    @Override
    public boolean has(Player player, String node) {
        return player.hasPermission(node);
    }

    @Override
    public boolean has(CommandSender player, String node) {
        return player.hasPermission(node);
    }

    @Override
    public boolean playerHas(UUID uniqueId, String node) {
        return main.getConfig().getBoolean("permissions.players." + uniqueId.toString() + ".permissions.'" + node + "'", false);
    }

    @Override
    public boolean playerHas(String world, UUID uniqueId, String node) {
        return playerHas(uniqueId, node); // My plugin doesn't support per-world perms
    }

    @Override
    public boolean playerAdd(UUID uniqueId, String node) {
        main.getConfig().set("permissions.players." + uniqueId.toString() + ".permissions.'" + node + "'", true);
        return main.getConfig().isSet("permissions.players." + uniqueId.toString() + ".permissions.'" + node + "'");
    }

    @Override
    public boolean playerAdd(String world, UUID uniqueId, String node) {
        return playerAdd(uniqueId, node);
    }

    @Override
    public boolean playerRemove(UUID uniqueId, String node) {
        main.getConfig().set("permissions.players." + uniqueId.toString() + ".permissions.'" + node + "'", null);
        return !main.getConfig().isSet("permissions.players." + uniqueId.toString() + ".permissions.'" + node + "'");
    }

    @Override
    public boolean playerRemove(String world, UUID uniqueId, String node) {
        return playerRemove(uniqueId, node);
    }

    @Override
    public boolean playerAddTransient(UUID uniqueId, String node) {
        return false;
    }

    @Override
    public boolean playerAddTransient(String world, UUID uniqueId, String node) {
        return false;
    }

    @Override
    public boolean playerRemoveTransient(UUID uniqueId, String node) {
        return false;
    }

    @Override
    public boolean playerRemoveTransient(String world, UUID uniqueId, String node) {
        return false;
    }

    @Override
    public boolean hasGroupSupport() {
        return false;
    }

    @Override
    public boolean playerAddGroup(UUID uniqueId, String group) {
        return false;
    }

    @Override
    public boolean playerAddGroup(String world, UUID uniqueId, String group) {
        return false;
    }

    @Override
    public boolean playerRemoveGroup(UUID uniqueId, String group) {
        return false;
    }

    @Override
    public boolean playerRemoveGroup(String world, UUID uniqueId, String group) {
        return false;
    }

    @Override
    public boolean playerInGroup(UUID uniqueId, String group) {
        return false;
    }

    @Override
    public boolean playerInGroup(String world, UUID uniqueId, String group) {
        return false;
    }

    @Override
    public boolean groupHas(String group, String node) {
        return false;
    }

    @Override
    public boolean groupHas(String world, String group, String node) {
        return false;
    }

    @Override
    public boolean groupAdd(String group, String node) {
        return false;
    }

    @Override
    public boolean groupAdd(String world, String group, String node) {
        return false;
    }

    @Override
    public boolean groupRemove(String group, String node) {
        return false;
    }

    @Override
    public boolean groupRemove(String world, String group, String node) {
        return false;
    }

    @Override
    public Iterable<String> getPlayerGroups(UUID uniqueId) {
        return Collections.singleton("default");
    }

    @Override
    public Iterable<String> getPlayerGroups(String world, UUID uniqueId) {
        return Collections.singleton("default");
    }

    @Override
    public String getPrimaryGroup(UUID uniqueId) {
        return "default";
    }

    @Override
    public String getPrimaryGroup(String world, UUID uniqueId) {
        return "default";
    }

    @Override
    public Iterable<String> getGroups() {
        return Collections.emptyList();
    }
}
