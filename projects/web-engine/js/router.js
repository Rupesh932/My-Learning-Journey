// ============================================
//  MLJ — router.js
//  Page renderer
// ============================================

const Router = {

  // ---------- STATUS HELPERS ----------
  badge(s) {
    const m = {
      done:     `<span class="topic-status status-done">✓ done</span>`,
      learning: `<span class="topic-status status-learning">⟳ learning</span>`,
      todo:     `<span class="topic-status status-todo">○ todo</span>`,
    };
    return m[s] || '';
  },

  select(id, cur) {
    return `
    <select class="status-sel" onchange="MLJ.updateStatus('${id}', this.value)"
      style="font-size:.7rem;padding:2px 6px;border-radius:4px;border:1px solid var(--border);
             background:var(--bg3);color:var(--text2);cursor:pointer;font-family:var(--font-mono)">
      <option value="todo"     ${cur==='todo'    ?'selected':''}>○ todo</option>
      <option value="learning" ${cur==='learning'?'selected':''}>⟳ learning</option>
      <option value="done"     ${cur==='done'    ?'selected':''}>✓ done</option>
    </select>`;
  },

  // ---------- TOPIC ROW ----------
  topicRow(t, color) {
    // Lab button — opens lab at correct section
    const labBtn = t.lab
      ? `<a class="btn btn-sm" href="./contents/java/${t.lab}${t.labSection ? '#'+t.labSection : ''}"
            target="_blank" style="color:${color};border-color:${color}33">🧪 lab</a>`
      : '';

    // Notes buttons — one per note file
    const notesBtns = (t.notes || []).map(n => {
      const name = n.split('/').pop().replace('_drawio','').replace('.svg','').replace('.html','');
      return `<a class="btn btn-sm" href="${n}" target="_blank"
                 style="color:#2dd4a0;border-color:#2dd4a033">📐 ${name}</a>`;
    }).join('');

    // Tags
    const tags = (t.tags || []).slice(0,3).map(tag =>
      `<span class="tag" style="color:${color};font-size:.65rem">${tag}</span>`
    ).join('');

    return `
    <div class="topic-row">
      <div style="flex:1;min-width:0">
        <div class="topic-name">${t.name}</div>
        <div class="flex gap-sm mt-sm" style="flex-wrap:wrap">${tags}</div>
      </div>
      <div class="flex gap-sm" style="flex-shrink:0;align-items:center;flex-wrap:wrap">
        ${labBtn}${notesBtns}
        ${this.badge(t.status)}
        ${this.select(t.id, t.status)}
      </div>
    </div>`;
  },

  // ---------- GREETING ----------
  greeting() {
    const h = new Date().getHours();
    return h < 12 ? 'morning' : h < 17 ? 'afternoon' : 'evening';
  },

  // ╔══════════════════════════════╗
  // ║  DASHBOARD                  ║
  // ╚══════════════════════════════╝
  renderDashboard() {
    const s     = MLJ.getStats();
    const langs = Object.keys(MLJ.langs);
    return `
    <div class="page fade-in">
      <div class="page-header">
        <div>
          <div class="page-title">Good ${this.greeting()}, Rupesh 👋</div>
          <div class="page-sub">// My Learning Journey · ${new Date().toLocaleDateString('en-GB',{day:'numeric',month:'short',year:'numeric'})}</div>
        </div>
        <span class="tag" style="color:#2dd4a0;font-size:.82rem;padding:4px 12px">${s.pct}% complete</span>
      </div>

      <!-- STATS -->
      <div class="grid-4 mb-lg">
        ${[
          { v: s.done,     l: 'Completed',   sub: 'topics mastered',   c: '#2dd4a0' },
          { v: s.learning, l: 'In Progress',  sub: 'currently active',  c: '#f89820' },
          { v: s.todo,     l: 'Upcoming',     sub: 'topics ahead',      c: 'var(--text3)' },
          { v: s.total,    l: 'Total',        sub: 'all subjects',      c: '#60a5fa' },
        ].map(x => `
        <div class="stat-card" style="--accent-color:${x.c}">
          <div class="stat-value" style="color:${x.c}">${x.v}</div>
          <div class="stat-label">${x.l}</div>
          <div class="stat-sub">${x.sub}</div>
        </div>`).join('')}
      </div>

      <!-- OVERALL PROGRESS -->
      <div class="card mb-lg">
        <div class="section-header">
          <div class="section-label">Overall Progress</div>
          <span class="text-muted">${s.done} / ${s.total}</span>
        </div>
        <div class="progress-wrap" style="height:8px;margin-top:var(--sp-sm)">
          <div class="progress-fill" style="--fill-color:#2dd4a0;width:${s.pct}%"></div>
        </div>
      </div>

      <!-- LANGUAGE GRID -->
      <div class="section-header mb-md"><div class="section-label">By Language</div></div>
      <div class="grid-auto mb-lg">
        ${langs.map(l => {
          const ls = MLJ.getLangStats(l);
          const lc = MLJ.langs[l];
          return `
          <div class="stat-card" style="--accent-color:${lc.color};cursor:pointer"
               onclick="MLJ.navigate('${l}')">
            <div class="flex gap-sm" style="align-items:center;margin-bottom:var(--sp-md)">
              <span style="font-size:1.3rem">${lc.icon}</span>
              <span style="font-family:var(--font-sans);font-weight:700">${lc.label}</span>
              <span class="tag" style="color:${lc.color};margin-left:auto">${ls.pct}%</span>
            </div>
            <div class="progress-wrap">
              <div class="progress-fill" style="--fill-color:${lc.color};width:${ls.pct}%"></div>
            </div>
            <div class="mt-sm text-muted">${ls.done} / ${ls.total} done · click to view</div>
          </div>`;
        }).join('')}
      </div>

      <!-- QUICK OPEN -->
      <div class="section-header mb-md"><div class="section-label">Quick Open</div></div>
      <div class="grid-3 mb-lg">
        <a class="card card-sm btn" style="justify-content:flex-start;gap:var(--sp-sm)"
           href="./contents/java/memory-lab.html" target="_blank">
          🧪 OOP Memory Lab
        </a>
        <button class="card card-sm btn" style="justify-content:flex-start;gap:var(--sp-sm)"
           onclick="MLJ.navigate('progress')">
          📊 Progress Tracker
        </button>
        <a class="card card-sm btn" style="justify-content:flex-start;gap:var(--sp-sm)"
           href="https://github.com/Rupesh932/jdbc-crud" target="_blank">
          ⚙ JDBC Project ↗
        </a>
      </div>

      <!-- SUSHASAN-X -->
      <div class="card" style="border-left:3px solid #f89820">
        <div class="flex gap-sm" style="align-items:center;margin-bottom:var(--sp-sm)">
          <span>🏛</span><h3>Sushasan-X — Milestone Project</h3>
          <span class="tag" style="color:#f89820;margin-left:auto">⟳ planning</span>
        </div>
        <p>Nepal को digital governance watchdog। ~7 हप्ता gap filling पछि build start।</p>
        <div class="flex gap-sm mt-md" style="flex-wrap:wrap">
          ${['Spring Boot 3','PostgreSQL','Redis','JWT Auth','Escalation Engine','Civic Tech'].map(t =>
            `<span class="tag" style="color:#f89820">${t}</span>`).join('')}
        </div>
      </div>
    </div>`;
  },

  // ╔══════════════════════════════╗
  // ║  LANGUAGE PAGE              ║
  // ╚══════════════════════════════╝
  renderLang(lang) {
    const lc     = MLJ.langs[lang];
    const topics = MLJ.topics(lang);
    const ls     = MLJ.getLangStats(lang);

    const groups = {
      learning: topics.filter(t => t.status === 'learning'),
      done:     topics.filter(t => t.status === 'done'),
      todo:     topics.filter(t => t.status === 'todo'),
    };

    const section = (label, emoji, items) => !items.length ? '' : `
      <div class="section-header mb-md">
        <div class="section-label">${emoji} ${label}</div>
        <span class="text-muted">${items.length} topics</span>
      </div>
      <div class="card mb-lg" style="padding:var(--sp-sm)">
        ${items.map(t => this.topicRow(t, lc.color)).join('')}
      </div>`;

    return `
    <div class="page fade-in">
      <div class="page-header">
        <div>
          <div class="page-title">${lc.icon} ${lc.label}</div>
          <div class="page-sub">// ${ls.done} done · ${groups.learning.length} learning · ${groups.todo.length} todo</div>
        </div>
        <span class="tag" style="color:${lc.color}">${ls.pct}%</span>
      </div>

      <div class="card mb-lg">
        <div class="progress-wrap" style="height:8px">
          <div class="progress-fill" style="--fill-color:${lc.color};width:${ls.pct}%"></div>
        </div>
      </div>

      ${section('Currently Learning', '⟳', groups.learning)}
      ${section('Completed', '✓', groups.done)}
      ${section('Upcoming', '○', groups.todo)}
    </div>`;
  },

  // ╔══════════════════════════════╗
  // ║  PROJECTS                   ║
  // ╚══════════════════════════════╝
  renderProjects() {
    return `
    <div class="page fade-in">
      <div class="page-header">
        <div><div class="page-title">🚀 Projects</div>
        <div class="page-sub">// real output — built with purpose</div></div>
      </div>
      <div class="grid-2">
        <div class="card" style="border-top:3px solid #2dd4a0">
          <h3 class="mb-md">⚙ JDBC CRUD</h3>
          <p>Custom CRUD engine — OperationStatus enum, CrudManager/CrudImpl separation, metadata-driven design.</p>
          <div class="flex gap-sm mt-md">
            <a class="btn btn-sm" href="https://github.com/Rupesh932/jdbc-crud" target="_blank">↗ GitHub</a>
            <span class="topic-status status-done">✓ done</span>
          </div>
        </div>
        <div class="card" style="border-top:3px solid #f89820">
          <h3 class="mb-md">🏛 Sushasan-X MVP</h3>
          <p>Nepal governance transparency platform। ~7 हप्ता पछि Phase 1 start।</p>
          <div class="flex gap-sm mt-md">
            <span class="topic-status status-learning">⟳ planning</span>
          </div>
        </div>
      </div>

      <div class="card mt-lg" style="border-left:3px solid #f89820">
        <h3 class="mb-md">Sushasan-X — Full Breakdown</h3>
        ${[
          ['Phase 1 — Service Guide',     'Service data, documents, fees, deadlines'],
          ['Phase 2 — Complaint Filing',  'OTP auth, file upload, tracking ID'],
          ['Phase 3 — Escalation Engine', 'SLA timer, Yellow/Red Card, PMO alert'],
          ['Phase 4 — Public Dashboard',  'Office ratings, delay trends, reports'],
        ].map(([name, desc]) => `
        <div class="topic-row">
          <div style="flex:1"><div class="topic-name">${name}</div>
          <div class="text-muted" style="font-size:.75rem">${desc}</div></div>
          <span class="topic-status status-todo">○ todo</span>
        </div>`).join('')}
      </div>
    </div>`;
  },

  // ╔══════════════════════════════╗
  // ║  NOTES                      ║
  // ╚══════════════════════════════╝
  renderNotes() {
    // Collect all notes from all topics
    const allNotes = [];
    Object.keys(MLJ.langs).forEach(lang => {
      MLJ.topics(lang).forEach(t => {
        (t.notes || []).forEach(n => {
          if (!allNotes.find(x => x.file === n)) {
            allNotes.push({ file: n, topic: t.name, lang });
          }
        });
      });
    });

    return `
    <div class="page fade-in">
      <div class="page-header">
        <div><div class="page-title">📐 Notes & Drawings</div>
        <div class="page-sub">// drawio · excalidraw · memory models</div></div>
      </div>

      <!-- LINKED FROM TOPICS -->
      ${allNotes.length ? `
      <div class="section-header mb-md"><div class="section-label">Linked from Topics</div></div>
      <div class="grid-auto mb-lg">
        ${allNotes.map(n => {
          const lc   = MLJ.langs[n.lang];
          const name = n.file.split('/').pop().replace('_drawio','').replace('.svg','');
          return `
          <div class="card" style="border-left:3px solid #2dd4a0">
            <div class="flex gap-sm" style="align-items:center;margin-bottom:var(--sp-sm)">
              <span>📊</span><h4>${name}</h4>
              <span class="tag" style="color:${lc.color};margin-left:auto">${lc.icon} ${lc.label}</span>
            </div>
            <div class="text-muted" style="font-size:.75rem">from: ${n.topic}</div>
            <a class="btn btn-sm mt-md" href="${n.file}" target="_blank"
               style="color:#2dd4a0;border-color:#2dd4a033">↗ Open SVG</a>
          </div>`;
        }).join('')}
      </div>` : ''}

      <!-- MEMORY LAB -->
      <div class="section-header mb-md"><div class="section-label">Interactive Labs</div></div>
      <div class="grid-auto">
        <div class="card" style="border-left:3px solid #f89820">
          <div class="flex gap-sm" style="align-items:center;margin-bottom:var(--sp-sm)">
            <span>🧠</span><h4>OOP Java Memory Lab</h4>
            <span class="tag" style="color:#f89820;margin-left:auto">7 chapters</span>
          </div>
          <p class="text-muted mt-sm">Stack, Heap, JVM, Object Creation, String Pool, Pass by Value, Call Stack</p>
          <a class="btn btn-sm mt-md" href="./contents/java/memory-lab.html" target="_blank"
             style="background:#f89820;border-color:#f89820;color:#000">↗ Open Lab</a>
        </div>
      </div>

      <!-- HOW TO ADD NOTES -->
      <div class="card mt-lg" style="border:1px dashed var(--border2)">
        <div class="section-label mb-md">How to add notes</div>
        <div class="code-block" style="margin:0;font-size:.75rem">
// contents/java/index.json मा topic को notes array मा थप्नुस्:
{
  "id": "j5",
  "name": "JVM Architecture",
  "notes": [
    "../../assets/image/java/jvmarchitecture_drawio.svg",
    "../../assets/image/java/my_new_note.svg"
  ]
}
// Dashboard ले automatically link गर्छ।
        </div>
      </div>
    </div>`;
  },

  // ╔══════════════════════════════╗
  // ║  PROGRESS                   ║
  // ╚══════════════════════════════╝
  renderProgress() {
    const s     = MLJ.getStats();
    const langs = Object.keys(MLJ.langs);
    return `
    <div class="page fade-in">
      <div class="page-header">
        <div><div class="page-title">📊 Progress</div>
        <div class="page-sub">// full picture of your journey</div></div>
        <span class="tag" style="color:#60a5fa;font-size:.82rem;padding:4px 12px">${s.pct}%</span>
      </div>

      <!-- OVERALL -->
      <div class="card mb-lg" style="border-top:3px solid #60a5fa">
        <div class="section-header">
          <h3>Overall</h3><span class="text-muted">${s.done}/${s.total}</span>
        </div>
        <div class="progress-wrap" style="height:10px;margin:var(--sp-md) 0">
          <div class="progress-fill" style="--fill-color:#60a5fa;width:${s.pct}%"></div>
        </div>
        <div class="grid-3">
          ${[
            [s.done,     'Done',     '#2dd4a0'],
            [s.learning, 'Learning', '#f89820'],
            [s.todo,     'Todo',     'var(--text3)'],
          ].map(([v,l,c]) => `
          <div style="text-align:center;padding:var(--sp-md)">
            <div style="font-size:2rem;font-weight:800;color:${c};font-family:var(--font-sans)">${v}</div>
            <div class="text-muted">${l}</div>
          </div>`).join('')}
        </div>
      </div>

      <!-- PER LANGUAGE -->
      <div class="grid-2 mb-lg">
        ${langs.map(l => {
          const ls     = MLJ.getLangStats(l);
          const lc     = MLJ.langs[l];
          const topics = MLJ.topics(l);
          return `
          <div class="card">
            <div class="section-header mb-md">
              <h3>${lc.icon} ${lc.label}</h3>
              <span class="tag" style="color:${lc.color}">${ls.pct}%</span>
            </div>
            <div class="progress-wrap mb-md">
              <div class="progress-fill" style="--fill-color:${lc.color};width:${ls.pct}%"></div>
            </div>
            ${topics.map(t => `
            <div style="display:flex;align-items:center;gap:8px;padding:3px 0;font-size:.78rem">
              <span style="color:${t.status==='done'?'#2dd4a0':t.status==='learning'?'#f89820':'var(--text3)'}">
                ${t.status==='done'?'✓':t.status==='learning'?'⟳':'○'}
              </span>
              <span style="color:var(--text2);flex:1">${t.name}</span>
            </div>`).join('')}
          </div>`;
        }).join('')}
      </div>

      <!-- ROADMAP -->
      <div class="card" style="border-top:3px solid #f89820">
        <h3 class="mb-lg">🗺 Roadmap → Sushasan-X</h3>
        ${[
          { l:'Gap filling (Generics, Enum)',         s:'learning', t:'2 हप्ता' },
          { l:'Spring Boot — IoC/DI re-entry',        s:'todo',     t:'3 हप्ता' },
          { l:'Spring Security + JWT',                s:'todo',     t:'2 हप्ता' },
          { l:'Sushasan-X Phase 1 — Service Guide',   s:'todo',     t:'6 हप्ता' },
          { l:'Sushasan-X Phase 2 — Complaints',      s:'todo',     t:'6 हप्ता' },
          { l:'Sushasan-X Phase 3 — Escalation',      s:'todo',     t:'8 हप्ता' },
          { l:'Sushasan-X Phase 4 — Dashboard',       s:'todo',     t:'6 हप्ता' },
        ].map(r => `
        <div class="topic-row">
          <span style="color:${r.s==='done'?'#2dd4a0':r.s==='learning'?'#f89820':'var(--text3)'}">
            ${r.s==='done'?'✓':r.s==='learning'?'⟳':'○'}
          </span>
          <span class="topic-name">${r.l}</span>
          <span class="text-muted">${r.t}</span>
          ${this.badge(r.s)}
        </div>`).join('')}
      </div>
    </div>`;
  },

  // ╔══════════════════════════════╗
  // ║  MAIN RENDER                ║
  // ╚══════════════════════════════╝
  render() {
    const el = document.getElementById('mlj-content');
    if (!el) return;
    const p = MLJ.state.currentPage;

    if      (p === 'dashboard') el.innerHTML = this.renderDashboard();
    else if (p === 'projects')  el.innerHTML = this.renderProjects();
    else if (p === 'notes')     el.innerHTML = this.renderNotes();
    else if (p === 'progress')  el.innerHTML = this.renderProgress();
    else if (MLJ.langs[p])      el.innerHTML = this.renderLang(p);

    // Sync nav active state
    document.querySelectorAll('.nav-item').forEach(nav => {
      nav.classList.toggle('active', nav.dataset.page === p);
    });
  }
};