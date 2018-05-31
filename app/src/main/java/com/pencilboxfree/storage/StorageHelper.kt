package com.pencilboxfree.storage

import android.graphics.Bitmap
import android.util.Log
import com.pencilboxfree.interfaces.StorageHelperInterface

class StorageHelper: StorageHelperInterface {

    companion object {
        private val TAG = StorageHelper.javaClass.simpleName
    }

    override fun storeBitmap(layerName: String, bmp: Bitmap) {
        synchronized(this) {
            Log.d(TAG, "storeBitmap" + layerName)
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun getBitmap(layerName: String): Bitmap? {
        synchronized(this) {
            Log.d(TAG, "getBitmap" + layerName)
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return null
        }
    }
}