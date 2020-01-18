package com.example.crs

import android.graphics.Outline
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class OutlineProviderVariantFragment : Fragment(R.layout.fragment_outline_provider_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dp24 = resources.getDimensionPixelSize(R.dimen.dp24)
        val dp32 = resources.getDimensionPixelSize(R.dimen.dp32)

        // TODO: convext path z clipowaniem na canvasie własnego widoku jako dodatkowy przykład

        /**
         * Path::isConvex() returns the path's convexity, as defined by the content of the path.
         * A path is convex if it has a single contour, and only ever curves in a
         * single direction.
         */

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

        /**
         * Outline::canClip() returns whether the outline can be used to clip a View.
         * Currently, only Outlines that can be represented as a rectangle, circle,
         * or round rect support clipping.
         */

        val outlineProviderOval = view.findViewById<FrameLayout>(R.id.outlineProviderOval)
        outlineProviderOval.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setOval(0, 0, view!!.width, view.height)
            }
        }
        outlineProviderOval.clipToOutline = true


        val outlineProviderImage = view.findViewById<FrameLayout>(R.id.outlineProviderImage)
        outlineProviderImage.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width, view.height, dp24.toFloat())
            }
        }
        outlineProviderImage.clipToOutline = true

        val outlineProviderImageCornerRoundedFail = view.findViewById<FrameLayout>(R.id.outlineProviderImageCornerRoundedFail)
        outlineProviderImageCornerRoundedFail.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width + dp24, view.height + dp24, dp24.toFloat())
            }
        }
        outlineProviderImageCornerRoundedFail.clipToOutline = true

        val outlinedView = view.findViewById<FrameLayout>(R.id.outlineProviderImageCornerRoundedSuccessOutlinedView)
        outlinedView.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width + dp32, view.height + dp32, dp32.toFloat())
            }
        }
        outlinedView.clipToOutline = true
    }
}