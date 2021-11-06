package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btnCreate).setOnClickListener(this)
        findViewById<View>(R.id.btnClear).setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        val wrapParam = LinearLayout.LayoutParams.WRAP_CONTENT
        var lParam = LinearLayout.LayoutParams(wrapParam, wrapParam)
        lParam.gravity = Gravity.LEFT
        when (v?.id) {
            R.id.btnCreate -> {
                lParam.gravity = when (findViewById<RadioGroup>(R.id.rgGravity).checkedRadioButtonId) {
                    R.id.rbRight -> Gravity.RIGHT
                    R.id.rbCenter -> Gravity.CENTER_HORIZONTAL
                    R.id.rbLeft -> Gravity.LEFT
                    else -> Gravity.LEFT
                }
                var newButton = Button(this)
                newButton.text = findViewById<TextView>(R.id.etName).text.toString()
                findViewById<LinearLayout>(R.id.llMain).addView(newButton,lParam)
            }
            R.id.btnClear -> {
                findViewById<LinearLayout>(R.id.llMain).removeAllViews()
                Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show()
            }
        }
    }
}