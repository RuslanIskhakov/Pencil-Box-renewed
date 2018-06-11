package com.pencilboxfree.interfaces

import android.graphics.Bitmap

interface StorageHelperInterface {
    fun storeBitmap(layerName: String, bmp: Bitmap)
    fun getBitmap(layerName: String): Bitmap?
    fun compressBitmap(filepath: String, bmp: Bitmap): Boolean
}