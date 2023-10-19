package com.onepiece.eveapp.ui.device

import android.view.View
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentDeviceManagerBinding
import com.onepiece.eveapp.databinding.FragmentEnergyDetailBinding

class DeviceManagerFragment : BaseFragment() {

    private lateinit var binding:FragmentDeviceManagerBinding
    override fun initViewBinding(): View {
        binding = FragmentDeviceManagerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun observeViewModel() {
    }

    override fun initData() {
    }

    override fun initListener() {

    }
}