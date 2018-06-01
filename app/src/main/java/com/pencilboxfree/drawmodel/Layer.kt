package com.pencilboxfree.drawmodel

import android.graphics.Bitmap
import com.pencilboxfree.interfaces.LayerInterface
import com.pencilboxfree.interfaces.LayersManagerInterface

class Layer constructor(layersManager: LayersManagerInterface, name: String, width: Int, height: Int, index: Int): LayerInterface{
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

    private val bitmap: Bitmap

    init {
        this.name = name
        this.layersManager = layersManager
        this.width = width
        this.height = height
        this.index = index

        visible = true

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        storeLayer()
    }

    override fun recycle() {
        if (!bitmap.isRecycled()) {
            bitmap.recycle()
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
