package com.pencilboxfree.drawmodel

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.pencilboxfree.interfaces.LayerInterface
import com.pencilboxfree.interfaces.LayersManagerInterface
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class Layer constructor(layersManager: LayersManagerInterface, name: String, width: Int, height: Int, index: Int, debug: Boolean=false): LayerInterface {

    override var name: String = "" @Synchronized get @Synchronized set

    override var index: Int = 0
        @Synchronized get
        @Synchronized set

    override var visible: Boolean = true
        @Synchronized get
        @Synchronized set

    private val _bitmap: Bitmap
    override val bitmap: Bitmap
        get() {
            synchronized(this) {
                return _bitmap
            }
        }


    companion object {
        fun create(
                layersManager: LayersManager,
                name: String,
                width: Int,
                height: Int,
                index: Int): Layer = Layer(layersManager, name, width, height, index)
    }

    val layersManager: LayersManagerInterface
    val width: Int
    val height: Int

    init {
        this.name = name
        this.layersManager = layersManager
        this.width = width
        this.height = height
        this.index = index

        visible = true

        _bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        if (debug) {
            val colors = intArrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW)
            val paint = Paint()
            paint.setColor(if (index < colors.size) colors[index] else colors[colors.size - 1])
            paint.setTextSize(40F)

            val canvas = Canvas(bitmap)
            //canvas.drawColor(Color.BLACK)
            canvas.drawText(index.toString(), (width/2).toFloat(), (height/2).toFloat(), paint)
        }

        storeLayer()
    }

    override fun recycle() {
        synchronized(this) {
            if (!isRecycled()) {
                bitmap.recycle()
            }
        }
    }

    override fun isRecycled(): Boolean {
        synchronized(this) {
            return bitmap.isRecycled()
        }
    }

    public override fun storeLayer() {
        // put to storage
    }

    public override fun restoreLayer() {
        // get from storage
    }

    override fun getInfo(): LayerInfo {
        return LayerInfo("", this.index, this.index == this.layersManager.activeLayerIndex, this.visible)
    }

    override fun compressBitmap(filePath: String): Boolean {
        return layersManager.storageHelper.compressBitmap(filePath, bitmap)
    }
}
