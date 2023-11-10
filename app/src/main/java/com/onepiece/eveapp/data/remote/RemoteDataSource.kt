package com.onepiece.eveapp.data.remote

import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.dto.BaseResponse
import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.eneity.LoginRequest


/**
 * Created by AhmedEltaher
 */

internal interface RemoteDataSource {
    suspend fun doLogin(loginRequest:LoginRequest): Resource<BaseResponse<LoginResponse>>
}
