package com.trophonix.trunk.api.permissions;

import com.trophonix.trunk.api.TrunkHook;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * Created by Lucas on 4/12/17.
 */
@SuppressWarnings("WeakerAccess")
public abstract class TrunkPermissions implements TrunkHook {

    private final Plugin plugin;

    public TrunkPermissions(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    public abstract boolean has(UUID uniqueId, String node);

    public boolean has(Player player, String node) {
        return has(player.getUniqueId(), node);
    }

    public abstract boolean has(CommandSender player, String node);

    public abstract boolean has(String world, UUID uniqueId, String node);

    public boolean has(World world, UUID uniqueId, String node) {
        return has(world.getName(), uniqueId, node);
    }

    public boolean has(World world, Player player, String node) {
        return has(world.getName(), player.getUniqueId(), node);
    }

    public abstract boolean playerHas(UUID uniqueId, String node);

    public boolean playerHas(Player player, String node) {
        return playerHas(player.getUniqueId(), node);
    }

    public abstract boolean playerHas(String world, UUID uniqueId, String node);

    public boolean playerHas(World world, UUID uniqueId, String node) {
        return playerHas(world.getName(), uniqueId, node);
    }

    public boolean playerHas(String world, Player player, String node) {
        return playerHas(world, player.getUniqueId(), node);
    }

    public boolean playerHas(World world, Player player, String node) {
        return playerHas(world.getName(), player.getUniqueId(), node);
    }

    public abstract boolean playerAdd(UUID uniqueId, String node);

    public boolean playerAdd(Player player, String node) {
        return playerAdd(player.getUniqueId(), node);
    }

    public abstract boolean playerAdd(String world, UUID uniqueId, String node);

    public boolean playerAdd(World world, UUID uniqueId, String node) {
        return playerAdd(world.getName(), uniqueId, node);
    }

    public boolean playerAdd(String world, Player player, String node) {
        return playerAdd(world, player.getUniqueId(), node);
    }

    public boolean playerAdd(World world, Player player, String node) {
        return playerAdd(world.getName(), player.getUniqueId(), node);
    }

    public abstract boolean playerRemove(UUID uniqueId, String node);

    public boolean playerRemove(Player player, String node) {
        return playerRemove(player.getUniqueId(), node);
    }

    public abstract boolean playerRemove(String world, UUID uniqueId, String node);

    public boolean playerRemove(World world, UUID uniqueId, String node) {
        return playerRemove(world.getName(), uniqueId, node);
    }

    public boolean playerRemove(String world, Player player, String node) {
        return playerRemove(world, player.getUniqueId(), node);
    }

    public boolean playerRemove(World world, Player player, String node) {
        return playerAdd(world.getName(), player.getUniqueId(), node);
    }

    public abstract boolean playerAddTransient(UUID uniqueId, String node);

    public boolean playerAddTransient(Player player, String node) {
        return playerAddTransient(player.getUniqueId(), node);
    }

    public abstract boolean playerAddTransient(String world, UUID uniqueId, String node);

    public boolean playerAddTransient(World world, UUID uniqueId, String node) {
        return playerAddTransient(world.getName(), uniqueId, node);
    }

    public boolean playerAddTransient(String world, Player player, String node) {
        return playerAddTransient(world, player.getUniqueId(), node);
    }

    public boolean playerAddTransient(World world, Player player, String node) {
        return playerAddTransient(world.getName(), player.getUniqueId(), node);
    }

    public abstract boolean playerRemoveTransient(UUID uniqueId, String node);

    public boolean playerRemoveTransient(Player player, String node) {
        return playerRemoveTransient(player.getUniqueId(), node);
    }

    public abstract boolean playerRemoveTransient(String world, UUID uniqueId, String node);

    public boolean playerRemoveTransient(World world, UUID uniqueId, String node) {
        return playerRemoveTransient(world.getName(), uniqueId, node);
    }

    public boolean playerRemoveTransient(String world, Player player, String node) {
        return playerRemoveTransient(world, player.getUniqueId(), node);
    }

    public boolean playerRemoveTransient(World world, Player player, String node) {
        return playerRemoveTransient(world.getName(), player.getUniqueId(), node);
    }

    public abstract boolean hasGroupSupport();

    public abstract boolean playerAddGroup(UUID uniqueId, String group);

    public boolean playerAddGroup(Player player, String group) {
        return playerAddGroup(player.getUniqueId(), group);
    }

    public abstract boolean playerAddGroup(String world, UUID uniqueId, String group);

    public boolean playerAddGroup(World world, UUID uniqueId, String group) {
        return playerAddGroup(world.getName(), uniqueId, group);
    }

    public boolean playerAddGroup(String world, Player player, String group) {
        return playerAddGroup(world, player.getUniqueId(), group);
    }

    public boolean playerAddGroup(World world, Player player, String group) {
        return playerAddGroup(world.getName(), player.getUniqueId(), group);
    }

    public abstract boolean playerRemoveGroup(UUID uniqueId, String group);

    public boolean playerRemoveGroup(Player player, String group) {
        return playerRemoveGroup(player.getUniqueId(), group);
    }

    public abstract boolean playerRemoveGroup(String world, UUID uniqueId, String group);

    public boolean playerRemoveGroup(World world, UUID uniqueId, String group) {
        return playerRemoveGroup(world.getName(), uniqueId, group);
    }

    public boolean playerRemoveGroup(String world, Player player, String group) {
        return playerRemoveGroup(world, player.getUniqueId(), group);
    }

    public boolean playerRemoveGroup(World world, Player player, String group) {
        return playerRemoveGroup(world.getName(), player.getUniqueId(), group);
    }

    public abstract boolean playerInGroup(UUID uniqueId, String group);

    public boolean playerInGroup(Player player, String group) {
        return playerInGroup(player.getUniqueId(), group);
    }

    public abstract boolean playerInGroup(String world, UUID uniqueId, String group);

    public boolean playerInGroup(World world, UUID uniqueId, String group) {
        return playerInGroup(world.getName(), uniqueId, group);
    }

    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return playerInGroup(world, player.getUniqueId(), group);
    }

