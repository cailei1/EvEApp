package com.onepiece.eveapp.ui.battery

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityBatteryDetailBinding
import com.onepiece.eveapp.eneity.MySection
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BatteryDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityBatteryDetailBinding

    val list: MutableList<MySection> = ArrayList()

     val mFragments = ArrayList<Fragment>()

     val mTitles = arrayOf(
        "电池簇1"
    )

    private lateinit var mAdapter: MyBatteryAdapter

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = ActivityBatteryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListener()
    }

    private fun initListener() {
        for (title in mTitles) {
            mFragments.add(BatterDetailFragment())
        }
        mAdapter =  MyBatteryAdapter(supportFragmentManager)
        binding.viewPager.setAdapter(mAdapter)

        binding.slideTabLayout.setViewPager(binding.viewPager,mTitles)
    }


    inner class MyBatteryAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTitles[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }
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


}