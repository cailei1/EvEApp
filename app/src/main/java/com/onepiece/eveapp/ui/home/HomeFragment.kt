package com.onepiece.eveapp.ui.home

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.lxj.xpopup.XPopup
import com.onepiece.eveapp.R
import com.onepiece.eveapp.adapter.HomePowerStationAdapter
import com.onepiece.eveapp.base.BaseFragment
import com.onepiece.eveapp.databinding.FragmentHomeBinding
import com.onepiece.eveapp.dialog.AddStationDialog
import com.onepiece.eveapp.eneity.PowerStationBean
import com.onepiece.eveapp.ui.station.PowerStationDetailActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment() ,View.OnClickListener{
    private lateinit var binding:FragmentHomeBinding

    private lateinit var stationAdapter:HomePowerStationAdapter

    private val data:MutableList<PowerStationBean> = arrayListOf(
        PowerStationBean("","",0,"","",10.0,11.0),
        PowerStationBean("","",1,"","",10.0,11.0),
        PowerStationBean("","",2,"","",10.0,11.0),
        PowerStationBean("","",0,"","",10.0,11.0),
        PowerStationBean("","",1,"","",10.0,11.0),
        PowerStationBean("","",2,"","",10.0,11.0)

    )

    override fun initViewBinding(): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun observeViewModel() {
    }

    override fun initData() {
        stationAdapter = HomePowerStationAdapter(data)
        binding.recyclerView.adapter = stationAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun initListener() {
        binding.allLayout.setOnClickListener(this)
        binding.normalLayout.setOnClickListener(this)
        binding.errorLayout.setOnClickListener(this)
        binding.disconnectLayout.setOnClickListener(this)
        stationAdapter.addChildClickViewIds(R.id.right_menu_1,R.id.right_menu_2,R.id.content)
        stationAdapter.setOnItemChildClickListener(object : OnItemChildClickListener{
            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                when(view.id){
                    R.id.content ->{
                        startActivity(Intent(activity,PowerStationDetailActivity::class.java))
                    }
                }
            }

        })

        stationAdapter.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
            }

        })

        binding.floatingBtn.setOnClickListener {
            context?.let {
                XPopup.Builder(it)
                    .asCustom(AddStationDialog(it,{}))
                    .show()
            }

        }

    }

    override fun onClick(v: View) {
        restoreStatus()
        statusSelected(v)
        when(v.id){
            R.id.all_layout ->{

            }
            R.id.normal_layout ->{

            }

            R.id.error_layout -> {

            }

            R.id.disconnect_layout ->{

            }
        }
    }

    fun statusSelected(view: View){
        view.setBackgroundResource(R.drawable.white_stroke_f616)
    }

    fun restoreStatus(){
        binding.errorLayout.setBackgroundResource(R.drawable.white_f616)
        binding.normalLayout.setBackgroundResource(R.drawable.white_f616)
        binding.disconnectLayout.setBackgroundResource(R.drawable.white_f616)
        binding.allLayout.setBackgroundResource(R.drawable.white_f616)
    }

}