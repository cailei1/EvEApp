package com.onepiece.eveapp.data

sealed class Resource<T>(val data:T? =null,val errorCode:Int? = null){

    class Success<T>(data: T?):Resource<T>(data)

    class Loading<T>(data: T? = null):Resource<T>()

    class DataError<T>(errorCode:Int = 0):Resource<T>(errorCode = errorCode)
}
