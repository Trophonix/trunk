package com.trophonix.trunk.api.chat;

import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.UUIDStore;
import com.trophonix.trunk.api.TrunkHook;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import com.trophonix.trunk.exceptions.UnknownPlayerException;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * Created by Lucas on 4/12/17.
 */
@SuppressWarnings("WeakerAccess")
public abstract class TrunkChat implements TrunkHook {

    private final Plugin plugin;
    private final TrunkPermissions perms;

    public TrunkChat(Plugin plugin) {
        this.plugin = plugin;
        this.perms = Trunk.getInstance().getHook(TrunkPermissions.class);
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    public abstract String getPrefix(UUID uniqueId);

    public String getPrefix(OfflinePlayer player) {
        return getPrefix(player.getUniqueId());
    }

    public String getPrefix(String name) throws UnknownPlayerException {
        return getPrefix(UUIDStore.getUniqueId(name));
    }

    public String getPrefix(String world, UUID uniqueId) {
        return getPrefix(uniqueId);
    }

    public String getPrefix(String world, OfflinePlayer player) {
        return getPrefix(world, player.getUniqueId());
    }

    public String getPrefix(World world, UUID uniqueId) {
        return getPrefix(world.getName(), uniqueId);
    }

    public String getPrefix(World world, OfflinePlayer player) {
        return getPrefix(world.getName(), player.getUniqueId());
    }

    public String getPrefix(String world, String name) throws UnknownPlayerException {
        return getPrefix(world, UUIDStore.getUniqueId(name));
    }

    public abstract void setPrefix(UUID uniqueId, String prefix);

    public void setPrefix(OfflinePlayer player, String prefix) {
        setPrefix(player.getUniqueId(), prefix);
    }

    public void setPrefix(String name, String prefix) throws UnknownPlayerException {
        setPrefix(UUIDStore.getUniqueId(name), prefix);
    }

    public void setPrefix(String world, UUID uniqueId, String prefix) {
        setPrefix(uniqueId, prefix);
    }

    public void setPrefix(String world, OfflinePlayer player, String prefix) {
        setPrefix(world, player.getUniqueId(), prefix);
    }

    public void setPrefix(World world, UUID uniqueId, String prefix) {
        setPrefix(world.getName(), uniqueId, prefix);
    }

    public void setPrefix(World world, OfflinePlayer player, String prefix) {
        setPrefix(world.getName(), player.getUniqueId(), prefix);
    }

    public void setPrefix(String world, String name, String prefix) throws UnknownPlayerException {
        setPrefix(world, UUIDStore.getUniqueId(name), prefix);
    }

    public abstract String getSuffix(UUID uniqueId);

    public String getSuffix(OfflinePlayer player) {
        return getSuffix(player.getUniqueId());
    }

    public String getSuffix(String name) throws UnknownPlayerException {
        return getSuffix(UUIDStore.getUniqueId(name));
    }

    public String getSuffix(String world, UUID uniqueId) {
        return getSuffix(uniqueId);
    }

    public String getSuffix(String world, OfflinePlayer player) {
        return getSuffix(world, player.getUniqueId());
    }

    public String getSuffix(World world, UUID uniqueId) {
        return getSuffix(world.getName(), uniqueId);
    }

    public String getSuffix(World world, OfflinePlayer player) {
        return getSuffix(world.getName(), player.getUniqueId());
    }

    public String getSuffix(String world, String name) throws UnknownPlayerException {
        return getSuffix(world, UUIDStore.getUniqueId(name));
    }

    public abstract void setSuffix(UUID uniqueId, String suffix);

    public void setSuffix(OfflinePlayer player, String suffix) {
        setSuffix(player.getUniqueId(), suffix);
    }

    public void setSuffix(String name, String suffix) throws UnknownPlayerException {
        setSuffix(UUIDStore.getUniqueId(name), suffix);
    }

    public void setSuffix(String world, UUID uniqueId, String suffix) {
        setSuffix(uniqueId, suffix);
    }

    public void setSuffix(String world, OfflinePlayer player, String suffix) {
        setSuffix(world, player.getUniqueId(), suffix);
    }

    public void setSuffix(World world, UUID uniqueId, String suffix) {
        setSuffix(world.getName(), uniqueId, suffix);
    }

    public void setSuffix(World world, OfflinePlayer player, String suffix) {
        setSuffix(world.getName(), player.getUniqueId(), suffix);
    }

    public void setSuffix(String world, String name, String suffix) throws UnknownPlayerException {
        setSuffix(world, UUIDStore.getUniqueId(name), suffix);
    }

    public Iterable<String> getGroups(UUID uniqueId) {
        return perms.getPlayerGroups(uniqueId);
    }

    public Iterable<String> getGroups(OfflinePlayer player) {
        return perms.getPlayerGroups(player);
    }

    public Iterable<String> getGroups(String name) throws UnknownPlayerException {
        return perms.getPlayerGroups(UUIDStore.getUniqueId(name));
    }

    public Iterable<String> getGroups(String world, UUID uniqueId) {
        return perms.getPlayerGroups(world, uniqueId);
    }

    public Iterable<String> getGroups(String world, OfflinePlayer player) {
        return perms.getPlayerGroups(world, player);
    }

    public Iterable<String> getGroups(World world, UUID uniqueId) {
        return perms.getPlayerGroups(world, uniqueId);
    }

    public Iterable<String> getGroups(World world, OfflinePlayer player) {
        return perms.getPlayerGroups(world, player);
    }

    public Iterable<String> getGroups(String world, String name) throws UnknownPlayerException {
        return perms.getPlayerGroups(world, UUIDStore.getUniqueId(name));
    }

    public String getPrimaryGroup(UUID uniqueId) {
        return perms.getPrimaryGroup(uniqueId);
    }

    public String getPrimaryGroup(OfflinePlayer player) {
        return perms.getPrimaryGroup(player.getUniqueId());
    }

    public String getPrimaryGroup(String name) throws UnknownPlayerException {
        return perms.getPrimaryGroup(UUIDStore.getUniqueId(name));
    }

    public String getPrimaryGroup(String world, UUID uniqueId) {
        return perms.getPrimaryGroup(world, uniqueId);
    }

    public String getPrimaryGroup(World world, UUID uniqueId) {
        return perms.getPrimaryGroup(world, uniqueId);
    }

    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return perms.getPrimaryGroup(world, player);
    }

