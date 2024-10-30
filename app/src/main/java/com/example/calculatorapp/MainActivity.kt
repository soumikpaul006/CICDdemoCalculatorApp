package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(getApplication(), "5f9affd6-76b5-465a-b745-5726003b4bd4", Analytics::class.java, Crashes::class.java);


        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)
        val addButton = findViewById<Button>(R.id.addButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        addButton.setOnClickListener {
            val number1 = firstNumber.text.toString().toDoubleOrNull()
            val number2 = secondNumber.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null) {
                val result = number1 + number2
                resultText.text = "Result: $result"
            } else {
                resultText.text = "Please enter valid numbers"
            }
        }
    }
}