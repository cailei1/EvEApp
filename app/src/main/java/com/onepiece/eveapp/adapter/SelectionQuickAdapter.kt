package com.onepiece.eveapp.adapter

import android.os.Parcel
import android.os.Parcelable
import android.provider.MediaStore.Video
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.onepiece.eveapp.R
import com.onepiece.eveapp.eneity.MySection
import com.onepiece.eveapp.eneity.SingleBatteryBean


class SelectionQuickAdapter(contentLayoutId:Int, headLayoutId:Int, data:MutableList<MySection>) : BaseSectionQuickAdapter<MySection,BaseViewHolder>(headLayoutId,data) {



    init {
        setNormalLayout(contentLayoutId)
    }
    override fun convert(holder: BaseViewHolder, item: MySection) {
//        val video = item.data as SingleBatteryBean
//        val recyclerView = holder.getView<RecyclerView>(R.id.recycler_view)
//        recyclerView.layoutManager = GridLayoutManager(context,3)
//        holder.setText(R.id.tv, video.getName())
    }

    override fun convertHeader(helper: BaseViewHolder, item: MySection) {
        if (item != null && item.data is String) {
            helper.setText(R.id.group_number, item.data as String?)
        }
    }

}