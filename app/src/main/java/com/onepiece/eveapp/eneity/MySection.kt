package com.onepiece.eveapp.eneity

import com.chad.library.adapter.base.entity.SectionEntity

class MySection : SectionEntity {
    val data: Any
    var isHeaders : Boolean
    constructor(isHeaders: Boolean = false,data: Any) {
        this.isHeaders = isHeaders
        this.data = data
    }

    override val isHeader: Boolean
        get() {
            // 根据数据实体内的数据，判断是否是header
            return isHeaders
        }
}