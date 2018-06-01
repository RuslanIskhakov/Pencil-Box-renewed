package com.pencilboxfree.drawmodel

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.pencilboxfree.interfaces.LayerInterface
import com.pencilboxfree.interfaces.LayersManagerInterface

class Layer constructor(layersManager: LayersManagerInterface, name: String, width: Int, height: Int, index: Int, debug: Boolean=false): LayerInterface{

    private var _name: String = ""
    override var name: String
        get() {
            synchronized(this) {
                return _name
            }
        }
        set(value) {
            synchronized(this) {
                _name = value
            }
        }

    private var _index: Int = 0
    override var index: Int
        get() {
            synchronized(this) {
                return _index
            }
        }
        set(value) {
            synchronized(this) {
                _index = value
            }
        }
    private var _visible = true
    override var visible: Boolean
        get() {
            synchronized(this) {
                return _visible
            }
        }
        set(value) {
            synchronized(this) {
                _visible = value
            }
        }

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
            paint.setStrokeWidth(10F)

            val canvas = Canvas(bitmap)
            canvas.drawText(index.toString(), 0F,0F,paint)
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
}