    public boolean playerInGroup(World world, OfflinePlayer player, String group) {
        return playerInGroup(world.getName(), player.getUniqueId(), group);
    }

    public abstract boolean groupHas(String group, String node);

    public abstract boolean groupHas(String world, String group, String node);

    public boolean groupHas(World world, String group, String node) {
        return groupHas(world.getName(), group, node);
    }

    public abstract boolean groupAdd(String group, String node);

    public abstract boolean groupAdd(String world, String group, String node);

    public boolean groupAdd(World world, String group, String node) {
        return groupAdd(world.getName(), group, node);
    }

    public abstract boolean groupRemove(String group, String node);

    public abstract boolean groupRemove(String world, String group, String node);

    public boolean groupRemove(World world, String group, String node) {
        return groupRemove(world.getName(), group, node);
    }

    public abstract Iterable<String> getPlayerGroups(UUID uniqueId);

    public Iterable<String> getPlayerGroups(OfflinePlayer player) {
        return getPlayerGroups(player.getUniqueId());
    }

    public abstract Iterable<String> getPlayerGroups(String world, UUID uniqueId);

    public Iterable<String> getPlayerGroups(String world, OfflinePlayer player) {
        return getPlayerGroups(world, player.getUniqueId());
    }

    public Iterable<String> getPlayerGroups(World world, UUID uniqueId) {
        return getPlayerGroups(world.getName(), uniqueId);
    }

    public Iterable<String> getPlayerGroups(World world, OfflinePlayer player) {
        return getPlayerGroups(world.getName(), player.getUniqueId());
    }

    public abstract String getPrimaryGroup(UUID uniqueId);

    public String getPrimaryGroup(OfflinePlayer player) {
        return getPrimaryGroup(player.getUniqueId());
    }

    public abstract String getPrimaryGroup(String world, UUID uniqueId);

    public String getPrimaryGroup(World world, UUID uniqueId) {
        return getPrimaryGroup(world.getName(), uniqueId);
    }

    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return getPrimaryGroup(world, player.getUniqueId());
    }

    public String getPrimaryGroup(World world, OfflinePlayer player) {
        return getPrimaryGroup(world.getName(), player.getUniqueId());
    }

    public abstract Iterable<String> getGroups();

}
