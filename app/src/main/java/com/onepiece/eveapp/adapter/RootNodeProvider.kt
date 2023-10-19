package com.onepiece.eveapp.adapter

import android.R.attr.data
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.onepiece.eveapp.R
import com.onepiece.eveapp.eneity.FirstNode


class RootNodeProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 0
    override val layoutId: Int
        get() = com.onepiece.eveapp.R.layout.item_header_top

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity: FirstNode = item as FirstNode
        helper.setText(R.id.group_number, entity.getTitle())
    }
}