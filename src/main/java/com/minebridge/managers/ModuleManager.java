package com.minebridge.managers;

import com.minebridge.MineBridge;
import java.util.List;

public class ModuleManager {

    public ModuleManager(MineBridge plugin) {
        List<String> modules = plugin.getConfig().getStringList("modules");
        plugin.getLogger().info("Loaded modules: " + modules);
    }
}
