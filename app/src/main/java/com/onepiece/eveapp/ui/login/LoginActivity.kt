package com.onepiece.eveapp.ui.login

import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.onepiece.eveapp.base.BaseActivity
import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.databinding.ActivityLoginBinding
import com.onepiece.eveapp.dto.BaseResponse
import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.ui.MainActivity
import com.onepiece.eveapp.ui.TestActivity
import com.onepiece.eveapp.ui.battery.BatteryDetailActivity
import com.onepiece.eveapp.ui.main.MainTestActivity
import com.onepiece.eveapp.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by viewModels()


    override fun observeViewModel() {
        binding.loginTv.setOnClickListener {
            Log.e("eve", "startMainActivity")
            loginViewModel.login("eve", "123456")
        }

        observe(loginViewModel.loginLiveData, ::handleLoginResult)
    }

    private fun handleLoginResult(status: Resource<BaseResponse<LoginResponse>>) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}