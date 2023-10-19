package com.onepiece.eveapp.ui.station

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.blankj.utilcode.util.BarUtils
import com.gyf.immersionbar.ImmersionBar
import com.onepiece.eveapp.R
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentPowerStationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PowerStationFragment : BaseFragment() {
    private lateinit var binding: FragmentPowerStationBinding

    private val animators: MutableList<ValueAnimator> = mutableListOf()

    private val mTitles = arrayOf("当天", "30天", "90天")
    private val powerStationViewModel: PowerStationViewModel by activityViewModels()


    override fun initViewBinding(): View {
        binding = FragmentPowerStationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.segmentLayout.setTabData(mTitles)
        Log.e("eve", binding.centerImage.x.toString())
        Log.e("eve", binding.centerImage.y.toString())
        binding.centerImage.post {
//            binding.container.startLeftTopAnimaor()

            startOneAnimation()
//            binding.container.startCenter2LeftTopAnimation()

        }

        powerStationViewModel.initLineChart(binding.lineChart)
    }

    override fun initListener() {

    }

    override fun onResume() {
        super.onResume()
//        ImmersionBar.with(this).statusBarColor(R.color.green_84).init()

    }
    private fun startOneAnimation() {
        stopAnimations()
        animators.add(binding.container.startRightTop2CenterAnimation {
            animators.add(binding.container.startCenter2LeftBottomAnimation())
            animators.add(binding.container.startCenter2RightBottomAnimation())
        })

        Handler().postDelayed({startTwoAnimation()},20000)
    }

    private fun startTwoAnimation() {
        stopAnimations()
        animators.add(binding.container.startLeftTop2CenterAnimation {
            animators.add(binding.container.startCenter2LeftBottomAnimation())
            animators.add(binding.container.startCenter2RightBottomAnimation())
        })
    }

    private fun stopAnimations() {
        if (animators.size > 0) {
            animators.forEach {
                it.end()
            }
        }
    }
    

    override fun observeViewModel() {

    }

    override fun initData() {

    }
}