import os

# १. फोल्डर स्ट्रक्चर (New Sibling Design)
folders = [
    'web-engine/css',
    'web-engine/js',
    'contents/java/css',
    'contents/java/js',
    'contents/js',
    'assets'
]

# २. फाइल र तिनका सामग्रीहरू
files = {
    # Main Entry Point
    'index.html': """<!DOCTYPE html>
<html lang="ne">
<head>
    <meta charset="UTF-8">
    <title>MLJ Portal | Rupesh</title>
    <link rel="stylesheet" href="web-engine/css/global.css">
</head>
<body>
    <div class="sidebar">
        <h2>MLJ Portal</h2>
        <nav>
            <a href="#home">🏠 Dashboard</a>
            <hr><span class="nav-label">JAVA JOURNEY</span>
            <a href="#java-vars">📊 Variables & Types</a>
            <a href="#java-memory">🧪 Memory Lab</a>
            <hr><span class="nav-label">JS JOURNEY</span>
            <a href="#js-home">⚡ JS Basics</a>
        </nav>
    </div>
    <div class="main-content">
        <header><h1 id="page-title">Welcome</h1></header>
        <div id="view-port"></div>
    </div>
    <script src="web-engine/js/router.js"></script>
</body>
</html>""",

    # Global CSS
    'web-engine/css/global.css': """
        body { display: flex; margin: 0; font-family: 'Segoe UI', sans-serif; background: #f0f2f5; }
        .sidebar { width: 260px; background: #1a1a2e; color: white; height: 100vh; padding: 20px; position: fixed; }
        .sidebar a { color: #a2a2d0; display: block; padding: 12px; text-decoration: none; transition: 0.3s; }
        .sidebar a:hover { background: #16213e; color: white; border-radius: 5px; }
        .nav-label { font-size: 0.75rem; color: #533483; font-weight: bold; margin: 15px 0 5px 10px; display: block; }
        .main-content { margin-left: 260px; flex: 1; padding: 40px; }
        .card { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
    """,

    # Router Logic
    'web-engine/js/router.js': """
        const routes = {
            'home': '<h2>नमस्ते रूपेश!</h2><p>तपाईंको सिकाइ यात्रा यहाँबाट सुरु हुन्छ।</p>',
            'java-vars': 'contents/java/variables.html',
            'java-memory': 'contents/java/memory-lab.html'
        };

        async function navigate() {
            const hash = window.location.hash.substring(1) || 'home';
            const view = document.getElementById('view-port');
            if (routes[hash].endsWith('.html')) {
                const res = await fetch(routes[hash]);
                view.innerHTML = await res.text();
                // केही बेर पर्खेर स्क्रिप्ट लोड गर्ने (यदि चाहिन्छ भने)
                if(hash === 'java-vars' || hash === 'java-memory') loadJavaLogic();
            } else { view.innerHTML = routes[hash]; }
        }

        window.onhashchange = navigate;
        window.onload = navigate;
    """,

    # Java Variables Page (Interaction + Visualization)
    'contents/java/variables.html': """
        <div class="card">
            <h3>Java Variables & Data Types</h3>
            <p>Type र Value रोज्नुहोस् र Memory (Stack) मा कति ठाउँ ओगट्छ हेर्नुहोस्।</p>
            <div style="display: flex; gap: 10px; margin-bottom: 20px;">
                <select id="vType">
                    <option value="1">byte (1B)</option>
                    <option value="4">int (4B)</option>
                    <option value="8">double (8B)</option>
                </select>
                <input type="text" id="vName" placeholder="Variable Name">
                <input type="number" id="vVal" placeholder="Value">
                <button onclick="createVar()">Create Variable</button>
            </div>
            <div id="stack-container" style="border: 2px solid #333; padding: 10px; min-height: 100px; background: #fff5f5;">
                <strong>Stack Memory Area</strong>
                <div id="stack-vars"></div>
            </div>
        </div>
        <script>
            function createVar() {
                const name = document.getElementById('vName').value || 'var';
                const size = document.getElementById('vType').value;
                const val = document.getElementById('vVal').value;
                const list = document.getElementById('stack-vars');
                list.innerHTML += `<div style="background:#ff7675; color:white; padding:5px; margin:5px; border-radius:3px;">
                    \${name} | Size: \${size}B | Value: \${val}
                </div>`;
            }
        </script>
    """,

    # Java Memory Lab (Object Authority + Padding)
    'contents/java/memory-lab.html': """
        <div class="card">
            <h3>Object Memory Visualizer (Heap)</h3>
            <p>तपाईंको Draw.io PDF को Page 4 को Logic: 16B Header + Data + Padding</p>
            <button onclick="buildObject()">Create Object (57B Data)</button>
            <div id="heap-animation" style="margin-top:20px;"></div>
        </div>
        <script>
            function buildObject() {
                const header = 16; const data = 57;
                const raw = header + data;
                const padding = (raw % 8 === 0) ? 0 : 8 - (raw % 8);
                const total = raw + padding;
                document.getElementById('heap-animation').innerHTML = `
                    <div style="border:2px solid #2c3e50; width:250px; text-align:center;">
                        <div style="background:#fdcb6e; padding:10px;">Header (16B)</div>
                        <div style="background:#74b9ff; padding:20px; color:white;">Data (57B)</div>
                        <div style="background:#dfe6e9; padding:5px;">Padding (\${padding}B)</div>
                        <div style="background:#2c3e50; color:white; padding:10px;">Total: \${total} Bytes</div>
                    </div>
                `;
            }
        </script>
    """
}

# फोल्डर र फाइल निर्माण
for f in folders: os.makedirs(f, exist_ok=True)
for path, content in files.items():
    with open(path, 'w', encoding='utf-8') as f: f.write(content)

print("🚀 Portal Structure with Java Content created in mlj/projects!")
