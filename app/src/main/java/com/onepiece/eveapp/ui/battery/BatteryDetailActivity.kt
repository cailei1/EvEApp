package com.onepiece.eveapp.ui.battery

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.onepiece.eveapp.GridSectionAverageGapItemDecoration
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.SelectionQuickAdapter
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivitySectionUerBinding
import com.onepiece.eveapp.eneity.MySection
import com.onepiece.eveapp.eneity.SingleBatteryBean
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BatteryDetailActivity : BaseActivity() {

    private lateinit var binding: ActivitySectionUerBinding

    val list: MutableList<MySection> = ArrayList()
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivitySectionUerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initListener()
    }

    private fun initListener() {
        binding.rvList.adapter =
            SelectionQuickAdapter(R.layout.item_section_content, R.layout.item_section_header, list)
        binding.rvList.addItemDecoration(GridSectionAverageGapItemDecoration(10F, 10F, 20F, 15F))

        binding.rvList.layoutManager = GridLayoutManager(this,3)
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