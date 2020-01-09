package com.example.crs

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.shape.MaterialShapeDrawable

class DarkVariantFragment : Fragment(R.layout.fragment_dark_variant) {

    lateinit var cardView: FrameLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardView = view.findViewById(R.id.cardView4)
    }

    override fun onStart() {
        super.onStart()
        val animator = ValueAnimator.ofInt(0, resources.getDimensionPixelOffset(R.dimen.elevation16))
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            cardView.background = MaterialShapeDrawable.createWithElevationOverlay(cardView.context, value.toFloat())
            cardView.elevation = value.toFloat()
        }
        animator.duration = 5000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.start()
    }
}