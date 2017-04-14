package com.trophonix.trunk.api.vault;

import com.google.common.collect.Iterables;
import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.UUIDStore;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
public class VaultPermissionWrapper extends Permission {

    private final TrunkPermissions wrapped;

    public VaultPermissionWrapper(TrunkPermissions wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public boolean has(String world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.has(world, uniqueId, permission);
    }

    @Override
    public boolean has(World world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.has(world, uniqueId, permission);
    }

    @Override
    public boolean has(CommandSender sender, String permission) {
        return wrapped.has(sender, permission);
    }

    @Override
    public boolean has(Player player, String permission) {
        return wrapped.has(player, permission);
    }

    @Override
    public boolean playerHas(World world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerHas(world, uniqueId, permission);
    }

    @Override
    public boolean playerHas(String world, OfflinePlayer player, String permission) {
        return wrapped.playerHas(world, player.getUniqueId(), permission);
    }

    @Override
    public boolean playerHas(Player player, String permission) {
        return wrapped.playerHas(player, permission);
    }

    @Override
    public boolean playerAdd(World world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAdd(world, uniqueId, permission);
    }

    @Override
    public boolean playerAdd(String world, OfflinePlayer player, String permission) {
        return wrapped.playerAdd(world, player.getUniqueId(), permission);
    }

    @Override
    public boolean playerAdd(Player player, String permission) {
        return wrapped.playerAdd(player, permission);
    }

    @Override
    public boolean playerAddTransient(String player, String permission) throws UnsupportedOperationException {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAddTransient(uniqueId, permission);
    }

    @Override
    public boolean playerAddTransient(OfflinePlayer player, String permission) throws UnsupportedOperationException {
        return wrapped.playerAddTransient(player.getUniqueId(), permission);
    }

    @Override
    public boolean playerAddTransient(Player player, String permission) {
        return wrapped.playerAddTransient(player, permission);
    }

    @Override
    public boolean playerAddTransient(String worldName, OfflinePlayer player, String permission) {
        return wrapped.playerAddTransient(worldName, player.getUniqueId(), permission);
    }

    @Override
    public boolean playerAddTransient(String worldName, Player player, String permission) {
        return wrapped.playerAddTransient(worldName, player, permission);
    }

    @Override
    public boolean playerAddTransient(String worldName, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAddTransient(worldName, uniqueId, permission);
    }

    @Override
    public boolean playerRemoveTransient(String worldName, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerRemoveTransient(worldName, uniqueId, permission);
    }

    @Override
    public boolean playerRemoveTransient(String worldName, OfflinePlayer player, String permission) {
        return wrapped.playerRemoveTransient(worldName, player.getUniqueId(), permission);
    }

    @Override
    public boolean playerRemoveTransient(String worldName, Player player, String permission) {
        return wrapped.playerRemoveTransient(worldName, player, permission);
    }

    @Override
    public boolean playerRemove(String world, OfflinePlayer player, String permission) {
        return wrapped.playerRemove(world, player.getUniqueId(), permission);
    }

    @Override
    public boolean playerRemove(World world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerRemove(world, uniqueId, permission);
    }

    @Override
    public boolean playerRemove(Player player, String permission) {
        return wrapped.playerRemove(player, permission);
    }

    @Override
    public boolean playerRemoveTransient(String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerRemoveTransient(uniqueId, permission);
    }

    @Override
    public boolean playerRemoveTransient(OfflinePlayer player, String permission) {
        return wrapped.playerRemoveTransient(player.getUniqueId(), permission);
    }

    @Override
    public boolean playerRemoveTransient(Player player, String permission) {
        return wrapped.playerRemoveTransient(player, permission);
    }

    @Override
    public boolean groupHas(World world, String group, String permission) {
        return wrapped.groupHas(world, group, permission);
    }

    @Override
    public boolean groupAdd(World world, String group, String permission) {
        return wrapped.groupAdd(world, group, permission);
    }

    @Override
    public boolean groupRemove(World world, String group, String permission) {
        return wrapped.groupRemove(world, group, permission);
    }

    @Override
    public boolean playerInGroup(World world, String player, String group) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerInGroup(world, uniqueId, group);
    }

