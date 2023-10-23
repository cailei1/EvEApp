package com.onepiece.eveapp.ui.energy

import android.content.Intent
import android.view.View
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentEnergyDetailBinding
import com.onepiece.eveapp.ui.battery.BatteryDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EnergyDetailFragment : BaseFragment() {

    private lateinit var energyDetailBinding: FragmentEnergyDetailBinding
    override fun initViewBinding(): View {
        energyDetailBinding = FragmentEnergyDetailBinding.inflate(layoutInflater)
        return energyDetailBinding.root
    }

    override fun observeViewModel() {

    }

    override fun initData() {

    }

    override fun initListener() {

        energyDetailBinding.batteryDetail.setOnClickListener {
            startActivity(Intent(activity, BatteryDetailActivity::class.java))
        }

    }
}