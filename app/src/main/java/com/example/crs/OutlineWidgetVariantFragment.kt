package com.example.crs

import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.FrameLayout

class OutlineWidgetVariantFragment : Fragment(R.layout.fragment_outline_widget_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radius = resources.getDimensionPixelSize(R.dimen.widget_radius)
        val outlinedView = view.findViewById<FrameLayout>(R.id.outlinedView)
        outlinedView.background = ColorDrawable(Color.WHITE)
        outlinedView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width + radius, view.height + radius, radius.toFloat())
            }
        }
        outlinedView.clipToOutline = true
    }
}