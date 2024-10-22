// OrderACRepairActivity.kt
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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot

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
        val imageResId: Int = when (serviceType) {
            "AC Repair" -> R.drawable.maintenance_tools // Gambar AC Repair
            "AC Installation" -> R.drawable.easy_installation // Gambar AC Installation
            "AC Maintenance" -> R.drawable.ac // Gambar AC Maintenance
            "AC Wash" -> R.drawable.spray // Gambar AC Wash
            else -> R.drawable.order_processing // Gambar default jika tidak ada
        }
        serviceImageView.setImageResource(imageResId)

        // Back button handling
        val btnBack: ImageView = findViewById(R.id.imageViewBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@OrderACRepairActivity, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        // Make Order button handling
        val btnMakeOrder: Button = findViewById(R.id.btnMakeOrder)
        btnMakeOrder.setOnClickListener {
            val intent = Intent(this@OrderACRepairActivity, ACRepairActivity::class.java)
            intent.putExtra("header_title", serviceTitleTextView.text.toString())  // Send the header text
            intent.putExtra("header_image", imageResId)  // Send the image resource ID
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    }
}
