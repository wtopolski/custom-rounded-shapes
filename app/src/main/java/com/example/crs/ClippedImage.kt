package com.example.crs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import android.widget.ImageView

class ClippedImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private val path: Path by lazy {
        val radii = floatArrayOf(
            width.toFloat() * 0.7f, height.toFloat() * 0.7f, // top-left
            0f, 0f, // top-right
            width.toFloat() * 0.6f, height.toFloat() * 0.6f, // bottom-right
            0f, 0f // bottom-left
        )
        Path().apply { addRoundRect(0f, 0f, width.toFloat(), height.toFloat(), radii, Path.Direction.CW) }
    }

    override fun draw(canvas: Canvas?) {
        canvas?.clipPath(path)
        super.draw(canvas)
    }
}