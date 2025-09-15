package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.navigateUp   // <-- PENTING: extension utk navigateUp(appBarConfiguration)

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar dari app_bar_main.xml
        setSupportActionBar(findViewById(R.id.toolbar))

        // Dapatkan NavController dari NavHost di content_main.xml
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Top-level destinations yang ada di drawer
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.listFragment, R.id.favoritesFragment),
            findViewById(R.id.drawer_layout)
        )

        // Sinkronkan toolbar (judul, hamburger/back)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Hubungkan NavigationView dengan NavController
        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        // butuh import androidx.navigation.ui.navigateUp
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        // Alternatif tanpa extension:
        // return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}
