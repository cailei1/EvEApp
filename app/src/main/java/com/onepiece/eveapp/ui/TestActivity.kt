package com.onepiece.eveapp.ui

import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityTestBinding

class TestActivity : BaseActivity() {
    private lateinit var binding: ActivityTestBinding
    override fun observeViewModel() {
    }

    override fun initViewBinding() {
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}