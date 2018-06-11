package com.pencilboxfree.storage

import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import com.pencilboxfree.interfaces.StorageHelperInterface
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class StorageHelper: StorageHelperInterface {

    companion object {
        private val TAG = StorageHelper.javaClass.simpleName
    }

    override fun compressBitmap(filepath: String, bmp: Bitmap): Boolean {
        Log.d(TAG, "compressBitmap: " + filepath)
        synchronized(this) {
            var fos: FileOutputStream? = null
            try {
                val pngFile = File(filepath)
                if (pngFile.exists()) pngFile.delete()
                pngFile.parentFile.mkdirs()
                pngFile.createNewFile()

                val fos = FileOutputStream(pngFile)
                bmp.compress(Bitmap.CompressFormat.PNG, 100, fos as OutputStream?)
                return true
            } catch (thr: Throwable) {
                return false
            } finally {
                try {
                    fos?.close()
                } catch (thr: Throwable) {}
            }
        }
    }

    override fun storeBitmap(layerName: String, bmp: Bitmap) {
        synchronized(this) {
            Log.d(TAG, "storeBitmap: " + layerName)
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun getBitmap(layerName: String): Bitmap? {
        synchronized(this) {
            Log.d(TAG, "getBitmap: " + layerName)
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return null
        }
    }
}