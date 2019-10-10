package com.example.crs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.back).setOnClickListener { back() }
        findViewById<Button>(R.id.next).setOnClickListener { next() }

        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        navHost.addOnDestinationChangedListener { _, _, _ ->
            findViewById<Button>(R.id.next).visibility = if (navHost.currentDestination?.id == R.id.shape) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }
    }

    private fun next() {
        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        when (navHost.currentDestination?.id ?: 0) {
            R.id.material -> navHost.navigate(MaterialVariantFragmentDirections.actionMaterialToImage())
            R.id.image -> navHost.navigate(OutlineImageVariantFragmentDirections.actionImageToWidget())
            R.id.widget -> navHost.navigate(OutlineWidgetVariantFragmentDirections.actionWidgetToShape())
            else -> { /* nop */ }
        }
    }

    private fun back() {
        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        if (navHost.popBackStack().not()) {
            finish()
        }
    }
}