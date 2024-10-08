package com.example.onjasa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMakeOrder = findViewById<Button>(R.id.btnMakeOrder)

        // Set listener ketika tombol ditekan
        btnMakeOrder.setOnClickListener {
            // Intent untuk pindah ke ACRepairActivity
            val intent = Intent(this, ACRepairActivity::class.java)
            startActivity(intent)
        }

        val btnBack: ImageView = findViewById(R.id.imageViewBack)

        btnBack.setOnClickListener {
            val intent = Intent(this@OrderACRepairActivity, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }


    }
}