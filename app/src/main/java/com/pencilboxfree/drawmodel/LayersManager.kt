package com.pencilboxfree.drawmodel

import android.graphics.Bitmap
import android.graphics.Color
import com.pencilboxfree.interfaces.LayerInterface
import com.pencilboxfree.interfaces.LayersManagerInterface
import com.pencilboxfree.interfaces.StorageHelperInterface

class LayersManager constructor(width: Int, height: Int, storageHelper: StorageHelperInterface)
    : LayersManagerInterface {

    private var _backgroundColor = Color.WHITE
    override var backgroundColor: Int
        get() {
            synchronized(this) {
                return _backgroundColor
            }
        }
        set(value) {
            synchronized(this) {
                _backgroundColor = backgroundColor
            }
        }

    private var _activeLayerIndex = 0
    override var activeLayerIndex: Int
        get() {
            synchronized(this) {
                return _activeLayerIndex
            }
        }
        set(value) {
            synchronized(this) {
                _activeLayerIndex = value
            }
        }

    val width: Int
    val height: Int
    val storageHelper: StorageHelperInterface

    val layers: HashMap<String, LayerInterface> = HashMap()

    init {
        this.width = width
        this.height = height
        this.storageHelper = storageHelper

        val layerName = "Layer #1"
        layers.put(layerName, Layer.create(this, layerName, width, height, 0))
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

    override fun moveLayerUp(layerName: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun moveLayerDown(layerName: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLayerVisibility(layerName: String, visible: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setActiveLayer(layerName: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayersInfo(): List<LayerInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}