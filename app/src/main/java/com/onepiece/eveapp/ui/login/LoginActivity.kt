package com.onepiece.eveapp.ui.login

import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.databinding.ActivityLoginBinding
import com.onepiece.eveapp.ui.MainActivity
import com.onepiece.eveapp.ui.TestActivity
import com.onepiece.eveapp.ui.battery.BatteryDetailActivity

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by viewModels()


    override fun observeViewModel() {
        binding.loginTv.setOnClickListener {
            Log.e("eve","startMainActivity")
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}