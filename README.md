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
📜 Commands/mb reload - Reloads the configuration and restarts the API server.Permission: minebridge.admin🔨 BuildingBuilt with Maven.Clone the repo.Run mvn clean package.Locate the JAR in the /target directory.📄 LicenseDistributed under the MIT License. See LICENSE for more information.
---

### 2. `LICENSE`
Create a file named **`LICENSE`** (no file extension) in the same folder and paste this:

```text
MIT License

Copyright (c) 2024 MineBridge Developer

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
Why this is good for you:Credibility: Other developers see you follow standard practices (README + License).Support: You won't have to answer the same questions about how to install it; they can just read the guide.Collaboration: If you upload this to GitHub, people can see how to contribute to your code!
