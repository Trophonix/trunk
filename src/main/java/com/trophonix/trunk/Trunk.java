package com.trophonix.trunk;

import com.trophonix.trunk.api.TrunkAPI;
import com.trophonix.trunk.api.UUIDStore;
import com.trophonix.trunk.api.chat.TrunkChat;
import com.trophonix.trunk.api.economy.TrunkEconomy;
import com.trophonix.trunk.api.events.APIRegisterEvent;
import com.trophonix.trunk.api.exceptions.APIRegisterException;
import com.trophonix.trunk.api.permissions.TrunkPermissions;
import com.trophonix.trunk.vault.*;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
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

/**
 * Created by Lucas on 4/12/17.
 */
public class Trunk extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLogin(PlayerLoginEvent event) {
        UUIDStore.store(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRegister(APIRegisterEvent event) {
        if (event.isEconomy()) {
            getServer().getServicesManager().register(Economy.class, new VaultEconomyWrapper((TrunkEconomy) event.getAPI()), event.getPlugin(), ServicePriority.Highest);
        } else if (event.isPermissions()) {
            getServer().getServicesManager().register(Permission.class, new VaultPermissionWrapper((TrunkPermissions)event.getAPI()), event.getPlugin(), ServicePriority.Highest);
        } else if (event.isChat()) {
            RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
            if (rsp != null && rsp.getProvider() != null)
                getServer().getServicesManager().register(Chat.class, new VaultChatWrapper(rsp.getProvider(), (TrunkChat)event.getAPI()), event.getPlugin(), ServicePriority.Highest);
        }
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
                        getLogger().info("Found Vault economy! Disabling...");
                        // Unregister vault economy
                        man.unregister(eco);
                        getLogger().info("Enabling Trunk economy wrapper...");
                        // Register wrapper
                        try {
                            TrunkAPI.register(new TrunkVaultEconomyWrapper(ecoRSP.getPlugin(), eco));
                            getLogger().info("Enabled Trunk economy wrapper successfully!");
                        } catch (APIRegisterException ex) {
                            getLogger().info("Failed to register wrapper. Another economy api may already be registered.");
                        }
                    }
                }
                RegisteredServiceProvider<Permission> permRSP = man.getRegistration(Permission.class);
                if (permRSP != null) {
                    Permission perm = permRSP.getProvider();
                    if (perm != null) {
                        getLogger().info("Found Vault permission! Disabling...");
                        // Unregister vault perms
                        man.unregister(perm);
                        // Register wrapper
                        getLogger().info("Enabling Trunk permissions wrapper...");
                        try {
                            TrunkAPI.register(new TrunkVaultPermissionsWrapper(permRSP.getPlugin(), perm));
                            getLogger().info("Enabled Trunk permissions wrapper successfully!");
                        } catch (APIRegisterException ex) {
                            getLogger().info("Failed to register wrapper. Another permissions api may already be registered.");
                        }
                    }
                }
                RegisteredServiceProvider<Chat> chatRSP = man.getRegistration(Chat.class);
                if (chatRSP != null) {
                    Chat chat = chatRSP.getProvider();
                    if (chat != null) {
                        getLogger().info("Found Vault chat! Disabling...");
                        // Unregister vault chat
                        getLogger().info("Enabling Trunk chat wrapper...");
                        man.unregister(chat);
                        // Register wrapper
                        try {
                            TrunkAPI.register(new TrunkVaultChatWrapper(chatRSP.getPlugin(), chat));
                            getLogger().info("Enabled Trunk chat wrapper successfully!");
                        } catch (APIRegisterException ex) {
                            getLogger().info("Failed to register wrapper. Another chat api may already be registered.");
                        }
                    }
                }
                getServer().getServicesManager().unregisterAll(event.getPlugin());
                event.getPlugin().onDisable();
                HandlerList.unregisterAll(event.getPlugin());
            }, 1L);
        }
    }

}
