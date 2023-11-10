package com.onepiece.eveapp.dto

class BaseResponse<T>(val code: Int, val msg: String, val data: T)