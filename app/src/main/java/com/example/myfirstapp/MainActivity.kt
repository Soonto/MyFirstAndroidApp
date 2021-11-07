package com.example.myfirstapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<SeekBar>(R.id.sbWeight).setOnSeekBarChangeListener(this)
    }


    @SuppressLint("CutPasteId")
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        var leftButton = findViewById<View>(R.id.btn1) as Button
        var rightButton = findViewById<View>(R.id.btn2) as Button
        var paramLeftButton = leftButton.layoutParams as LinearLayout.LayoutParams
        var paramRightButton = rightButton.layoutParams as LinearLayout.LayoutParams
        paramLeftButton.weight = progress.toFloat()
        paramRightButton.also { it.weight = if (seekBar != null) (seekBar.max - progress).toFloat() else 0F }
        leftButton.also { it.requestLayout() }.text = paramLeftButton.weight.toInt().toString()
        rightButton.also { it.requestLayout() }.text = paramRightButton.weight.toInt().toString()
        //Toast.makeText(this, "${paramLeftButton.weight} , ${paramRightButton.weight}", Toast.LENGTH_SHORT).show()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
}