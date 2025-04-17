class RegisterActivity : AppCompatActivity() {

    private lateinit var etNIM: EditText
    private lateinit var etNama: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var spinnerKelas: Spinner
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnUploadRightPalm: Button
    private lateinit var btnUploadLeftPalm: Button
    private lateinit var btnRegister: Button
    private lateinit var tvLoginRedirect: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Menginisialisasi komponen UI
        etNIM = findViewById(R.id.etNIM)
        etNama = findViewById(R.id.etNama)
        etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)
        spinnerKelas = findViewById(R.id.spinnerKelas)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnUploadRightPalm = findViewById(R.id.btnUploadRightPalm)
        btnUploadLeftPalm = findViewById(R.id.btnUploadLeftPalm)
        btnRegister = findViewById(R.id.btnRegister)
        tvLoginRedirect = findViewById(R.id.tvLoginRedirect)

        // Setup Spinner untuk kelas
        val kelasOptions = arrayOf("Kelas A", "Kelas B", "Kelas C") // Ganti dengan data kelas yang sesuai
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kelasOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerKelas.adapter = adapter

        // Listener untuk tombol Daftar
        btnRegister.setOnClickListener {
            val nim = etNIM.text.toString()
            val nama = etNama.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()
            val kelas = spinnerKelas.selectedItem.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Validasi input
            if (nim.isEmpty() || nama.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Kata sandi dan konfirmasi tidak cocok!", Toast.LENGTH_SHORT).show()
            } else {
                // Kirim data ke server (misalnya menggunakan Retrofit)
                registerUser(nim, nama, phone, email, kelas, password)
            }
        }

        // Listener untuk navigasi ke halaman login
        tvLoginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Listener untuk upload telapak tangan kanan
        btnUploadRightPalm.setOnClickListener {
            // Buka galeri atau kamera untuk mengunggah gambar telapak tangan kanan
            openGalleryOrCamera(REQUEST_CODE_RIGHT_PALM)
        }

        // Listener untuk upload telapak tangan kiri
        btnUploadLeftPalm.setOnClickListener {
            // Buka galeri atau kamera untuk mengunggah gambar telapak tangan kiri
            openGalleryOrCamera(REQUEST_CODE_LEFT_PALM)
        }
    }

    private fun openGalleryOrCamera(requestCode: Int) {
        // Implementasikan Intent untuk membuka galeri atau kamera
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, requestCode)
    }

    private fun registerUser(nim: String, nama: String, phone: String, email: String, kelas: String, password: String) {
        // Panggil Retrofit untuk mendaftar pengguna ke server
        // Pastikan Anda menambahkan kode Retrofit untuk mengirim data ke backend Anda
    }

    companion object {
        const val REQUEST_CODE_RIGHT_PALM = 1
        const val REQUEST_CODE_LEFT_PALM = 2
    }
}
