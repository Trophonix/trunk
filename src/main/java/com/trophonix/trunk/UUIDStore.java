package com.trophonix.trunk;

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

    public static UUID getUniqueId(String name) {
        for (Profile p : profiles) {
            if (p.name.equals(name)) return p.uniqueId;
        }
        return findAndStoreUniqueId(name);
    }

    public static UUID getUniqueIdIgnoreCase(String name) {
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

    public static UUID findAndStoreUniqueId(String name) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equals(name)) {
                profiles.add(new Profile(player.getUniqueId(), player.getName()));
                return player.getUniqueId();
            }
        }
        return null;
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
