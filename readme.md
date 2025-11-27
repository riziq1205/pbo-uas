🍽️ Sistem Manajemen Restoran (Final Project PBO)

Aplikasi desktop berbasis Java Swing untuk mengelola operasional restoran, mulai dari pemesanan pelanggan, manajemen menu admin, hingga kasir. Proyek ini dibangun dengan konsep Object-Oriented Programming (OOP) dan pola desain DAO (Data Access Object).

📋 Daftar Isi

Tech Stack

Cara Install & Menjalankan

Struktur Project

Fitur & Halaman Aplikasi

Skema Database

🛠 Tech Stack

Bahasa: Java (JDK 17+)

GUI: Java Swing (JFrame)

Database: MySQL (via XAMPP)

Library: MySQL Connector J (mysql-connector-java.jar)

Konsep: OOP (Encapsulation, Inheritance), MVC Pattern (Simplified)

🚀 Cara Install & Menjalankan

1. Persiapan Database

Pastikan XAMPP sudah terinstal dan jalankan module MySQL.

Buka phpMyAdmin atau MySQL Workbench.

Buat database baru dengan nama: db_restoran_final.

Import atau jalankan script SQL yang ada di dokumentasi (atau minta ke Lead Developer).

Default Admin: username: admin, password: admin123

2. Setup Java Project (IntelliJ / NetBeans)

Buka project ini di IDE.

Tambahkan Library MySQL JDBC Driver ke dalam Libraries / Dependencies project.

Pastikan struktur folder src sudah benar.

3. Menjalankan Aplikasi

Buka file Main.java.

Klik Run.

Aplikasi akan otomatis mengecek koneksi database sebelum membuka halaman Login.

📂 Struktur Project

Saat ini proyek menggunakan struktur flat package (semua di src) untuk kemudahan pengembangan awal.

Nama File

Tipe

Deskripsi

Main.java

Entry Point

File utama untuk run aplikasi. Mengecek koneksi DB & load tema UI.

DatabaseConnection.java

Config

Mengatur koneksi JDBC ke MySQL (DriverManager).

LoginForm.java

View

Halaman login untuk Admin & Kasir.

AdminMainFrame.java

View

Dashboard utama untuk Admin.

User.java

Model

Representasi (POJO) dari tabel users.

UserDAO.java

Controller/DAO

Menangani logika login dan query ke tabel users.

📱 Fitur & Halaman Aplikasi

Berikut adalah pembagian fitur berdasarkan role pengguna:

1. 🔐 Autentikasi (Sudah Ada)

Login Form: Memvalidasi username/password.

Auto Redirect: Sistem otomatis mendeteksi role (admin atau kasir) dan mengarahkan ke dashboard yang sesuai.

2. 👨‍💼 Admin Side (Sedang Dikembangkan)

Halaman ini khusus untuk manajer restoran.

Dashboard Admin: Menu navigasi utama.

Manajemen Menu (CRUD): * Menambah makanan/minuman baru.

Edit harga dan stok.

Hapus menu yang tidak dijual.

Upload gambar menu (Optional).

Manajemen User: Menambah akun kasir baru.

Laporan Penjualan: Melihat rekap pendapatan harian/bulanan.

3. 🧑‍🍳 Cashier / Kitchen Side (To Do)

Halaman untuk operasional sehari-hari.

Dashboard Kasir: Melihat status meja (Available/Occupied).

Order List: Melihat pesanan masuk dari pelanggan.

Update Status: Mengubah status pesanan (Pending -> Cooking -> Served -> Paid).

Pembayaran: Mencetak struk (simulasi) dan menyelesaikan transaksi.

4. 🙋‍♂️ Customer Side (To Do)

Halaman Self-Service untuk pelanggan (Mode Kiosk).

Browse Menu: Melihat daftar makanan beserta foto dan harga.

Add to Cart: Menambah item ke keranjang.

Checkout: Memasukkan nomor meja dan konfirmasi pesanan.

🗄 Skema Database (Singkat)

users: Menyimpan akun login (Admin/Kasir).

customers: Data pelanggan (Nama, No HP).

categories: Kategori menu (Makanan, Minuman, Snack).

menu_items: Daftar produk yang dijual.

orders: Header transaksi (Siapa yang beli, total harga, tanggal).

order_details: Rincian item apa saja yang dibeli dalam satu struk.

restaurant_tables: Data nomor meja.

Catatan untuk Tim:

Selalu gunakan DAO untuk akses database, jangan menulis query SQL di dalam JFrame.

Pastikan nama variabel konsisten (camelCase).

Sebelum commit/push code, pastikan tidak ada error di Main.java.