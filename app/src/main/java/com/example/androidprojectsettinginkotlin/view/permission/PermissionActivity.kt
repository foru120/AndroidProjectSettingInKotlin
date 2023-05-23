package com.example.androidprojectsettinginkotlin.view.permission

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.constants.*
import com.example.androidprojectsettinginkotlin.databinding.ActivityPermissionBinding
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
import com.example.androidprojectsettinginkotlin.view.dialog.CustomDialog
import com.example.androidprojectsettinginkotlin.view.loading.LoadingActivity
import com.example.androidprojectsettinginkotlin.viewmodel.PermissionViewModel
import javax.inject.Inject
import kotlin.system.exitProcess

class PermissionActivity : BaseDaggerAppCompatActivity<ActivityPermissionBinding>() {

    override val layout
        get() = R.layout.activity_permission

    @Inject
    lateinit var viewModel: PermissionViewModel
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val REQUEST_PERMISSIONS = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpObserve()
        isAllGrantedPermissions()
    }

    private fun setUpBinding() {
        with(binding) {
            viewModel = this@PermissionActivity.viewModel
        }
    }

    private fun setUpObserve() {
        viewModel.errorMessage.observe(this, Observer {
            val intent = Intent(this, CaughtExceptionActivity::class.java)
            intent.putExtra("errorMessage", it)
            finishAffinity()
            startActivity(intent)
        })

        viewModel.isRequestPermission.observe(this, Observer {
            requestPermission()
        })

        viewModel.isNext.observe(this, Observer {
            val intent = Intent(this, LoadingActivity::class.java)
            finishAffinity()
            startActivity(intent)
        })
    }

    private fun isAllGrantedPermissions() {
        val permission = getPermissionList()

        if (permissionDeniedCount(permission) == 0) {
            goNext()
        }
    }

    private fun getPermissionList(): Map<String, String> {
        val permission = mutableMapOf<String, String>()
        permission["camera"] = Manifest.permission.CAMERA
        permission["storageRead"] = Manifest.permission.READ_EXTERNAL_STORAGE
        permission["storageWrite"] =  Manifest.permission.WRITE_EXTERNAL_STORAGE
        permission["bluetooth"] = Manifest.permission.BLUETOOTH
        permission["bluetoothAdmin"] = Manifest.permission.BLUETOOTH_ADMIN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permission["bluetoothConnect"] = Manifest.permission.BLUETOOTH_CONNECT
            permission["bluetoothAdvertise"] = Manifest.permission.BLUETOOTH_ADVERTISE
        }
        permission["phoneStateRead"] = Manifest.permission.READ_PHONE_STATE
        permission["smsRead"] = Manifest.permission.READ_SMS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            permission["phoneNumbersRead"] = Manifest.permission.READ_PHONE_NUMBERS
        }

        return permission
    }

    private fun permissionDeniedCount(permissionList: Map<String, String>): Int {
        return permissionList.count { ContextCompat.checkSelfPermission(this, it.value)  == PackageManager.PERMISSION_DENIED }
    }

    private fun requestPermission() {
        val permissionList: Map<String, String> = getPermissionList()

        requestPermissions(permissionList.values.toTypedArray(), REQUEST_PERMISSIONS)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        var isAllGranted: Boolean = true

        if (requestCode == REQUEST_PERMISSIONS) {
            for (grant in grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false
                    break
                }
            }

            if (isAllGranted) {
                goNext()
            } else {
                showPermissionDeniedDialog()
            }
        }
    }

    private fun goNext() {
        viewModel.goNext()
    }

    private fun getPermissionDenyCount(): Int {
        return sharedPreferences.getInt(PREFS_PERMISSION_DENY_COUNT, -1)
    }

    private fun showPermissionDeniedDialog() {
        var dialogType: String = DIALOG_TYPE_PERMISSION

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            dialogType = when (getPermissionDenyCount()) {
                -1 -> {
                    sharedPreferences.edit().putInt(PREFS_PERMISSION_DENY_COUNT, 1).apply()
                    DIALOG_TYPE_PERMISSION_ONCE
                }
                1 -> {
                    sharedPreferences.edit().putInt(PREFS_PERMISSION_DENY_COUNT, 2).apply()
                    DIALOG_TYPE_PERMISSION_TWICE
                }
                else -> DIALOG_TYPE_PERMISSION_TWICE
            }
        } else {
            DIALOG_TYPE_PERMISSION
        }

        val permissionDeniedDialog = CustomDialog(this, dialogType) {
            finishAffinity()
            exitProcess(0)
        }
        if (permissionDeniedDialog.isShowing) permissionDeniedDialog.dismiss()
        permissionDeniedDialog.show()
    }

}