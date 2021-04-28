package com.sun.excovid19.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sun.excovid19.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Covid19Theme)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentMainNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}
