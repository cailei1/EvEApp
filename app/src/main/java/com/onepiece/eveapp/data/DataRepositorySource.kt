package com.onepiece.eveapp.data

import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.eneity.LoginRequest
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {

     suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>
}