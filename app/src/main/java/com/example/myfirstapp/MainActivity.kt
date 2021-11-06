package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val textView: TextView = findViewById<TextView>(R.id.textFild)
    private val okButton: View = findViewById<View>(R.id.okButton)
    private val cancelButton: View = findViewById<View>(R.id.canselButton)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        okButton.setOnClickListener (this)
        cancelButton.setOnClickListener (this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.okButton -> textView.text = """Push "Ok" button"""
            R.id.canselButton -> textView.text = """Push "cancel" button"""
        }

    }


}
