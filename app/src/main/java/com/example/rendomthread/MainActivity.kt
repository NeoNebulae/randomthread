package com.example.rendomthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var tvRandomNumber: TextView
    private lateinit var btnGenerateNumber: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRandomNumber = findViewById(R.id.tvRandomNumber)
        btnGenerateNumber = findViewById(R.id.btnGenerateNumber)

        btnGenerateNumber.setOnClickListener {
            generateRandomNumberWithDelay()
        }
    }

    private fun generateRandomNumberWithDelay() {
        thread {
            // Generate a random number between 1 and 10
            val randomNumber = Random().nextInt(10) + 1

            // Sleep for 3 seconds to simulate delay
            Thread.sleep(3000)

            // Update the UI with the generated random number
            runOnUiThread {
                tvRandomNumber.text = "$randomNumber"
            }
        }
    }
}
