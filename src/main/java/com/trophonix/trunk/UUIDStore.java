package com.trophonix.trunk;

import com.trophonix.trunk.exceptions.UnknownPlayerException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Lucas on 4/13/17.
 */
@SuppressWarnings("WeakerAccess")
public class UUIDStore {

    private static final Set<Profile> profiles = new HashSet<>();

    public static UUID getUniqueId(String name) throws UnknownPlayerException {
        for (Profile p : profiles) {
            if (p.name.equalsIgnoreCase(name)) return p.uniqueId;
        }
        return findAndStoreUniqueId(name);
    }

    public static String getName(UUID uniqueId) {
        for (Profile p : profiles) {
            if (p.uniqueId.equals(uniqueId)) return p.name;
        }
        return findAndStoreName(uniqueId);
    }

    public static UUID findAndStoreUniqueId(String name) throws UnknownPlayerException {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) {
                profiles.add(new Profile(player.getUniqueId(), player.getName()));
                return player.getUniqueId();
            }
        }
        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            if (player.getName().equalsIgnoreCase(name)) {
                store(player);
                return player.getUniqueId();
            }
        }
        throw new UnknownPlayerException(name);
    }

    public static String findAndStoreName(UUID uniqueId) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId().equals(uniqueId)) {
                profiles.add(new Profile(player.getUniqueId(), player.getName()));
                return player.getName();
            }
        }
        return null;
    }

    public static void store(OfflinePlayer player) {
        profiles.add(new Profile(player.getUniqueId(), player.getName()));
    }

    static class Profile {

        public final UUID uniqueId;
        public final String name;

        Profile(UUID uniqueId, String name) {
            this.uniqueId = uniqueId;
            this.name = name;
        }

    }

}
