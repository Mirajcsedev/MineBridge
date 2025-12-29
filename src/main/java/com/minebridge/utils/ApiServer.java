package com.minebridge.utils;

import com.minebridge.MineBridge;
import com.sun.net.httpserver.HttpServer;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ApiServer {
    private final MineBridge plugin;
    private HttpServer server;

    public ApiServer(MineBridge plugin) { this.plugin = plugin; }

    public void start() {
        int port = plugin.getConfig().getInt("api-port", 8080);
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/run", exchange -> {
                
                // --- FIX: THIS ALLOWS THE BROWSER TO TALK TO THE SERVER ---
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, OPTIONS");
                exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Authorization, Content-Type");

                // Handle the browser's "security check" (Pre-flight)
                if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                    exchange.sendResponseHeaders(204, -1);
                    exchange.close();
                    return;
                }

                try {
                    // Security check for your API key
                    String auth = exchange.getRequestHeaders().getFirst("Authorization");
                    String key = plugin.getConfig().getString("api-key");

                    if (key == null || !key.equals(auth)) {
                        sendResponse(exchange, 403, "Invalid API Key");
                        return;
                    }

                    // Read the command from the web page
                    String command = new String(exchange.getRequestBody().readAllBytes()).trim();
                    
                    // Task: Run command on the main Minecraft thread
                    Bukkit.getScheduler().runTask(plugin, () -> {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                    });

                    sendResponse(exchange, 200, "Success");
                } catch (Exception e) {
                    sendResponse(exchange, 500, "Error: " + e.getMessage());
                } finally {
                    exchange.close();
                }
            });

            server.setExecutor(Executors.newFixedThreadPool(2));
            server.start();
            plugin.getLogger().info("API Online on port " + port);
        } catch (IOException e) {
            plugin.getLogger().severe("API Failed: " + e.getMessage());
        }
    }

    public void stop() { if (server != null) server.stop(0); }

    private void sendResponse(com.sun.net.httpserver.HttpExchange ex, int code, String msg) throws IOException {
        byte[] bytes = msg.getBytes();
        ex.sendResponseHeaders(code, bytes.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
    }
}