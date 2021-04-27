package com.sun.excovid19.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.excovid19.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.SplashTheme)
        setContentView(R.layout.activity_main)
    }
}
