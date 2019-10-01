package com.example.crs

import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.LinearLayout
import android.widget.Toast

class OutlineWidgetVariantFragment : Fragment(R.layout.fragment_outline_widget_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radius = resources.getDimensionPixelSize(R.dimen.radius)
        val outlinedView = view.findViewById<LinearLayout>(R.id.outlinedView)
        outlinedView.background = ColorDrawable(Color.WHITE)
        outlinedView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width+radius, view.height+radius, radius.toFloat())
            }
        }
        outlinedView.setClipToOutline(true)

        val clickableView = view.findViewById<LinearLayout>(R.id.clickableView)
        clickableView.setOnClickListener { Toast.makeText(requireContext(), "ala", Toast.LENGTH_SHORT).show() }
    }
}