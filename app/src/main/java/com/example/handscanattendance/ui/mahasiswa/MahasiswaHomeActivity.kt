//package com.example.handscanattendance.ui.mahasiswa
//
//import android.content.Intent
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.handscanattendance.R
//import com.example.handscanattendance.ui.auth.LoginActivity
//import com.example.handscanattendance.ui.mahasiswa.RiwayatKehadiranActivity
//
//
//class MahasiswaHomeActivity : AppCompatActivity() {
//
//    private lateinit var sharedPreferences: SharedPreferences
//    private val sharedPrefFile = "com.example.handscanattendance.PREFERENCE_FILE_KEY"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home_mahasiswa)
//
//        // Inisialisasi SharedPreferences
//        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE)
//
//        // Memastikan bahwa user sudah login, jika tidak maka redirect ke halaman login
//        if (!isUserLoggedIn()) {
//            redirectToLogin()
//        }
//
//        // Tombol Logout
//        logout_button.setOnClickListener {
//            // Logika untuk logout: menghapus session dan kembali ke halaman login
//            logoutUser()
//        }
//
//        // Tombol Riwayat Kehadiran
//        attendance_history_button.setOnClickListener {
//            // Arahkan ke Activity Riwayat Kehadiran
//            val intent = Intent(this, RiwayatKehadiranActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun isUserLoggedIn(): Boolean {
//        // Mengecek status login dari SharedPreferences
//        return sharedPreferences.getBoolean("IS_LOGGED_IN", false)
//    }
//
//    private fun redirectToLogin() {
//        // Jika pengguna belum login, arahkan ke halaman login
//        val intent = Intent(this, LoginActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity(intent)
//        finish()  // Menutup activity ini agar pengguna tidak bisa kembali ke halaman ini tanpa login lagi
//    }
//
//    private fun logoutUser() {
//        // Menghapus session pengguna dengan SharedPreferences
//        val editor = sharedPreferences.edit()
//        editor.putBoolean("IS_LOGGED_IN", false)
//        editor.apply()
//
//        // Memberi notifikasi logout berhasil
//        Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show()
//
//        // Pindahkan ke halaman login setelah logout
//        val intent = Intent(this, LoginActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
//        startActivity(intent)
//        finish()  // Menutup activity ini
//    }
//}
