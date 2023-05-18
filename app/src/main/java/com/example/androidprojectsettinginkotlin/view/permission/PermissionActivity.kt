package com.example.androidprojectsettinginkotlin.view.permission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivityPermissionBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
import com.example.androidprojectsettinginkotlin.view.loading.LoadingActivity
import com.example.androidprojectsettinginkotlin.view.splash.SplashActivity
import com.example.androidprojectsettinginkotlin.viewmodel.PermissionViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PermissionActivity : BaseDaggerAppCompatActivity<ActivityPermissionBinding>() {

    override val layout
        get() = R.layout.activity_permission

    @Inject
    lateinit var viewModel: PermissionViewModel

    private val REQUEST_PERMISSIONS = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpObserve()
        checkPermission()
    }

    private fun setUpBinding() {
        with(binding) {
            binding.viewModel = viewModel
        }
    }

    private fun setUpObserve() {
        viewModel.errorMessage.observe(this, Observer {
            val intent = Intent(this, CaughtExceptionActivity::class.java)
            intent.putExtra("errorMessage", it)
            finishAffinity()
            startActivity(intent)
        })

        viewModel.isNext.observe(this, Observer {
            val intent = Intent(this, LoadingActivity::class.java)
            finishAffinity()
            startActivity(intent)
        })
    }

    private fun checkPermission() {
        val permission = getPermissionList()

        if (permissionDeniedCount(permission) == 0) {
            viewModel.goNext()
        }
    }

    private fun getPermissionList(): Map<String, String> {
        val permission = mutableMapOf<String, String>()
        permission["camera"] = Manifest.permission.CAMERA
        permission["storageRead"] = Manifest.permission.READ_EXTERNAL_STORAGE
        permission["storageWrite"] =  Manifest.permission.WRITE_EXTERNAL_STORAGE

        return permission
    }

    private fun permissionDeniedCount(permission: Map<String, String>): Int {
        return permission.count { ContextCompat.checkSelfPermission(this, it.value)  == PackageManager.PERMISSION_DENIED }
    }
}