    @Override
    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return wrapped.playerInGroup(world, player, group);
    }

    @Override
    public boolean playerInGroup(Player player, String group) {
        return wrapped.playerInGroup(player, group);
    }

    @Override
    public boolean playerAddGroup(World world, String player, String group) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAddGroup(world, uniqueId, group);
    }

    @Override
    public boolean playerAddGroup(String world, OfflinePlayer player, String group) {
        return wrapped.playerAddGroup(world, player.getUniqueId(), group);
    }

    @Override
    public boolean playerAddGroup(Player player, String group) {
        return wrapped.playerAddGroup(player, group);
    }

    @Override
    public boolean playerRemoveGroup(World world, String player, String group) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerRemoveGroup(world, uniqueId, group);
    }

    @Override
    public boolean playerRemoveGroup(String world, OfflinePlayer player, String group) {
        return wrapped.playerRemoveGroup(world, player.getUniqueId(), group);
    }

    @Override
    public boolean playerRemoveGroup(Player player, String group) {
        return wrapped.playerRemoveGroup(player, group);
    }

    @Override
    public String[] getPlayerGroups(World world, String player) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        if (uniqueId == null) {
            return null;
        }
        return Iterables.toArray(wrapped.getPlayerGroups(world, uniqueId), String.class);
    }

    @Override
    public String[] getPlayerGroups(String world, OfflinePlayer player) {
        return Iterables.toArray(wrapped.getPlayerGroups(world, player), String.class);
    }

    @Override
    public String[] getPlayerGroups(Player player) {
        return Iterables.toArray(wrapped.getPlayerGroups(player), String.class);
    }

    @Override
    public String getPrimaryGroup(World world, String player) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        if (uniqueId == null) {
            return null;
        }
        return wrapped.getPrimaryGroup(world, uniqueId);
    }

    @Override
    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return wrapped.getPrimaryGroup(world, player);
    }

    @Override
    public String getPrimaryGroup(Player player) {
        return wrapped.getPrimaryGroup(player);
    }

    @Override
    public String getName() {
        return wrapped.getPlugin().getName();
    }

    @Override
    public boolean isEnabled() {
        return wrapped.getPlugin().isEnabled();
    }

    @Override
    public boolean hasSuperPermsCompat() {
        return false;
    }

    @Override
    public boolean playerHas(String world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerHas(world, uniqueId, permission);
    }

    @Override
    public boolean playerAdd(String world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAdd(world, uniqueId, permission);
    }

    @Override
    public boolean playerRemove(String world, String player, String permission) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerRemove(world, uniqueId, permission);
    }

    @Override
    public boolean groupHas(String world, String group, String permission) {
        return wrapped.groupHas(world, group, permission);
    }

    @Override
    public boolean groupAdd(String world, String group, String permission) {
        return wrapped.groupAdd(world, group, permission);
    }

    @Override
    public boolean groupRemove(String world, String group, String permission) {
        return wrapped.groupRemove(world, group, permission);
    }

    @Override
    public boolean playerInGroup(String world, String player, String group) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAddGroup(world, uniqueId, group);
    }

    @Override
    public boolean playerAddGroup(String world, String player, String group) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerAddGroup(world, uniqueId, group);
    }

    @Override
    public boolean playerRemoveGroup(String world, String player, String group) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        return uniqueId != null && wrapped.playerRemoveGroup(world, uniqueId, group);
    }

    @Override
    public String[] getPlayerGroups(String world, String player) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        if (uniqueId == null) {
            return null;
        }
        return Iterables.toArray(wrapped.getPlayerGroups(world, uniqueId), String.class);
    }

    @Override
    public String getPrimaryGroup(String world, String player) {
        UUID uniqueId = UUIDStore.getUniqueId(player);
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        if (uniqueId == null) {
            return null;
        }
        return wrapped.getPrimaryGroup(world, uniqueId);
    }

    @Override
    public String[] getGroups() {
        return Iterables.toArray(wrapped.getGroups(), String.class);
    }

    @Override
    public boolean hasGroupSupport() {
        return wrapped.hasGroupSupport();
    }

}
