package com.example.crs

import android.graphics.Outline
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class ConvexPathVariantFragment : Fragment(R.layout.fragment_convex_path_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val elevation = resources.getDimensionPixelSize(R.dimen.elevation)

        val outlineProviderConvexPath = view.findViewById<FrameLayout>(R.id.outlineProviderConvexPath)
        outlineProviderConvexPath.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                val path = Path()
                val width = view!!.width
                val height = view.height
                val radii = floatArrayOf(
                    width.toFloat() * 0.25f, height.toFloat() * 0.25f, // top-left
                    0f, 0f, // top-right
                    width.toFloat() * 0.5f, height.toFloat() * 0.5f, // bottom-right
                    0f, 0f // bottom-left
                )
                path.addRoundRect(0f, 0f, width.toFloat(), height.toFloat(), radii, Path.Direction.CW)
                outline?.setConvexPath(path)
            }
        }
        outlineProviderConvexPath.clipToOutline = true


        val outlineProviderOval = view.findViewById<FrameLayout>(R.id.outlineProviderOval)
        outlineProviderOval.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setOval(elevation, elevation, view!!.width - elevation, view.height - elevation)
            }
        }
        outlineProviderOval.clipToOutline = true
    }
}