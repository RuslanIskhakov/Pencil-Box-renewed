package com.pencilboxfree

import android.graphics.Bitmap
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.pencilboxfree.drawmodel.LayersManager
import com.pencilboxfree.interfaces.StorageHelperInterface

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.pencilboxfree", appContext.packageName)
    }

    @Test
    fun testLayerManager() {
        val storageHelper = TestStorageHelper()

        val layerManager = LayersManager(100, 200, storageHelper)

        assertEquals(100, layerManager.width)
    }

    class TestStorageHelper: StorageHelperInterface {
        override fun storeBitmap(layerName: String, bmp: Bitmap) {

        }

        override fun getBitmap(layerName: String): Bitmap? {
            return null
        }

    }
}
