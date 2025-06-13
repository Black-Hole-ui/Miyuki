# 📱 Miyuki – Weather & Battery Temperature App

**Miyuki** adalah aplikasi mobile berbasis Android (Jetpack Compose + Kotlin + Firebase) yang memberikan fitur praktis:

- **Login** via Google atau Email & Password melalui Firebase Authentication  
- **Halaman Home**:
  - Menampilkan daftar data cuaca hasil pencarian
  - Swipe lama pada item lalu klik "Hapus" untuk menghapus data
- **Halaman Konten**:
  - Input nama kota → klik **Cari** → fetch API dari OpenWeatherMap → hasil disimpan & ditampilkan di Home
- **Halaman Suhu Baterai**:
  - Menampilkan suhu baterai real-time
  - Tombol _“Cek Apakah Aman”_ memicu notifikasi status aman/tidak baterai
- **Halaman Setting**:
  - Toggle **Mode Gelap/Terang**
  - Pilihan bahasa (future scope)
  - Menu **Informasi**, **Rate Up**, dan **Logout**

---

## 📸 Tangkapan Layar Aplikasi

### Tampilan Login
![Login Screen](screenshots/Gambar WhatsApp 2025-06-13 pukul 22.44.39_300289a4.png)

### Home – Daftar Cuaca
![Home Screen](screenshots/home.png)

### Konten – Cari Cuaca
![Search Screen](screenshots/search.png)

### Home Setelah Pencarian
![Weather Result](screenshots/weather_saved.png)

### Suhu Baterai – Normal
![Battery Safe](screenshots/battery_safe.png)

### Suhu Baterai – Notifikasi
![Battery Notification](screenshots/battery_notif.png)

### Setting – Mode Terang
![Settings Light](screenshots/setting_light.png)

### Setting – Mode Gelap
![Settings Dark](screenshots/setting_dark.png)

### Mode Gelap – Login
![Login Dark](screenshots/login_dark.png)

---

## 🚀 Fitur

1. **Autentikasi:**
   - Login menggunakan **Google Sign‑In** atau **Email/Password** via Firebase  
2. **Cuaca & Penyimpanan:**
   - Cari cuaca suatu kota menggunakan OpenWeatherMap API
   - Tampilkan hasil di halaman **Home**
   - Simpan data hasil pencarian ke storage lokal (Room atau Firebase Realtime)
   - Hapus data dengan swipe & tekan lama  
3. **Suhu Baterai:**
   - Ambil suhu baterai perangkat secara real-time
   - Tombol “Cek Apakah Aman” memicu notifikasi yang memberi tahu apakah suhu baterai berada dalam range aman  
4. **Customize Tampilan:**
   - Switch theme: Light ↔ Dark
   - Pilihan bahasa (UI siap untuk localization, tinggal tambahkan file `.xml` sesuai bahasa)
   - Menu tambahan: **Informasi**, **Rate Up**, **Logout**  
5. **Logout:**
   - Kembali ke halaman login dan bersihkan sesi Firebase

---

