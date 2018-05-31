package com.pencilboxfree.drawmodel

import android.graphics.Bitmap
import com.pencilboxfree.interfaces.LayerInterface

class Layer constructor(layersManager: LayersManager, name: String, width: Int, height: Int, index: Int): LayerInterface{
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
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var visible: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    companion object {
        fun create(
                layersManager: LayersManager,
                name: String,
                width: Int,
                height: Int,
                index: Int): Layer = Layer(layersManager, name, width, height, index)
    }

    val layersManager: LayersManager
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
