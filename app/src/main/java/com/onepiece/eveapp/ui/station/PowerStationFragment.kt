package com.onepiece.eveapp.ui.station

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentPowerStationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PowerStationFragment : BaseFragment() {
    private lateinit var binding: FragmentPowerStationBinding


    private val powerStationViewModel:PowerStationViewModel by activityViewModels()


    override fun initViewBinding(): View {
        binding = FragmentPowerStationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("eve",binding.centerImage.x.toString())
        Log.e("eve",binding.centerImage.y.toString())

        binding.centerImage.post {
            binding.container.addLeftTopImage()
            binding.container.startLeftTopAnimaor()

            binding.container.addRightTopImage()
            binding.container.startRightTopAnimaor()
        }

        powerStationViewModel.initLineChart(binding.lineChart)
    }

    private fun initLineBar() {
        // // Chart Style // //


    }

    override fun observeViewModel() {

    }
}