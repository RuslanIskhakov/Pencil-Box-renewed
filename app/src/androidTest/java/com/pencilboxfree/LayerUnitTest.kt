package com.pencilboxfree

import android.graphics.Bitmap
import android.support.test.runner.AndroidJUnit4
import com.pencilboxfree.drawmodel.Layer
import com.pencilboxfree.drawmodel.LayerInfo
import com.pencilboxfree.interfaces.LayersManagerInterface
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.io.FileOutputStream

@RunWith(AndroidJUnit4::class)
class LayerUnitTest {

    @Test
    fun simpleTest() {
        /*
        val layer = Layer(StubLayerManager(), "layer0", 200,100,0,true)

        val pngFile = File(String.format("/sdcard/temp/layer_import_%d.png", layer.index))
        if (pngFile.exists()) pngFil

        val fos = FileOutputStream(pngFile)

        layer.recycle()
        assertEquals(layer.isRecycled(), true)
        */
    }

    class StubLayerManager: LayersManagerInterface {
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