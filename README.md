Markdown# 🚀 MineBridge

**MineBridge** is a high-performance, lightweight REST API for Minecraft servers. It allows developers to send console commands to their server via HTTP requests, making it easy to build web dashboards, mobile apps, or Discord integrations.

---

## ✨ Features
- **Modern REST API:** Send commands via standard `POST` requests.
- **CORS Support:** Native support for cross-origin requests, allowing browser-based dashboards to work without issues.
- **Built-in Security:** Every request is protected by a customizable API Key.
- **Zero Lag:** Runs on its own thread pool to ensure the Minecraft main thread remains fast.
- **Hot-Reload:** Change ports or keys and apply them instantly with `/mb reload`.

---

## 🛠️ Installation
1. Download the `MineBridge-1.0.jar`.
2. Drop it into your server's `/plugins` folder.
3. Restart the server to generate `config.yml`.
4. (Optional) If hosting online, request an **Additional Port** from your provider and update the config.

---

## ⚙️ Configuration (`config.yml`)
```yaml
# The port the API will listen on
api-port: 8080

# Your unique authorization key
api-key: "tjcn13791o6dg2lsgd85v81fkp"
🖥️ Developer UsageEndpointPOST http://<server-ip>:<port>/runHeadersHeaderValueAuthorization<your-api-key>Content-Typetext/plainExample (JavaScript)JavaScriptfetch('http://localhost:8080/run', {
    method: 'POST',
    headers: {
        'Authorization': 'tjcn13791o6dg2lsgd85v81fkp',
        'Content-Type': 'text/plain'
    },
    body: 'say Hello from the Dashboard!'
});
📜 Commands/mb reload - Reloads the configuration and restarts the API server.Permission: minebridge.admin🔨 BuildingBuilt with Maven.Clone the repo.Run mvn clean package.Locate the JAR in the /target directory.
---
📄 LicenseDistributed under the MIT License. See LICENSE for more information. 

This plugin make with help of ai vibe coding!!
