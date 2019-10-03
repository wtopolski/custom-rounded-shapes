package com.example.crs

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.TriangleEdgeTreatment

class MaterialVariantFragment : Fragment(R.layout.fragment_material_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radius = resources.getDimensionPixelSize(R.dimen.radius)
        val elevation = resources.getDimensionPixelSize(R.dimen.elevation)
        val mainView = view.findViewById<LinearLayout>(R.id.mainView)
        val backgroundView = view.findViewById<LinearLayout>(R.id.backgroundView)

        val model = ShapeAppearanceModel()
            .toBuilder()
            .setAllCorners(RoundedCornerTreatment(radius.toFloat()))
            .setAllEdges(TriangleEdgeTreatment(radius.toFloat(), true))
            .build()

        val backgroundDrawable = MaterialShapeDrawable().apply {
            shapeAppearanceModel = model
            fillColor = ColorStateList.valueOf(Color.WHITE)
            setElevation(elevation.toFloat() / 2)
        }

        backgroundView.background = backgroundDrawable
    }
}