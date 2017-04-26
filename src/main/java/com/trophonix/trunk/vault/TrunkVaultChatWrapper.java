package com.trophonix.trunk.vault;

import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
@SuppressWarnings("deprecation")
public class TrunkVaultChatWrapper extends TrunkChat {

    private final Chat wrapped;

    private final String world = "world";

    public TrunkVaultChatWrapper(Plugin plugin, Chat chat) {
        super(plugin, TrunkAPI.getAPI(TrunkPermissions.class));
        this.wrapped = chat;
    }

    @Override
    public String getPrefix(UUID uniqueId) {
        return wrapped.getPlayerPrefix(world, UUIDStore.getName(uniqueId));
    }

    @Override
    public String getPrefix(String world, UUID uniqueId) {
        return wrapped.getPlayerPrefix(world, UUIDStore.getName(uniqueId));
    }

    @Override
    public void setPrefix(UUID uniqueId, String prefix) {
        wrapped.setPlayerPrefix(world, UUIDStore.getName(uniqueId), prefix);
    }

    @Override
    public void setPrefix(String world, UUID uniqueId, String prefix) {
        wrapped.setPlayerPrefix(world, UUIDStore.getName(uniqueId), prefix);
    }

    @Override
    public String getSuffix(UUID uniqueId) {
        return wrapped.getPlayerSuffix(world, UUIDStore.getName(uniqueId));
    }

    @Override
    public String getSuffix(String world, UUID uniqueId) {
        return wrapped.getPlayerSuffix(world, UUIDStore.getName(uniqueId));
    }

    @Override
    public void setSuffix(UUID uniqueId, String suffix) {
        wrapped.setPlayerSuffix(world, UUIDStore.getName(uniqueId), suffix);
    }

    @Override
    public void setSuffix(String world, UUID uniqueId, String suffix) {
        wrapped.setPlayerSuffix(world, UUIDStore.getName(uniqueId), suffix);
    }

    @Override
    public Iterable<String> getGroups(UUID uniqueId) {
        return Arrays.asList(wrapped.getPlayerGroups(world, UUIDStore.getName(uniqueId)));
    }

    @Override
    public Iterable<String> getGroups(String world, UUID uniqueId) {
        return Arrays.asList(wrapped.getPlayerGroups(world, UUIDStore.getName(uniqueId)));
    }

    @Override
    public String getPrimaryGroup(UUID uniqueId) {
        return wrapped.getPrimaryGroup(Bukkit.getWorlds().get(0), UUIDStore.getName(uniqueId));
    }

    @Override
    public String getPrimaryGroup(String world, UUID uniqueId) {
        return wrapped.getPrimaryGroup(world, UUIDStore.getName(uniqueId));
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
    public String getGroupPrefix(String group) {
        return wrapped.getGroupPrefix(world, group);
    }

    @Override
    public String getGroupPrefix(String world, String group) {
        return wrapped.getGroupPrefix(world, group);
    }

    @Override
    public void setGroupPrefix(String group, String prefix) {
        wrapped.setGroupPrefix(world, group, prefix);
    }

    @Override
    public void setGroupPrefix(String world, String group, String prefix) {
        wrapped.setGroupPrefix(world, group, prefix);
    }

    @Override
    public String getGroupSuffix(String group) {
        return wrapped.getGroupSuffix(world, group);
    }

    @Override
    public String getGroupSuffix(String world, String group) {
        return wrapped.getGroupSuffix(world, group);
    }

    @Override
    public void setGroupSuffix(String group, String suffix) {
        wrapped.setGroupSuffix(world, group, suffix);
    }

    @Override
    public void setGroupSuffix(String world, String group, String suffix) {
        wrapped.setGroupSuffix(world, group, suffix);
    }

    @Override
    public Iterable<String> getGroups() {
        return Arrays.asList(wrapped.getGroups());
    }

    @Override
    public boolean getBooleanPlayerOption(String world, UUID uniqueId, String node, boolean defaultValue) {
        return wrapped.getPlayerInfoBoolean(world, UUIDStore.getName(uniqueId), node, defaultValue);
    }

    @Override
    public void setBooleanPlayerOption(String world, UUID uniqueId, String node, boolean value) {
        wrapped.setPlayerInfoBoolean(world, UUIDStore.getName(uniqueId), node, value);
    }

    @Override
    public int getIntegerPlayerOption(String world, UUID uniqueId, String node, int defaultValue) {
        return wrapped.getPlayerInfoInteger(world, UUIDStore.getName(uniqueId), node, defaultValue);
    }

    @Override
    public void setIntegerPlayerOption(String world, UUID uniqueId, String node, int value) {
        wrapped.setPlayerInfoInteger(world, UUIDStore.getName(uniqueId), node, value);
    }

    @Override
    public double getDoublePlayerOption(String world, UUID uniqueId, String node, double defaultValue) {
        return wrapped.getPlayerInfoDouble(world, UUIDStore.getName(uniqueId), node, defaultValue);
    }

    @Override
    public void setDoublePlayerOption(String world, UUID uniqueId, String node, double value) {
        wrapped.setPlayerInfoDouble(world, UUIDStore.getName(uniqueId), node, value);
    }

    @Override
    public String getStringPlayerOption(String world, UUID uniqueId, String node, String defaultValue) {
        return wrapped.getPlayerInfoString(world, UUIDStore.getName(uniqueId), node, defaultValue);
    }

    @Override
    public void setStringPlayerOption(String world, UUID uniqueId, String node, String value) {
        wrapped.setPlayerInfoString(world, UUIDStore.getName(uniqueId), node, value);
    }

    @Override
    public boolean getBooleanGroupOption(String world, String group, String node, boolean defaultValue) {
        return wrapped.getGroupInfoBoolean(world, group, node, defaultValue);
    }

    @Override
    public void setBooleanGroupOption(String world, String group, String node, boolean value) {
        wrapped.setGroupInfoBoolean(world, group, node, value);
    }

    @Override
    public int getIntegerGroupOption(String world, String group, String node, int defaultValue) {
        return wrapped.getGroupInfoInteger(world, group, node, defaultValue);
    }

    @Override
    public void setIntegerGroupOption(String world, String group, String node, int value) {
        wrapped.setGroupInfoInteger(world, group, node, value);
    }

    @Override
    public double getDoubleGroupOption(String world, String group, String node, double defaultValue) {
        return wrapped.getGroupInfoDouble(world, group, node, defaultValue);
    }

    @Override
    public void setDoubleGroupOption(String world, String group, String node, double value) {
        wrapped.setGroupInfoDouble(world, group, node, value);
    }

    @Override
    public String getStringGroupOption(String world, String group, String node, String defaultValue) {
        return wrapped.getGroupInfoString(world, group, node, defaultValue);
    }

    @Override
    public void setStringGroupOption(String world, String group, String node, String value) {
        wrapped.setGroupInfoString(world, group, node, value);
    }

}
