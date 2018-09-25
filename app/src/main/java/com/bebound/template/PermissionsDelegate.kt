package com.bebound.template

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

class PermissionsDelegate internal constructor(private val activity: Activity) {

    private val permissions = arrayOf(
            android.Manifest.permission.SEND_SMS,
            android.Manifest.permission.READ_SMS,
            android.Manifest.permission.RECEIVE_SMS,
            android.Manifest.permission.READ_PHONE_STATE
    )

    fun hasPermissions(): Boolean {
        var shouldAsk = false

        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                shouldAsk = true
                break
            }
        }
        return !shouldAsk
    }

    fun requestPermissions() {
        ActivityCompat.requestPermissions(
                activity,
                permissions,
                REQUEST_CODE
        )
    }

    fun resultGranted(requestCode: Int,
                      grantResults: IntArray): Boolean {
        return requestCode == REQUEST_CODE && grantResults.isNotEmpty()
    }

    companion object {
        private val REQUEST_CODE = 1983
    }
}
