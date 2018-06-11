package com.pencilboxfree.runtimetests

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.pencilboxfree.drawmodel.Layer
import com.pencilboxfree.drawmodel.LayerInfo
import com.pencilboxfree.interfaces.LayersManagerInterface
import com.pencilboxfree.interfaces.StorageHelperInterface
import com.pencilboxfree.storage.StorageHelper
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class LayerRuntimeTest {

    public fun testCompressLayerToFile() {

        val layer = Layer(StubLayerManager(), "layer0", 200,100,0,true)

        layer.compressBitmap(String.format("%s/temp/layer_import_%d.png", Environment.getExternalStorageDirectory(), layer.index))

        layer.recycle()

        val layer1 = Layer(StubLayerManager(), "layer1", 200,100,1,true)

        layer1.compressBitmap(String.format("%s/temp/layer_import_%d.png", Environment.getExternalStorageDirectory(), layer1.index))

        layer1.recycle()
    }

    class StubLayerManager: LayersManagerInterface {
        override val storageHelper = StorageHelper()

        override var activeLayerIndex: Int
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
            set(value) {}
        override var backgroundColor: Int
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
            set(value) {}

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

}