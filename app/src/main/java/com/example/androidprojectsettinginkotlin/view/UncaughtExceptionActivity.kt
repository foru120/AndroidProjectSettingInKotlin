package com.example.androidprojectsettinginkotlin.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.androidprojectsettinginkotlin.view.dialog.ExceptionDialog
import com.example.androidprojectsettinginkotlin.view.splash.SplashActivity
import kotlin.system.exitProcess

class UncaughtExceptionActivity : AppCompatActivity() {

    private val exceptionDialog: ExceptionDialog = ExceptionDialog(this)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        exceptionDialog.btnListener = View.OnClickListener {
            ActivityCompat.finishAffinity(this@UncaughtExceptionActivity)
            val intent = Intent(this@UncaughtExceptionActivity, SplashActivity::class.java)
            startActivity(intent)
            exitProcess(0)
        }
        exceptionDialog.errorMessage = intent.extras?.getString("errorMessage")

        exceptionDialog.show()
    }

    override fun onBackPressed() {}
}