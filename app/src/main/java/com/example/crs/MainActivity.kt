package com.example.crs

import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val root = findViewById<LinearLayout>(R.id.root)
//        root.setOnClickListener { Toast.makeText(this, "ala", Toast.LENGTH_SHORT).show() }

        val radius = resources.getDimensionPixelSize(R.dimen.radius)
        val body = findViewById<LinearLayout>(R.id.body)
        body.background = ColorDrawable(Color.WHITE)
        body.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width+radius, view.height+radius, radius.toFloat())
            }
        }
        body.setClipToOutline(true)
    }
}