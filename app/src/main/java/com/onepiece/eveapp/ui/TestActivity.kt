package com.onepiece.eveapp.ui

import android.util.Log
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityTestBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestActivity : BaseActivity() {
    private lateinit var binding: ActivityTestBinding
    override fun observeViewModel() {
    }

    override fun initViewBinding() {
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener { finish() }
        binding.titleTv.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        Log.e("eve","test activity onresume")
    }
}