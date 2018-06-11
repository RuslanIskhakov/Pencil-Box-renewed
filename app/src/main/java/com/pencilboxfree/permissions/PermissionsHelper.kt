package com.pencilboxfree.permissions

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.pencilboxfree.enums.PermissionData

interface CheckPermissionListener {
    fun onPermissionGranted(permissionData: PermissionData)
    fun onPermissionAlreadyGranted(permissionData: PermissionData)
    fun onPermissionDenied(permissionData: PermissionData)
}

class PermissionsHelper {

    private object Holder { val INSTANCE = PermissionsHelper() }

    companion object {

        val instance: PermissionsHelper by lazy { Holder.INSTANCE }

        public fun checkPermission(activity: AppCompatActivity, permissionData: PermissionData) {
            instance.checkPermission(activity, permissionData)
        }
        public fun onCheckPermissionResult(activity: AppCompatActivity, requestCode: Int, permissions: Array<String>, grantResults: IntArray): Boolean {
            return instance.onCheckPermissionResult(activity, requestCode, permissions, grantResults)
        }
    }

    public fun checkPermission(activity: AppCompatActivity, permissionData: PermissionData) {
        if (ContextCompat.checkSelfPermission(activity, permissionData.manifestPermission) != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionData.manifestPermission)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                assert(false)
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, arrayOf(permissionData.manifestPermission), permissionData.requestCode)
            }
        } else {
            // Permission has already been granted
            if (activity is CheckPermissionListener) {
                val listener = activity as CheckPermissionListener
                listener.onPermissionAlreadyGranted(permissionData)
            }
        }
    }

    public fun onCheckPermissionResult(activity: AppCompatActivity, requestCode: Int, permissions: Array<String>, grantResults: IntArray): Boolean {
        when (requestCode) {
            PermissionData.PERMISSION_WRITE_EXTERNAL_STORAGE.requestCode -> {
                // If request is cancelled, the result arrays are empty.
                for (i in 0..permissions.size-1) {
                    val permission = permissions[i]
                    if (permission == PermissionData.PERMISSION_WRITE_EXTERNAL_STORAGE.manifestPermission) {
                        if (grantResults.size > i && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            if (activity is CheckPermissionListener) {
                                val listener = activity as CheckPermissionListener
                                listener.onPermissionGranted(PermissionData.PERMISSION_WRITE_EXTERNAL_STORAGE)
                            }
                        }
                        break;
                    }
                }
                if (activity is CheckPermissionListener) {
                    val listener = activity as CheckPermissionListener
                    listener.onPermissionDenied(PermissionData.PERMISSION_WRITE_EXTERNAL_STORAGE)
                }
                return true;
            }
            else -> {
                return false;
            }
        }
    }
}