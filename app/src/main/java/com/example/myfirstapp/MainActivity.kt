package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textFild)
        val okButton = findViewById<View>(R.id.okButton)
        val cancelButton = findViewById<View>(R.id.canselButton)
        okButton.setOnClickListener { textView.text = """Push "ok" button""" }
        cancelButton.setOnClickListener { textView.text = """Push "cancel" button""" }
    }


}
