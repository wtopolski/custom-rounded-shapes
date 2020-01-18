package com.example.crs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.back).setOnClickListener { back() }
        findViewById<Button>(R.id.next).setOnClickListener { next() }

        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        navHost.addOnDestinationChangedListener { _, _, _ ->

            val currentDestinationId = navHost.currentDestination?.id

            findViewById<Button>(R.id.next).visibility = if (currentDestinationId == R.id.dark) {
                View.GONE
            } else {
                View.VISIBLE
            }

            if (currentDestinationId == R.id.dark) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun next() {
        val navHost = findViewById<View>(R.id.nav_host_fragment).findNavController()
        when (navHost.currentDestination?.id ?: 0) {
            R.id.outlineProvider -> navHost.navigate(OutlineProviderVariantFragmentDirections.nextScreen())
            R.id.shadow -> navHost.navigate(ShadowVariantFragmentDirections.nextScreen())
            R.id.material -> navHost.navigate(MaterialVariantFragmentDirections.nextScreen())
            R.id.theme -> navHost.navigate(ThemeVariantFragmentDirections.nextScreen())
            R.id.light -> navHost.navigate(LightVariantFragmentDirections.nextScreen())
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