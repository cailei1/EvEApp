package com.onepiece.eveapp.adapter

import android.R.attr.data
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.onepiece.eveapp.R
import com.onepiece.eveapp.eneity.FirstNode
import com.onepiece.eveapp.eneity.SecondNode
import com.onepiece.eveapp.eneity.SingleBatteryBean


class SecondNodeProvider() : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 1
    override val layoutId: Int
        get() = R.layout.item_single_battery

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as SingleBatteryBean

//        val recyclerView = helper.getView<RecyclerView>(R.id.recycler_view)
//        recyclerView.adapter = SingleBatteryAdapter(entity.childNode as MutableList<SingleBatteryBean>)
//        recyclerView.layoutManager = GridLayoutManager(context,3)
    }
}