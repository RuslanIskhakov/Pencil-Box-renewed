package com.pencilboxfree.interfaces

import android.graphics.Bitmap
import android.graphics.Color
import com.pencilboxfree.drawmodel.LayerInfo

interface LayersManagerInterface {
    var activeLayerIndex: Int
    var backgroundColor: Int
    fun addLayer(layerName: String, atIndex: Int): Boolean
    fun removeLayer(layerName: String): Boolean
    fun recycle()
    fun getTopLayersBitmap(): Bitmap
    fun getActiveLayerBitmap(): Bitmap
    fun getBottomLayersBitmap(): Bitmap
    fun moveLayerUp(layerName: String): Boolean
    fun moveLayerDown(layerName: String): Boolean
    fun setLayerVisibility(layerName: String, visible: Boolean): Boolean
    fun setActiveLayer(layerName: String): Boolean
    fun getLayersInfo(): List<LayerInfo>
}