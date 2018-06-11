package com.pencilboxfree.interfaces

import android.graphics.Bitmap
import com.pencilboxfree.drawmodel.LayerInfo

interface LayerInterface {
    var name: String
    var index: Int
    var visible: Boolean
    val bitmap: Bitmap
    fun storeLayer()
    fun restoreLayer()
    fun recycle()
    fun getInfo(): LayerInfo
    fun isRecycled(): Boolean
    fun compressBitmap(filePath: String): Boolean
}