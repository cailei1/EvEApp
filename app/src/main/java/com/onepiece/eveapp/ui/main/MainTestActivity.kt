package com.onepiece.eveapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.gyf.immersionbar.ImmersionBar
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.ScreenSlidePagerAdapter
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityMainBinding
import com.onepiece.eveapp.databinding.ActivityMainTestBinding
import com.onepiece.eveapp.ui.device.DeviceManagerFragment
import com.onepiece.eveapp.ui.energy.EnergyDetailFragment
import com.onepiece.eveapp.ui.home.HomeFragment
import com.onepiece.eveapp.ui.station.PowerStationFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTestActivity : BaseActivity() {
    private lateinit var binding: ActivityMainTestBinding


    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityMainTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private fun initData() {
        var fragmentManager = supportFragmentManager
        var beginTransaction = fragmentManager.beginTransaction()

        beginTransaction.replace(R.id.content, HomeFragment())
        beginTransaction.commit()

    }


}