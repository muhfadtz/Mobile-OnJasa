// ACRepairActivity.kt
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

class ACRepairActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_acrepair)

        // Retrieve the header title from the Intent
        val headerTitle = intent.getStringExtra("header_title")

        // Set the header title to the TextView with id: headertitle
        val headerTitleTextView: TextView = findViewById(R.id.headertitle)
        headerTitleTextView.text = headerTitle

        // Retrieve the header image resource ID from the Intent
        val headerImageResId = intent.getIntExtra("header_image", R.drawable.order_processing) // Default image if none is passed

        // Set the header image to the ImageView with id: imgheader
        val headerImageView: ImageView = findViewById(R.id.imgheader)
        headerImageView.setImageResource(headerImageResId)

        // Window insets handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btncancelorder: Button = findViewById(R.id.btncancelorder)
        btncancelorder.setOnClickListener {
            val intent = Intent(this@ACRepairActivity, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
}
