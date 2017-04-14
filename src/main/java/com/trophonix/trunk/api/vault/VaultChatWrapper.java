package com.trophonix.trunk.api.vault;

import com.google.common.collect.Iterables;
import com.trophonix.trunk.Trunk;
import com.trophonix.trunk.UUIDStore;
import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.exceptions.UnknownPlayerException;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
public class VaultChatWrapper extends Chat {

    private final TrunkChat wrapped;

    public VaultChatWrapper(Permission perms, TrunkChat wrapped) {
        super(perms);
        this.wrapped = wrapped;
    }

    @Override
    public String getPlayerPrefix(String world, OfflinePlayer player) {
        return wrapped.getPrefix(world, player);
    }

    @Override
    public String getPlayerPrefix(World world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getPrefix(world, uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPlayerPrefix(Player player) {
        return wrapped.getPrefix(player.getWorld(), player);
    }

    @Override
    public void setPlayerPrefix(String world, OfflinePlayer player, String prefix) {
        wrapped.setPrefix(world, player, prefix);
    }

    @Override
    public void setPlayerPrefix(World world, String player, String prefix) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setPrefix(world, uniqueId, prefix);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void setPlayerPrefix(Player player, String prefix) {
        wrapped.setPrefix(player.getWorld(), player, prefix);
    }

    @Override
    public String getPlayerSuffix(String world, OfflinePlayer player) {
        return wrapped.getSuffix(world, player);
    }

    @Override
    public String getPlayerSuffix(World world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getSuffix(world, uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPlayerSuffix(Player player) {
        return wrapped.getSuffix(player.getWorld(), player);
    }

    @Override
    public void setPlayerSuffix(String world, OfflinePlayer player, String suffix) {
        wrapped.setSuffix(world, player, suffix);
    }

    @Override
    public void setPlayerSuffix(World world, String player, String suffix) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setSuffix(world, uniqueId, suffix);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void setPlayerSuffix(Player player, String suffix) {
        wrapped.setSuffix(player.getWorld(), player, suffix);
    }

    @Override
    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return wrapped.playerInGroup(world, player, group);
    }

    @Override
    public boolean playerInGroup(String world, String player, String group) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.playerInGroup(world, uniqueId, group);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean playerInGroup(World world, String player, String group) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.playerInGroup(world, uniqueId, group);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean playerInGroup(Player player, String group) {
        return wrapped.playerInGroup(player.getWorld(), player, group);
    }

    @Override
    public String[] getPlayerGroups(String world, OfflinePlayer player) {
        return Iterables.toArray(wrapped.getGroups(world, player), String.class);
    }

    @Override
    public String[] getPlayerGroups(String world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return Iterables.toArray(wrapped.getGroups(world, uniqueId), String.class);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] getPlayerGroups(World world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return Iterables.toArray(wrapped.getGroups(world, uniqueId), String.class);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] getPlayerGroups(Player player) {
        return Iterables.toArray(wrapped.getGroups(player.getWorld(), player), String.class);
    }

    @Override
    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return wrapped.getPrimaryGroup(world, player);
    }

    @Override
    public String getPrimaryGroup(String world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getPrimaryGroup(world, uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPrimaryGroup(World world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getPrimaryGroup(world, uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPrimaryGroup(Player player) {
        return wrapped.getPrimaryGroup(player.getWorld(), player);
    }

    @Override
    public String[] getGroups() {
        return Iterables.toArray(wrapped.getGroups(), String.class);
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
    public String getPlayerPrefix(String world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getPrefix(world, uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void setPlayerPrefix(String world, String player, String prefix) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setPrefix(world, uniqueId, prefix);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getPlayerSuffix(String world, String player) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getSuffix(world, uniqueId);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void setPlayerSuffix(String world, String player, String suffix) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setSuffix(world, uniqueId, suffix);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getGroupPrefix(String world, String group) {
        return wrapped.getGroupPrefix(world, group);
    }

    @Override
    public void setGroupPrefix(String world, String group, String prefix) {
        wrapped.setGroupPrefix(world, group, prefix);
    }

    @Override
    public String getGroupSuffix(String world, String group) {
        return wrapped.getGroupSuffix(world, group);
    }

    @Override
    public void setGroupSuffix(String world, String group, String suffix) {
        wrapped.setGroupSuffix(world, group, suffix);
    }

    @Override
    public int getPlayerInfoInteger(String world, String player, String node, int defaultValue) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getIntegerPlayerOption(world, uniqueId, node, defaultValue);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setPlayerInfoInteger(String world, String player, String node, int value) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setIntegerPlayerOption(world, uniqueId, node, value);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getGroupInfoInteger(String world, String group, String node, int defaultValue) {
        return wrapped.getIntegerGroupOption(world, group, node, defaultValue);
    }

    @Override
    public void setGroupInfoInteger(String world, String group, String node, int value) {
        wrapped.setIntegerGroupOption(world, group, node, value);
    }

    @Override
    public double getPlayerInfoDouble(String world, String player, String node, double defaultValue) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getDoublePlayerOption(world, uniqueId, node, defaultValue);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setPlayerInfoDouble(String world, String player, String node, double value) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setDoublePlayerOption(world, uniqueId, node, value);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public double getGroupInfoDouble(String world, String group, String node, double defaultValue) {
        return wrapped.getDoubleGroupOption(world, group, node, defaultValue);
    }

    @Override
    public void setGroupInfoDouble(String world, String group, String node, double value) {
        wrapped.setDoubleGroupOption(world, group, node, value);
    }

    @Override
    public boolean getPlayerInfoBoolean(String world, String player, String node, boolean defaultValue) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return uniqueId != null && wrapped.getBooleanPlayerOption(world, uniqueId, node, defaultValue);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void setPlayerInfoBoolean(String world, String player, String node, boolean value) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setBooleanPlayerOption(world, uniqueId, node, value);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean getGroupInfoBoolean(String world, String group, String node, boolean defaultValue) {
        return wrapped.getBooleanGroupOption(world, group, node, defaultValue);
    }

    @Override
    public void setGroupInfoBoolean(String world, String group, String node, boolean value) {
        wrapped.setBooleanGroupOption(world, group, node, value);
    }

    @Override
    public String getPlayerInfoString(String world, String player, String node, String defaultValue) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            return wrapped.getStringPlayerOption(world, uniqueId, node, defaultValue);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void setPlayerInfoString(String world, String player, String node, String value) {
        Trunk.getInstance().getLogger().warning(wrapped.getPlugin().getName() + " is using outdated methods!");
        try {
            UUID uniqueId = UUIDStore.getUniqueId(player);
            wrapped.setStringPlayerOption(world, uniqueId, node, value);
        } catch (UnknownPlayerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getGroupInfoString(String world, String player, String node, String defaultValue) {
        return wrapped.getStringGroupOption(world, player, node, defaultValue);
    }

    @Override
    public void setGroupInfoString(String world, String group, String node, String value) {
        wrapped.setStringGroupOption(world, group, node, value);
    }

}
