package com.onepiece.eveapp.data.remote.service

import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.dto.LoginResponse
import retrofit2.http.GET

interface ApiService {

    @GET
    suspend fun doLogin():Resource<LoginResponse>
}