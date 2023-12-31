package com.onepiece.eveapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.onepiece.eveapp.R
import com.onepiece.eveapp.utils.ScreenTabBar

abstract class BaseActivity : AppCompatActivity() {

    abstract fun observeViewModel()
    protected abstract fun initViewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {

        ImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init()
//        ImmersionBar.with(this).statusBarDarkFont(true, 0.2f)

//        ScreenTabBar.transparentNavigationBar(window)
        super.onCreate(savedInstanceState)

        initViewBinding()
        observeViewModel()
    }
}