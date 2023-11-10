package com.onepiece.eveapp.dto


data class LoginResponse(
    val userName: String,
    val nickName: String,
    val address: String,
    val age: Long,
    val pcs_sn: String,
    val bms_sn: String,
)

