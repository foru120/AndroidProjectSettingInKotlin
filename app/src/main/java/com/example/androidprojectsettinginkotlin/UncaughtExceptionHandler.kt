package com.example.androidprojectsettinginkotlin

import android.content.Context
import android.content.Intent
import com.example.androidprojectsettinginkotlin.view.UncaughtExceptionActivity
import kotlin.system.exitProcess

class UncaughtExceptionHandler(val context: Context) : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        val crashIntent = Intent(context, UncaughtExceptionActivity::class.java)
        crashIntent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
            Intent.FLAG_ACTIVITY_CLEAR_TASK or
            Intent.FLAG_ACTIVITY_NEW_TASK
        )
        crashIntent.putExtra("errorMessage", throwable.toString())
        context.startActivity(crashIntent)

        android.os.Process.killProcess(android.os.Process.myPid())
        exitProcess(10)
    }
}