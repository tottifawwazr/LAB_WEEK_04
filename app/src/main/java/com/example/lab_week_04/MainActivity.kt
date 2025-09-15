package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.navigateUp   // penting untuk navigateUp(appBarConfiguration)

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // ambil NavHostFragment dari content_main.xml
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // konfigurasi top-level destinations (Drawer + Bottom Nav)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment,
                R.id.favoritesFragment,
                R.id.cafeFragment
            ),
            findViewById(R.id.drawer_layout)
        )

        // sinkronkan toolbar dengan NavController
        setupActionBarWithNavController(navController, appBarConfiguration)

        // hubungkan Navigation Drawer dengan NavController
        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)

        // hubungkan Bottom Navigation dengan NavController
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            .setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
