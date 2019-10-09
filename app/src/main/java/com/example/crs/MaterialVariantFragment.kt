package com.example.crs

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.TriangleEdgeTreatment

class MaterialVariantFragment : Fragment(R.layout.fragment_material_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radius = resources.getDimensionPixelSize(R.dimen.radius)
        val elevation = resources.getDimensionPixelSize(R.dimen.elevation)
        val backgroundView = view.findViewById<LinearLayout>(R.id.backgroundView)

        val model = ShapeAppearanceModel()
            .toBuilder()
            .setAllCornerSizes(radius.toFloat())
            .setAllEdges(TriangleEdgeTreatment(radius.toFloat(), false))
            .setTopLeftCorner(CornerFamily.CUT, radius.toFloat() * 3)
            .setBottomRightCorner(CornerFamily.CUT, radius.toFloat() * 5)
            .setLeftEdge(TriangleEdgeTreatment(radius.toFloat() * 2, true))
            .build()

        backgroundView.background = MaterialShapeDrawable().apply {
            shapeAppearanceModel = model
            fillColor = ColorStateList.valueOf(Color.MAGENTA)
            setElevation(elevation.toFloat() * 5)
            setShadowColor(Color.GREEN)
        }
    }
}