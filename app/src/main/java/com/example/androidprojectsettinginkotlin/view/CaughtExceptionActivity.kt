package com.example.androidprojectsettinginkotlin.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.view.dialog.ExceptionDialog
import com.example.androidprojectsettinginkotlin.view.loading.LoadingActivity
import com.example.androidprojectsettinginkotlin.view.splash.SplashActivity
import kotlin.system.exitProcess

class CaughtExceptionActivity : BaseActivity() {
    private lateinit var exceptionDialog: ExceptionDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exceptionDialog = ExceptionDialog(this) {
            val intent = Intent(this, LoadingActivity::class.java)
            startActivity(intent)
            exitProcess(0)
        }
        if (exceptionDialog.isShowing) exceptionDialog.dismiss()
        exceptionDialog.show()

        exceptionDialog.setErrorMessage(intent.extras?.getString("errorMessage"))
    }
}