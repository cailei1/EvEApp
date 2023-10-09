package com.onepiece.eveapp.ui.energy

import android.view.View
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentEnergyDetailBinding

class EnergyDetailFragment : BaseFragment() {

    private lateinit var energyDetailBinding: FragmentEnergyDetailBinding
    override fun initViewBinding(): View {
        energyDetailBinding = FragmentEnergyDetailBinding.inflate(layoutInflater)
        return energyDetailBinding.root
    }

    override fun observeViewModel() {

    }
}