package com.pencilboxfree.interfaces

import com.pencilboxfree.drawmodel.LayerInfo

interface LayerInterface {
    var name: String
    var index: Int
    var visible: Boolean
    fun storeLayer()
    fun restoreLayer()
    fun recycle()
    fun getInfo(): LayerInfo
}