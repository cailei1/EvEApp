package com.onepiece.eveapp.data.remote

import com.onepiece.eveapp.data.Resource
import com.onepiece.eveapp.dto.LoginResponse


/**
 * Created by AhmedEltaher
 */

internal interface RemoteDataSource {
    suspend fun doLogin(): Resource<LoginResponse>
}
