package com.example.madt_2_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButtonClickListener()
    }

    private fun setupButtonClickListener() {
        val editText = findViewById<EditText>(R.id.editText)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val textView = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.button).setOnClickListener {
            val text = editText.text.toString()
            if (text.isEmpty()) {
                showToastMessage("Please enter some text")
                return@setOnClickListener
            }

            val result = calculateResult(text, spinner.selectedItem.toString())
            textView.text = result.toString()
        }
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    private fun calculateResult(text: String, selectedItem: String): Int {
        return if ("Words" == selectedItem) {
            TextCounter.countWords(text)
        } else {
            TextCounter.countCharacters(text)
        }
    }
}