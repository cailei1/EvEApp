package com.onepiece.eveapp.adapter

import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode
import com.onepiece.eveapp.eneity.FirstNode
import com.onepiece.eveapp.eneity.SecondNode
import com.onepiece.eveapp.eneity.SingleBatteryBean


class BatteryNodeAdapter(data: MutableList<BaseNode>) : BaseNodeAdapter(data) {

    init {
        addFullSpanNodeProvider(RootNodeProvider())
        addNodeProvider(SecondNodeProvider())
    }

    override fun getItemType(data: List<BaseNode>, position: Int): Int {
        val node = data[position]
        if (node is FirstNode) {
            return 0
        } else if (node is SingleBatteryBean) {
            return 1
        }
        return -1
    }
}