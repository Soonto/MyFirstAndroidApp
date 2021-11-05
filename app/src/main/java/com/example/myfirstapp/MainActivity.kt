package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun send_Message(view : View){
        val message = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
        startActivity(Intent(this, DisplayMessageActiviti::class.java).apply{putExtra(EXTRA_MESSAGE, message)})
    }
}
