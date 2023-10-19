package com.onepiece.eveapp.adapter

import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.onepiece.eveapp.R
import com.onepiece.eveapp.eneity.PowerStationBean
import com.onepiece.eveapp.utils.dp

class HomePowerStationAdapter(data: MutableList<PowerStationBean>?) :
    BaseQuickAdapter<PowerStationBean, BaseViewHolder>(R.layout.item_home_recyclerview, data) {
    override fun convert(holder: BaseViewHolder, item: PowerStationBean) {
        when (item.status) {
            0 -> {
                holder.getView<TextView>(R.id.status_tv)
                    .setTextColor(context.getColor(R.color.green_84))

                holder.getView<TextView>(R.id.status_tv).text = "正常"
            }

            1 -> {
                holder.getView<TextView>(R.id.status_tv)
                    .setTextColor(context.getColor(R.color.red_04))

                holder.getView<TextView>(R.id.status_tv).text = "故障"
            }

            2 -> {
                holder.getView<TextView>(R.id.status_tv)
                    .setTextColor(context.getColor(R.color.white_99))
                holder.getView<TextView>(R.id.status_tv).text = "断连"
            }
        }
      // 加载图片
        holder.getView<ImageView>(R.id.station_img).load(
            R.mipmap.main_bg
        ){
            transformations(RoundedCornersTransformation(topLeft = 8f.dp, topRight = 8f.dp, bottomLeft = 8f.dp, bottomRight = 8f.dp))
        }
    }
}