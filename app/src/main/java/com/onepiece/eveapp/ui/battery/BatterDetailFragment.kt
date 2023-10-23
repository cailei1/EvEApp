package com.onepiece.eveapp.ui.battery

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.onepiece.eveapp.GridSectionAverageGapItemDecoration
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.SelectionQuickAdapter
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentBatteryDetailBinding
import com.onepiece.eveapp.eneity.MySection
import com.onepiece.eveapp.eneity.SingleBatteryBean
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BatterDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentBatteryDetailBinding


    override fun initViewBinding(): View {
        binding = FragmentBatteryDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun observeViewModel() {
    }

    override fun initData() {
        getSectionData()
    }

    override fun initListener() {
        binding.batteryRv.layoutManager = GridLayoutManager(activity, 3)
        binding.batteryRv.addItemDecoration(GridSectionAverageGapItemDecoration(10f, 10f, 20f, 15f))

        binding.batteryRv.adapter =
            SelectionQuickAdapter(R.layout.item_single_battery, R.layout.item_header_top, list)
    }


    val list: MutableList<MySection> = ArrayList()

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