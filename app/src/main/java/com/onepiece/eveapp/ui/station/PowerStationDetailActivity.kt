package com.onepiece.eveapp.ui.station

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.ScreenSlidePagerAdapter
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityMainBinding
import com.onepiece.eveapp.databinding.ActivityPowerStationDetailBinding
import com.onepiece.eveapp.ui.device.DeviceManagerFragment
import com.onepiece.eveapp.ui.energy.EnergyDetailFragment
import com.onepiece.eveapp.ui.station.PowerStationFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PowerStationDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityPowerStationDetailBinding

    private val fragments: List<Fragment> = mutableListOf(
        PowerStationFragment(), EnergyDetailFragment(), DeviceManagerFragment()
    )


    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityPowerStationDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        Log.e("eve","mainActivity onResume")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private fun initData() {
        binding.powerStation.isChecked = true
        var screenSlidePagerAdapter = ScreenSlidePagerAdapter(this, fragments)
        binding.viewPager.adapter = screenSlidePagerAdapter
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.power_station -> binding.viewPager.currentItem = 0
                R.id.energy_detail -> binding.viewPager.currentItem = 1
                R.id.device_manager -> binding.viewPager.currentItem = 2
            }
        }
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("eve","pagechage ${position}")
                when (position) {
                    0 -> {
//                        ImmersionBar.with(this@PowerStationDetailActivity).statusBarColor(R.color.green_84).init()
                        binding.powerStation.isChecked = true
                    }
                    1 ->{ binding.energyDetail.isChecked = true
//                        ImmersionBar.with(this@PowerStationDetailActivity).transparentBar().init()
                    }
                    2 ->{ binding.deviceManager.isChecked = true
//                        ImmersionBar.with(this@PowerStationDetailActivity).transparentBar().init()
                    }
                }
            }
        })
    }
}