package com.example.crs

import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.LinearLayout

class OutlineImageVariantFragment : Fragment(R.layout.fragment_outline_image_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val elevation = resources.getDimensionPixelSize(R.dimen.elevation) * 2

        val ovalShadowView = view.findViewById<LinearLayout>(R.id.ovalShadowView)
        ovalShadowView.background = ColorDrawable(Color.WHITE)
        ovalShadowView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setOval(elevation, elevation, view!!.width - elevation, view.height - elevation)
            }
        }
        ovalShadowView.clipToOutline = true

        val ovalView = view.findViewById<LinearLayout>(R.id.ovalView)
        ovalView.background = ColorDrawable(Color.WHITE)
        ovalView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setOval(elevation, elevation, view!!.width - elevation, view.height - elevation)
            }
        }
        ovalView.clipToOutline = true

        val roundRectShadowView = view.findViewById<LinearLayout>(R.id.roundRectShadowView)
        roundRectShadowView.background = ColorDrawable(Color.WHITE)
        roundRectShadowView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(elevation, elevation, view!!.width - elevation, view.height - elevation, elevation.toFloat())
            }
        }
        roundRectShadowView.clipToOutline = true

        val roundRectView = view.findViewById<LinearLayout>(R.id.roundRectView)
        roundRectView.background = ColorDrawable(Color.WHITE)
        roundRectView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(elevation, elevation, view!!.width - elevation, view.height - elevation, elevation.toFloat())
            }
        }
        roundRectView.clipToOutline = true
    }
}