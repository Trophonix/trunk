package com.trophonix.trunk.vault;

import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
@SuppressWarnings("deprecation")
public class TrunkVaultPermissionsWrapper extends TrunkPermissions {

    private final Permission wrapped;

    private final String world = Bukkit.getWorlds().get(0).getName();

    public TrunkVaultPermissionsWrapper(Plugin plugin, Permission wrapped) {
        super(plugin);
        this.wrapped = wrapped;
    }

    @Override
    public boolean has(CommandSender player, String node) {
        return wrapped.has(player, node);
    }

    @Override
    public boolean playerHas(UUID uniqueId, String node) {
        return wrapped.playerHas(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerHas(String world, UUID uniqueId, String node) {
        return wrapped.playerHas(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerAdd(UUID uniqueId, String node) {
        return wrapped.playerAdd(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerAdd(String world, UUID uniqueId, String node) {
        return wrapped.playerAdd(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerRemove(UUID uniqueId, String node) {
        return wrapped.playerRemove(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerRemove(String world, UUID uniqueId, String node) {
        return wrapped.playerRemove(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerAddTransient(UUID uniqueId, String node) {
        return wrapped.playerAddTransient(UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerAddTransient(String world, UUID uniqueId, String node) {
        return wrapped.playerAddTransient(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerRemoveTransient(UUID uniqueId, String node) {
        return wrapped.playerRemoveTransient(UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean playerRemoveTransient(String world, UUID uniqueId, String node) {
        return wrapped.playerRemoveTransient(world, UUIDStore.getName(uniqueId), node);
    }

    @Override
    public boolean hasGroupSupport() {
        return wrapped.hasGroupSupport();
    }

    @Override
    public boolean playerAddGroup(UUID uniqueId, String group) {
        return wrapped.playerAddGroup(world, UUIDStore.getName(uniqueId), group);
    }

    @Override
    public boolean playerAddGroup(String world, UUID uniqueId, String group) {
        return wrapped.playerAddGroup(world, UUIDStore.getName(uniqueId), group);
    }

    @Override
    public boolean playerRemoveGroup(UUID uniqueId, String group) {
        return wrapped.playerRemoveGroup(world, UUIDStore.getName(uniqueId), group);
    }

    @Override
    public boolean playerRemoveGroup(String world, UUID uniqueId, String group) {
        return wrapped.playerRemoveGroup(world, UUIDStore.getName(uniqueId), group);
    }

    @Override
    public boolean playerInGroup(UUID uniqueId, String group) {
        return wrapped.playerInGroup(world, UUIDStore.getName(uniqueId), group);
    }

    @Override
    public boolean playerInGroup(String world, UUID uniqueId, String group) {
        return wrapped.playerInGroup(world, UUIDStore.getName(uniqueId), group);
    }

    @Override
    public boolean groupHas(String group, String node) {
        return wrapped.groupHas(world, group, node);
    }

    @Override
    public boolean groupHas(String world, String group, String node) {
        return wrapped.groupHas(world, group, node);
    }

    @Override
    public boolean groupAdd(String group, String node) {
        return wrapped.groupAdd(world, group, node);
    }

    @Override
    public boolean groupAdd(String world, String group, String node) {
        return wrapped.groupAdd(world, group, node);
    }

    @Override
    public boolean groupRemove(String group, String node) {
        return wrapped.groupRemove(world, group, node);
    }

    @Override
    public boolean groupRemove(String world, String group, String node) {
        return wrapped.groupRemove(world, group, node);
    }

    @Override
    public Iterable<String> getPlayerGroups(UUID uniqueId) {
        return Arrays.asList(wrapped.getPlayerGroups(world, UUIDStore.getName(uniqueId)));
    }

    @Override
    public Iterable<String> getPlayerGroups(String world, UUID uniqueId) {
        return Arrays.asList(wrapped.getPlayerGroups(world, UUIDStore.getName(uniqueId)));
    }

    @Override
    public String getPrimaryGroup(UUID uniqueId) {
        return wrapped.getPrimaryGroup(world, UUIDStore.getName(uniqueId));
    }

    @Override
    public String getPrimaryGroup(String world, UUID uniqueId) {
        return wrapped.getPrimaryGroup(world, UUIDStore.getName(uniqueId));
    }

    @Override
    public Iterable<String> getGroups() {
        return Arrays.asList(wrapped.getGroups());
    }

}
