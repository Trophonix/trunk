package com.trophonix.trunk;

import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.TrunkHook;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import com.trophonix.trunk.api.vault.*;
import com.trophonix.trunk.exceptions.HookRegisterException;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lucas on 4/12/17.
 */
@SuppressWarnings("WeakerAccess")
public class Trunk extends JavaPlugin implements Listener {

    private static Trunk instance;

    private final Set<TrunkHook> registeredHooks = new HashSet<>();

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLogin(PlayerLoginEvent event) {
        UUIDStore.store(event.getPlayer());
    }

    @EventHandler
    public void onLoad(PluginEnableEvent event) {
        if (event.getPlugin().getName().equals("Vault")) {
            getServer().getScheduler().runTaskLater(this, () -> {
                ServicesManager man = getServer().getServicesManager();
                RegisteredServiceProvider<Economy> ecoRSP = man.getRegistration(Economy.class);
                if (ecoRSP != null) {
                    Economy eco = ecoRSP.getProvider();
                    if (eco != null) {
                        getLogger().info("Disabling Vault economy...");
                        // Unregister vault economy
                        man.unregister(eco);
                        getLogger().info("Enabling Trunk economy wrapper...");
                        // Register wrapper
                        try {
                            register(new TrunkVaultEconomyWrapper(ecoRSP.getPlugin(), eco));
                            getLogger().info("Enabled Trunk economy wrapper successfully!");
                        } catch (HookRegisterException ex) {
                        }
                    }
                }
                RegisteredServiceProvider<Permission> permRSP = man.getRegistration(Permission.class);
                if (permRSP != null) {
                    Permission perm = permRSP.getProvider();
                    if (perm != null) {
                        getLogger().info("Disabling Vault permissions...");
                        // Unregister vault perms
                        man.unregister(perm);
                        // Register wrapper
                        getLogger().info("Enabling Trunk permissions wrapper...");
                        try {
                            register(new TrunkVaultPermissionsWrapper(permRSP.getPlugin(), perm));
                            getLogger().info("Enabled Trunk permissions wrapper successfully!");
                        } catch (HookRegisterException ex) {
                        }
                    }
                }
                RegisteredServiceProvider<Chat> chatRSP = man.getRegistration(Chat.class);
                if (chatRSP != null) {
                    Chat chat = chatRSP.getProvider();
                    if (chat != null) {
                        getLogger().info("Disabling Vault chat...");
                        // Unregister vault chat
                        getLogger().info("Enabling Trunk chat wrapper...");
                        man.unregister(chat);
                        // Register wrapper
                        try {
                            register(new TrunkVaultChatWrapper(chatRSP.getPlugin(), chat));
                            getLogger().info("Enabled Trunk chat wrapper successfully!");
                        } catch (HookRegisterException ex) {
                        }
                    }
                }
                event.getPlugin().onDisable();
                HandlerList.unregisterAll(event.getPlugin());
            }, 1L);
        }
    }

    /**
     * Register a trunk economy
     * @param hook The economy to register
     * @throws HookRegisterException If the registration fails
     */
    public void register(TrunkEconomy hook) throws HookRegisterException {
        if (registeredHooks.contains(hook)) throw new HookRegisterException("Attempted to register an already-registered hook!");
        for (TrunkHook hooks : registeredHooks) {
            if (hooks.getClass().getSuperclass().equals(hook.getClass().getSuperclass())) {
                throw new HookRegisterException("Attempted to register a hook of a type which is already registered!");
            }
        }
        registeredHooks.add(hook);
        // Register vault wrapper
        getServer().getServicesManager().register(Economy.class, new VaultEconomyWrapper(hook), hook.getPlugin(), ServicePriority.High);
    }

    /**
     * Register trunk permissions
     * @param hook The permissions to register
     * @throws HookRegisterException If the registration fails
     */
    public void register(TrunkPermissions hook) throws HookRegisterException {
        if (registeredHooks.contains(hook)) throw new HookRegisterException("Attempted to register an already-registered hook!");
        for (TrunkHook hooks : registeredHooks) {
            if (hooks.getClass().getSuperclass().equals(hook.getClass().getSuperclass())) {
                throw new HookRegisterException("Attempted to register a hook of a type which is already registered!");
            }
        }
        registeredHooks.add(hook);
        // Register vault wrapper
        getServer().getServicesManager().register(Permission.class, new VaultPermissionWrapper(hook), hook.getPlugin(), ServicePriority.High);
    }

    /**
     * Register a trunk chat
     * @param hook The chat to register
     * @throws HookRegisterException If the registration fails
     */
    public void register(TrunkChat hook) throws HookRegisterException {
        if (registeredHooks.contains(hook)) throw new HookRegisterException("Attempted to register an already-registered hook!");
        for (TrunkHook hooks : registeredHooks) {
            if (hooks.getClass().getSuperclass().equals(hook.getClass().getSuperclass())) {
                throw new HookRegisterException("Attempted to register a hook of a type which is already registered!");
            }
        }
        registeredHooks.add(hook);
        boolean registered = false;
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        if (rsp != null) {
            Permission perm = rsp.getProvider();
            if (perm != null) {
                getServer().getServicesManager().register(Chat.class, new VaultChatWrapper(perm, hook), hook.getPlugin(), ServicePriority.High);
                registered = true;
            }
        }
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Vault wrapped registered: " + registered);
        if (!registered) {
            TrunkPermissions perms = getAPI(TrunkPermissions.class);
            if (perms != null) getServer().getServicesManager().register(Chat.class, new VaultChatWrapper(new VaultPermissionWrapper(perms), hook), hook.getPlugin(), ServicePriority.High);
        }
    }

    public void unregister(TrunkHook hook) {
        registeredHooks.remove(hook);
    }

    public void unregisterAll(Plugin plugin) {
        for (TrunkHook registeredHook : registeredHooks) unregister(registeredHook);
    }

    /**
     * Get an API of a type
     * @param clazz The class of the type API
     * @param <T> The type of API
     * @return The API of type or null if one is not found
     */
    public <T extends TrunkHook> T getAPI(Class<? extends TrunkHook> clazz) {
        for (TrunkHook hooks : registeredHooks) {
            if (hooks.getClass().getSuperclass().equals(clazz)) {
                return (T) hooks;
            }
        }
        return null;
    }

    public static Trunk getInstance() { return instance; }

}
