package com.onepiece.eveapp.data.remote

import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.data.remote.service.ApiService
import com.onepiece.eveapp.dto.LoginResponse
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(private val retrofitService: RetrofitService) : RemoteDataSource{
    override suspend fun doLogin(): Resource<LoginResponse> {
        val createService = retrofitService.createService(ApiService::class.java)
        createService.doLogin()
        return createService.doLogin()
    }


//    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
//        if (!networkConnectivity.isConnected()) {
//            return NO_INTERNET_CONNECTION
//        }
//        return try {
//            val response = responseCall.invoke()
//            val responseCode = response.code()
//            if (response.isSuccessful) {
//                response.body()
//            } else {
//                responseCode
//            }
//        } catch (e: IOException) {
//            NETWORK_ERROR
//        }
//    }
}