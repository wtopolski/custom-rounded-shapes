package com.example.crs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    // TODO
    // 2) poprawic material cien przed
    // 3) poprawic widget
    // 4) kolorowe cienie
    // 5) smok

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.back).setOnClickListener { back() }
        findViewById<Button>(R.id.next).setOnClickListener { next() }
    }

    private fun next() {
        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        when (navHost.currentDestination?.id ?: 0) {
            R.id.material -> navHost.navigate(MaterialVariantFragmentDirections.actionMaterialToImage())
            R.id.image -> navHost.navigate(OutlineImageVariantFragmentDirections.actionImageToWidget())
            else -> { /* nop */ }
        }
    }

    private fun back() {
        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        when (navHost.currentDestination?.id ?: 0) {
            R.id.image -> navHost.navigate(OutlineImageVariantFragmentDirections.actionImageToMaterial())
            R.id.widget -> navHost.navigate(OutlineWidgetVariantFragmentDirections.actionWidgetToImage())
            else -> { /* nop */ }
        }
    }
}