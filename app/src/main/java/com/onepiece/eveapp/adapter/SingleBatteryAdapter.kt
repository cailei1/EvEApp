package com.onepiece.eveapp.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.onepiece.eveapp.R
import com.onepiece.eveapp.eneity.SingleBatteryBean

class SingleBatteryAdapter(data:MutableList<SingleBatteryBean>) : BaseQuickAdapter<SingleBatteryBean,BaseViewHolder>(
    R.layout.item_home_recyclerview, data) {
    override fun convert(holder: BaseViewHolder, item: SingleBatteryBean) {

    }
}