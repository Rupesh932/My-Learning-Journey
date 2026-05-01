// ============================================
//  MLJ — dashboard.js
//  Data layer — loads from index.json files
// ============================================

const MLJ = {

  // ---------- RAW DATA (fallback if JSON fails) ----------
  _data: {},

  // ---------- LANG CONFIG ----------
  langs: {
    java:     { label: 'Java',      icon: '☕', color: '#f89820', jsonPath: './contents/java/index.json' },
    js:       { label: 'JavaScript',icon: '⚡', color: '#f7df1e', jsonPath: './contents/js/index.json'   },
    cpp:      { label: 'C++',       icon: '⚙',  color: '#00599c', jsonPath: './contents/cpp/index.json'  },
    dsa:      { label: 'DSA',       icon: '🌳', color: '#a855f7', jsonPath: './contents/dsa/index.json'  },
  },

  // ---------- LOAD ALL JSON MANIFESTS ----------
  async loadAll() {
    const keys = Object.keys(this.langs);
    await Promise.all(keys.map(async lang => {
      try {
        const res  = await fetch(this.langs[lang].jsonPath);
        const data = await res.json();
        // Merge saved progress from localStorage
        const saved = this._savedProgress();
        data.topics.forEach(t => {
          if (saved[t.id]) t.status = saved[t.id];
        });
        this._data[lang] = data.topics;
      } catch(e) {
        console.warn(`Could not load ${lang}/index.json — using empty`, e);
        this._data[lang] = [];
      }
    }));
  },

  // ---------- TOPIC ACCESS ----------
  topics(lang) {
    return this._data[lang] || [];
  },

  allTopics() {
    return Object.values(this._data).flat();
  },

  // ---------- STATS ----------
  getStats() {
    const all      = this.allTopics();
    const done     = all.filter(t => t.status === 'done').length;
    const learning = all.filter(t => t.status === 'learning').length;
    const todo     = all.filter(t => t.status === 'todo').length;
    const total    = all.length;
    return { done, learning, todo, total, pct: total ? Math.round((done/total)*100) : 0 };
  },

  getLangStats(lang) {
    const items = this.topics(lang);
    const done  = items.filter(t => t.status === 'done').length;
    const total = items.length;
    return { done, total, pct: total ? Math.round((done/total)*100) : 0 };
  },

  // ---------- STATUS UPDATE ----------
  updateStatus(id, newStatus) {
    // Find and update in _data
    for (const lang of Object.keys(this._data)) {
      const topic = this._data[lang].find(t => t.id === id);
      if (topic) {
        topic.status = newStatus;
        break;
      }
    }
    // Save to localStorage
    const progress = {};
    this.allTopics().forEach(t => { progress[t.id] = t.status; });
    localStorage.setItem('mlj-progress', JSON.stringify(progress));
    // Re-render
    Router.render();
    this._updateSidebarBadges();
    this._updateTopbar();
  },

  _savedProgress() {
    try { return JSON.parse(localStorage.getItem('mlj-progress') || '{}'); }
    catch { return {}; }
  },

  // ---------- THEME ----------
  initTheme() {
    const saved = localStorage.getItem('mlj-theme');
    if (saved) document.documentElement.setAttribute('data-theme', saved);
    this._updateThemeIcon();

    // Listen for system preference changes
    window.matchMedia('(prefers-color-scheme: dark)')
      .addEventListener('change', () => {
        if (!localStorage.getItem('mlj-theme')) this._updateThemeIcon();
      });
  },

  toggleTheme() {
    const cur    = document.documentElement.getAttribute('data-theme');
    const sysDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
    const isDark  = cur === 'dark' || (!cur && sysDark);
    const next    = isDark ? 'light' : 'dark';
    document.documentElement.setAttribute('data-theme', next);
    localStorage.setItem('mlj-theme', next);
    this._updateThemeIcon();
  },

  _updateThemeIcon() {
    const btn     = document.getElementById('theme-toggle');
    if (!btn) return;
    const cur     = document.documentElement.getAttribute('data-theme');
    const sysDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
    const isDark  = cur === 'dark' || (!cur && sysDark);
    btn.textContent = isDark ? '☀' : '☾';
  },

  // ---------- NAVIGATION ----------
  state: { currentPage: 'dashboard' },

  navigate(page) {
    this.state.currentPage = page;
    Router.render();
    this._updateSidebarBadges();
    document.querySelector('.mlj-sidebar')?.classList.remove('open');
    window.scrollTo({ top: 0, behavior: 'smooth' });
  },

  _updateSidebarBadges() {
    Object.keys(this.langs).forEach(l => {
      const el = document.getElementById('badge-' + l);
      if (!el) return;
      const s = this.getLangStats(l);
      el.textContent = `${s.done}/${s.total}`;
    });
    // Update nav active states
    document.querySelectorAll('.nav-item').forEach(el => {
      el.classList.toggle('active', el.dataset.page === this.state.currentPage);
    });
  },

  _updateTopbar() {
    const s  = this.getStats();
    const el = document.getElementById('topbar-stat');
    if (el) el.textContent = `${s.done}/${s.total} topics · ${s.pct}%`;
  },

  // ---------- INIT ----------
  async init() {
    this.initTheme();

    // Theme toggle
    document.getElementById('theme-toggle')
      ?.addEventListener('click', () => this.toggleTheme());

    // Mobile menu
    const mobileBtn = document.getElementById('mobile-menu');
    const sidebar   = document.querySelector('.mlj-sidebar');
    mobileBtn?.addEventListener('click', () => sidebar?.classList.toggle('open'));
    const updateMobile = () => {
      if (mobileBtn) mobileBtn.style.display = window.innerWidth <= 900 ? 'flex' : 'none';
    };
    updateMobile();
    window.addEventListener('resize', updateMobile);

    // Sidebar date
    const dateEl = document.getElementById('sidebar-date');
    if (dateEl) dateEl.textContent = new Date().toLocaleDateString('en-GB',
      { day:'numeric', month:'short', year:'numeric' });

    // Load JSON data
    await this.loadAll();

    // Initial render
    Router.render();
    this._updateSidebarBadges();
    this._updateTopbar();
  }
};
