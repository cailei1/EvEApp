package com.onepiece.eveapp.data.remote

import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.data.remote.service.ApiService
import com.onepiece.eveapp.dto.BaseResponse
import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.eneity.LoginRequest
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(private val retrofitService: RetrofitService) :
    RemoteDataSource {
    override suspend fun doLogin(loginRequest: LoginRequest): Resource<BaseResponse<LoginResponse>> {
        val createService = retrofitService.createService(ApiService::class.java)
        val result = createService.doLogin(loginRequest)

        return Resource.Success(result)
    }


    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
//        if (!networkConnectivity.isConnected()) {
//            return NO_INTERNET_CONNECTION
//        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
//            NETWORK_ERROR
        }
    }
}