
package com.google.samples.apps.sunflower

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.samples.apps.sunflower.databinding.ActivityGardenBinding

class GardenActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityGardenBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_garden)
        drawerLayout = binding.drawerLayout

        val navController = Navigation.findNavController(this, R.id.garden_nav_fragment)

        // Set up ActionBar
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // Set up navigation menu
        binding.navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(drawerLayout,
                Navigation.findNavController(this, R.id.garden_nav_fragment))
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}