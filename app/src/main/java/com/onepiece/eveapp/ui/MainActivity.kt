package com.onepiece.eveapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.ScreenSlidePagerAdapter
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityMainBinding
import com.onepiece.eveapp.ui.energy.EnergyDetailFragment
import com.onepiece.eveapp.ui.station.PowerStationFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragments: List<Fragment> = mutableListOf(
        PowerStationFragment(), EnergyDetailFragment(), PowerStationFragment()
    )


    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.powerStation.isChecked = true
                    1 -> binding.energyDetail.isChecked = true
                    2 -> binding.deviceManager.isChecked = true
                }
            }
        })
    }
}