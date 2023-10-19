package com.onepiece.eveapp.ui.battery

import android.os.Bundle
import android.provider.MediaStore.Video
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.SelectionQuickAdapter
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityBatteryDetailBinding
import com.onepiece.eveapp.eneity.MySection
import com.onepiece.eveapp.eneity.SingleBatteryBean
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BatteryDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityBatteryDetailBinding

    val list: MutableList<MySection> = ArrayList()
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityBatteryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initListener()
    }

    private fun initListener() {
        binding.batteryRv.adapter =
            SelectionQuickAdapter(R.layout.item_single_battery, R.layout.item_header_top, list)
        binding.batteryRv.layoutManager = GridLayoutManager(this,3)
    }

    private fun initData() {
        getSectionData()
    }

//    private fun getEntity(): List<MySection>? {
//        //总的 list，里面放的是 FirstNode
//
//        for (i in 0..7) {
//
//            //SecondNode 的 list
//            val secondNodeList: MutableList<SingleBatteryBean> = ArrayList()
//            for (n in 0..5) {
//                val seNode = SingleBatteryBean()
//                secondNodeList.add(seNode)
//            }
//            list.add(entity)
//        }
//        return list
//    }

    private fun getSectionData(): List<MySection>? {
//        val list1: MutableList<MySection> = ArrayList()
        for (i in 0..7) {
            list.add(MySection(true, "电池组$i"))
            list.add(MySection(false, SingleBatteryBean()))
            list.add(MySection(false, SingleBatteryBean()))
            list.add(MySection(false, SingleBatteryBean()))
            list.add(MySection(false, SingleBatteryBean()))
            list.add(MySection(false, SingleBatteryBean()))
            list.add(MySection(false, SingleBatteryBean()))
        }
        return list
    }
}