package com.example.handscanattendance.ui.admin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import com.example.handscanattendance.R
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ScanActivity : AppCompatActivity() {

    private lateinit var spinnerMataKuliah: Spinner
    private lateinit var btnMulaiScan: Button
    private lateinit var cameraPreviewLayout: ConstraintLayout
    private lateinit var scanButton: Button
    private lateinit var previewView: PreviewView

    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var cameraExecutor: ExecutorService

    private val mataKuliahList = listOf("Mata Kuliah 1", "Mata Kuliah 2", "Mata Kuliah 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        spinnerMataKuliah = findViewById(R.id.spinnerMataKuliah)
        btnMulaiScan = findViewById(R.id.btnMulaiScan)
        cameraPreviewLayout = findViewById(R.id.layoutScanKehadiran)
        scanButton = findViewById(R.id.scanButton)
        previewView = findViewById(R.id.cameraPreview)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mataKuliahList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMataKuliah.adapter = adapter

        spinnerMataKuliah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                btnMulaiScan.isEnabled = position != AdapterView.INVALID_POSITION
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                btnMulaiScan.isEnabled = false
            }
        }

        btnMulaiScan.setOnClickListener {
            spinnerMataKuliah.visibility = View.GONE
            btnMulaiScan.visibility = View.GONE
            previewView.visibility = View.VISIBLE
            scanButton.visibility = View.VISIBLE
            startCamera()
        }

        scanButton.setOnClickListener {
            Toast.makeText(this, "Scan Started", Toast.LENGTH_SHORT).show()
        }

        cameraExecutor = Executors.newSingleThreadExecutor()
        cameraProviderFuture = ProcessCameraProvider.getInstance(this)
    }

    private fun startCamera() {
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview)
            } catch (e: Exception) {
                Toast.makeText(this, "Gagal menampilkan kamera", Toast.LENGTH_SHORT).show()
            }
        }, cameraExecutor)
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}
