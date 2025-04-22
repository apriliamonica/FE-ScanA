package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import com.example.handscanattendance.R
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ScanActivity : AppCompatActivity() {

    // Views
    private lateinit var spinnerMataKuliah: Spinner
    private lateinit var btnMulaiScan: Button
    private lateinit var cameraPreview: ConstraintLayout
    private lateinit var scanButton: Button
    private lateinit var previewView: androidx.camera.view.PreviewView

    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var cameraExecutor: ExecutorService

    // List of Mata Kuliah (Just an example)
    private val mataKuliahList = listOf("Mata Kuliah 1", "Mata Kuliah 2", "Mata Kuliah 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        // Initialize views
        spinnerMataKuliah = findViewById(R.id.spinnerMataKuliah)
        btnMulaiScan = findViewById(R.id.btnMulaiScan)
        cameraPreview = findViewById(R.id.cameraPreview)
        scanButton = findViewById(R.id.scanButton)
        previewView = findViewById(R.id.cameraPreview)

        // Set up Mata Kuliah Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mataKuliahList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMataKuliah.adapter = adapter

        // Listen to Mata Kuliah selection change
        spinnerMataKuliah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                btnMulaiScan.isEnabled = position != AdapterView.INVALID_POSITION
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                btnMulaiScan.isEnabled = false
            }
        }

        // Handle "Mulai Scan" button click
        btnMulaiScan.setOnClickListener {
            // Hide the spinner and button
            spinnerMataKuliah.visibility = View.GONE
            btnMulaiScan.visibility = View.GONE

            // Show camera preview and scan button
            cameraPreview.visibility = View.VISIBLE
            scanButton.visibility = View.VISIBLE

            startCamera() // Start CameraX
        }

        // Handle scan button click
        scanButton.setOnClickListener {
            // Your scan logic goes here (use CNN model for hand detection)
            Toast.makeText(this, "Scan Started", Toast.LENGTH_SHORT).show()
        }

        // CameraX Executor
        cameraExecutor = Executors.newSingleThreadExecutor()
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
    }

    private fun startCamera() {
        // Bind the camera lifecycle to this activity
        cameraProviderFuture.addListener(Runnable {
            // CameraProvider
            val cameraProvider = cameraProviderFuture.get()

            // Preview use case
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(previewView.surfaceProvider)

            // Select the back camera
            val cameraSelector = CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build()

            // Bind use cases to the camera
            cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview)
        }, cameraExecutor)
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}
