package com.onepiece.eveapp.data

import com.onepiece.eveapp.data.local.LocalData
import com.onepiece.eveapp.data.remote.RemoteData
import com.onepiece.eveapp.dto.BaseResponse
import com.onepiece.eveapp.dto.LoginResponse
import com.onepiece.eveapp.eneity.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(private val remoteRepository: RemoteData, val localRepository:LocalData, private val ioDispatcher: CoroutineContext) :DataRepositorySource{
    override suspend fun doLogin(loginRequest: LoginRequest): Flow<Resource<BaseResponse<LoginResponse>>> {
            return flow {
                emit(remoteRepository.doLogin(loginRequest))
            }.flowOn(ioDispatcher)
    }
}