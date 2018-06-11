package com.pencilboxfree.activity

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.pencilboxfree.R
import com.pencilboxfree.enums.PermissionData
import com.pencilboxfree.permissions.CheckPermissionListener
import com.pencilboxfree.permissions.PermissionsHelper
import com.pencilboxfree.runtimetests.LayerRuntimeTest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CheckPermissionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
    }

    override fun onResume() {
        super.onResume()
        PermissionsHelper.checkPermission(this, PermissionData.PERMISSION_WRITE_EXTERNAL_STORAGE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (PermissionsHelper.onCheckPermissionResult(this, requestCode, permissions, grantResults)) return;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onPermissionGranted(permissionData: PermissionData) {
        val layerTests = LayerRuntimeTest()
        layerTests.testCompressLayerToFile()
    }

    override fun onPermissionAlreadyGranted(permissionData: PermissionData) {
        val layerTests = LayerRuntimeTest()
        layerTests.testCompressLayerToFile()
    }

    override fun onPermissionDenied(permissionData: PermissionData) {

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
