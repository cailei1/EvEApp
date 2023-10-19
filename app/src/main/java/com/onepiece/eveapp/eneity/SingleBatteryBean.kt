package com.onepiece.eveapp.eneity

import com.chad.library.adapter.base.entity.node.BaseNode

data class SingleBatteryBean(val current:String = "22V",val voltage:String = "8V"):BaseNode() {
    override val childNode: MutableList<BaseNode>?
        get() = null
}