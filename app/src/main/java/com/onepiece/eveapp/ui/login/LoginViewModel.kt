package com.onepiece.eveapp.ui.login

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.onepiece.eveapp.base.BaseViewModel
import com.onepiece.eveapp.data.DataRepositorySource
import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.dto.BaseResponse
import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.eneity.LoginRequest
import com.onepiece.eveapp.ui.main.MainTestActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val dataRepository: DataRepositorySource) :
    BaseViewModel() {

    private val loginLiveDataPrivate = MutableLiveData<Resource<BaseResponse<LoginResponse>>>()
    public val loginLiveData: MutableLiveData<Resource<BaseResponse<LoginResponse>>> get() = loginLiveDataPrivate
    public fun login(userName: String, password: String) {

        viewModelScope.launch {

            dataRepository.doLogin(loginRequest = LoginRequest(userName, password)).collect {
                loginLiveData.value = it
            }
        }
    }
}