    public String getPrimaryGroup(World world, OfflinePlayer player) {
        return perms.getPrimaryGroup(world, player);
    }

    public String getPrimaryGroup(String world, String name) throws UnknownPlayerException {
        return perms.getPrimaryGroup(world, UUIDStore.getUniqueId(name));
    }

    public boolean playerInGroup(UUID uniqueId, String group) {
        return perms.playerInGroup(uniqueId, group);
    }

    public boolean playerInGroup(OfflinePlayer player, String group) {
        return perms.playerInGroup(player.getUniqueId(), group);
    }

    public boolean playerInGroup(String name, String group) throws UnknownPlayerException {
        return perms.playerInGroup(UUIDStore.getUniqueId(name), group);
    }

    public boolean playerInGroup(String world, UUID uniqueId, String group) {
        return perms.playerInGroup(world, uniqueId, group);
    }

    public boolean playerInGroup(World world, UUID uniqueId, String group) {
        return perms.playerInGroup(world, uniqueId, group);
    }

    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return perms.playerInGroup(world, player, group);
    }

    public boolean playerInGroup(World world, OfflinePlayer player, String group) {
        return perms.playerInGroup(world, player, group);
    }

    public boolean playerInGroup(String world, String name, String group) throws UnknownPlayerException {
        return perms.playerInGroup(world, UUIDStore.getUniqueId(name), group);
    }

    public abstract String getGroupPrefix(String group);

    public String getGroupPrefix(String world, String group) {
        return getGroupPrefix(group);
    }

    public abstract void setGroupPrefix(String group, String prefix);

    public void setGroupPrefix(String world, String group, String prefix) {
        setGroupPrefix(group, prefix);
    }

    public abstract String getGroupSuffix(String group);

    public String getGroupSuffix(String world, String group) {
        return getGroupSuffix(group);
    }

    public abstract void setGroupSuffix(String group, String suffix);

    public void setGroupSuffix(String world, String group, String suffix) {
        setGroupSuffix(group, suffix);
    }

    public Iterable<String> getGroups() {
        return perms.getGroups();
    }

    public abstract boolean getBooleanPlayerOption(String world, UUID uniqueId, String node, boolean defaultValue);

    public boolean getBooleanPlayerOption(World world, UUID uniqueId, String node, boolean defaultValue) {
        return getBooleanPlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    public boolean getBooleanPlayerOption(String world, OfflinePlayer player, String node, boolean defaultValue) {
        return getBooleanPlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    public boolean getBooleanPlayerOption(World world, OfflinePlayer player, String node, boolean defaultValue) {
        return getBooleanPlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    public abstract void setBooleanPlayerOption(String world, UUID uniqueId, String node, boolean value);

    public void setBooleanPlayerOption(World world, UUID uniqueId, String node, boolean value) {
        setBooleanPlayerOption(world.getName(), uniqueId, node, value);
    }

    public void setBooleanPlayerOption(String world, OfflinePlayer player, String node, boolean value) {
        setBooleanPlayerOption(world, player.getUniqueId(), node, value);
    }

    public void setBooleanPlayerOption(World world, OfflinePlayer player, String node, boolean value) {
        setBooleanPlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    public abstract int getIntegerPlayerOption(String world, UUID uniqueId, String node, int defaultValue);

    public int getIntegerPlayerOption(World world, UUID uniqueId, String node, int defaultValue) {
        return getIntegerPlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    public int getIntegerPlayerOption(String world, OfflinePlayer player, String node, int defaultValue) {
        return getIntegerPlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    public int getIntegerPlayerOption(World world, OfflinePlayer player, String node, int defaultValue) {
        return getIntegerPlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    public abstract void setIntegerPlayerOption(String world, UUID uniqueId, String node, int value);

    public void setIntegerPlayerOption(World world, UUID uniqueId, String node, int value) {
        setIntegerPlayerOption(world.getName(), uniqueId, node, value);
    }

    public void setIntegerPlayerOption(String world, OfflinePlayer player, String node, int value) {
        setIntegerPlayerOption(world, player.getUniqueId(), node, value);
    }

    public void setIntegerPlayerOption(World world, OfflinePlayer player, String node, int value) {
        setIntegerPlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    public abstract double getDoublePlayerOption(String world, UUID uniqueId, String node, double defaultValue);

    public double getDoublePlayerOption(World world, UUID uniqueId, String node, double defaultValue) {
        return getDoublePlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    public double getDoublePlayerOption(String world, OfflinePlayer player, String node, double defaultValue) {
        return getDoublePlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    public double getDoublePlayerOption(World world, OfflinePlayer player, String node, double defaultValue) {
        return getDoublePlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    public abstract void setDoublePlayerOption(String world, UUID uniqueId, String node, double value);

    public void setDoublePlayerOption(World world, UUID uniqueId, String node, double value) {
        setDoublePlayerOption(world.getName(), uniqueId, node, value);
    }

    public void setDoublePlayerOption(String world, OfflinePlayer player, String node, double value) {
        setDoublePlayerOption(world, player.getUniqueId(), node, value);
    }

    public void setDoublePlayerOption(World world, OfflinePlayer player, String node, double value) {
        setDoublePlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    public abstract String getStringPlayerOption(String world, UUID uniqueId, String node, String defaultValue);

    public String getStringPlayerOption(World world, UUID uniqueId, String node, String defaultValue) {
        return getStringPlayerOption(world.getName(), uniqueId, node, defaultValue);
    }

    public String getStringPlayerOption(String world, OfflinePlayer player, String node, String defaultValue) {
        return getStringPlayerOption(world, player.getUniqueId(), node, defaultValue);
    }

    public String getStringPlayerOption(World world, OfflinePlayer player, String node, String defaultValue) {
        return getStringPlayerOption(world.getName(), player.getUniqueId(), node, defaultValue);
    }

    public abstract void setStringPlayerOption(String world, UUID uniqueId, String node, String value);

    public void setStringPlayerOption(World world, UUID uniqueId, String node, String value) {
        setStringPlayerOption(world.getName(), uniqueId, node, value);
    }

    public void setStringPlayerOption(String world, OfflinePlayer player, String node, String value) {
        setStringPlayerOption(world, player.getUniqueId(), node, value);
    }

    public void setStringPlayerOption(World world, OfflinePlayer player, String node, String value) {
        setStringPlayerOption(world.getName(), player.getUniqueId(), node, value);
    }

    public abstract boolean getBooleanGroupOption(String world, String group, String node, boolean defaultValue);

    public boolean getBooleanGroupOption(World world, String group, String node, boolean defaultValue) {
        return getBooleanGroupOption(world.getName(), group, node, defaultValue);
    }

    public abstract void setBooleanGroupOption(String world, String group, String node, boolean value);

    public void setBooleanGroupOption(World world, String group, String node, boolean value) {
        setBooleanGroupOption(world.getName(), group, node, value);
    }

    public abstract int getIntegerGroupOption(String world, String group, String node, int defaultValue);

    public int getIntegerGroupOption(World world, String group, String node, int defaultValue) {
        return getIntegerGroupOption(world.getName(), group, node, defaultValue);
    }

    public abstract void setIntegerGroupOption(String world, String group, String node, int value);

    public void setIntegerGroupOption(World world, String group, String node, int value) {
        setIntegerGroupOption(world.getName(), group, node, value);
    }

    public abstract double getDoubleGroupOption(String world, String group, String node, double defaultValue);

    public double getDoubleGroupOption(World world, String group, String node, double defaultValue) {
        return getDoubleGroupOption(world.getName(), group, node, defaultValue);
    }

    public abstract void setDoubleGroupOption(String world, String group, String node, double value);

    public void setDoubleGroupOption(World world, String group, String node, double value) {
        setDoubleGroupOption(world.getName(), group, node, value);
    }

    public abstract String getStringGroupOption(String world, String group, String node, String defaultValue);

    public String getStringGroupOption(World world, String group, String node, String defaultValue) {
        return getStringGroupOption(world.getName(), group, node, defaultValue);
    }

    public abstract void setStringGroupOption(String world, String group, String node, String value);

    public void setStringGroupOption(World world, String group, String node, String value) {
        setStringGroupOption(world.getName(), group, node, value);
    }

}
