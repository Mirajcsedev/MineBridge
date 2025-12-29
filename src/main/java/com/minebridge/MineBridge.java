package com.minebridge;

import com.minebridge.utils.ApiServer;
import org.bukkit.plugin.java.JavaPlugin;

public class MineBridge extends JavaPlugin {
    private ApiServer apiServer;

    @Override
    public void onEnable() {
        // 1. Save or load the config.yml (important for api-key and api-port)
        saveDefaultConfig();

        // 2. Register the reload/admin command
        if (getCommand("mb") != null) {
            getCommand("mb").setExecutor(new CommandManager(this));
        }

        // 3. Start the API Server
        startApi();

        getLogger().info("================================");
        getLogger().info("   MineBridge has been ENABLED  ");
        getLogger().info("   API is listening on port: " + getConfig().getInt("api-port", 8080));
        getLogger().info("================================");
    }

    /**
     * Helper method to start the API Server
     */
    public void startApi() {
        try {
            apiServer = new ApiServer(this);
            apiServer.start();
        } catch (Exception e) {
            getLogger().severe("Could not start API Server! Error: " + e.getMessage());
        }
    }

    /**
     * Helper method to stop the API Server (used during reload or disable)
     */
    public void stopApi() {
        if (apiServer != null) {
            apiServer.stop();
            apiServer = null;
        }
    }

    @Override
    public void onDisable() {
        // Stop the API server to free up the port (prevents 'Address already in use' errors)
        stopApi();
        getLogger().info("MineBridge has been DISABLED and API port freed.");
    }
}