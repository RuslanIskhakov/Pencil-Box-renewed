package com.pencilboxfree.enums

import android.Manifest

enum class PermissionData(val index: Int, val requestCode: Int, val manifestPermission: String) {
    PERMISSION_WRITE_EXTERNAL_STORAGE(0, 1000, Manifest.permission.WRITE_EXTERNAL_STORAGE)
}