package com.onepiece.eveapp.data.remote.service

import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.dto.BaseResponse
import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.eneity.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("app/login/")
    suspend fun doLogin(@Body loginRequest: LoginRequest): BaseResponse<LoginResponse>
}