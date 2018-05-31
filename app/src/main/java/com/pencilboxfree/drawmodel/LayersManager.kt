package com.pencilboxfree.drawmodel

import android.graphics.Bitmap
import com.pencilboxfree.interfaces.LayersManagerInterface
import com.pencilboxfree.interfaces.StorageHelperInterface

class LayersManager constructor(width: Int, height: Int, storageHelper: StorageHelperInterface)
    : LayersManagerInterface {

    override var activeLayerIndex: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    val width: Int
    val height: Int
    val storageHelper: StorageHelperInterface

    val layers: HashMap<String, Layer> = HashMap()

    init {
        this.width = width
        this.height = height
        this.storageHelper = storageHelper

        layers.put("Layer #1", Layer.create(this, width, height))
    }

    override fun addLayer(layerName: String, atIndex: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeLayer(layerName: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun recycle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTopLayersBitmap(): Bitmap {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActiveLayerBitmap(): Bitmap {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBottomLayersBitmap(): Bitmap {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}