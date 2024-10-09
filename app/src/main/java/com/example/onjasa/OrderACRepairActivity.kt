package com.example.onjasa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderACRepairActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_acrepair)

        // Menerima data dari HomeActivity
        val serviceType = intent.getStringExtra("service_type")

        // Menyesuaikan header dan elemen lain berdasarkan data yang diterima
        val serviceTitleTextView: TextView = findViewById(R.id.textView5) // Header textView
        serviceTitleTextView.text = serviceType ?: "Service"  // Jika null, tampilkan "Service" sebagai default

        val serviceImageView: ImageView = findViewById(R.id.imageView5) // Gambar header
        when (serviceType) {
            "AC Repair" -> serviceImageView.setImageResource(R.drawable.maintenance_tools) // Gambar AC Repair
            "AC Installation" -> serviceImageView.setImageResource(R.drawable.easy_installation) // Gambar AC Installation
            "AC Maintenance" -> serviceImageView.setImageResource(R.drawable.ac) // Gambar AC Maintenance
            "AC Wash" -> serviceImageView.setImageResource(R.drawable.spray) // Gambar AC Wash
            else -> serviceImageView.setImageResource(R.drawable.order_processing) // Gambar default jika tidak ada
        }

        // Back button handling
        val btnBack: ImageView = findViewById(R.id.imageViewBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@OrderACRepairActivity, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
}
