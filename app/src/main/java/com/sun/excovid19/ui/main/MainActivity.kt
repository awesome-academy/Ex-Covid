package com.sun.excovid19.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sun.excovid19.R
import com.sun.excovid19.utils.NetworkUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isConnection = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Covid19Theme)
        isConnection = NetworkUtil.isConnection(this)
        if (!isConnection) {
            showDialogCheckInternet().show()
            return
        }
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentMainNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun showDialogCheckInternet(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.title_internet))
            .setMessage(getString(R.string.text_warning))
            .setPositiveButton(getString(R.string.titke_ok)) { _, _ ->
                startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
                finish()
            }
            .setNegativeButton(getString(R.string.title_cancel)) { _, _ ->
                finish()
            }
        return builder.create()
    }
}
