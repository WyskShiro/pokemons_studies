package com.example.testingcompose.util

import retrofit2.Response

data class ApiResponse<T>(
    val data: T? = null,
    val errorCode: ErrorCode = ErrorCode.None
)

fun <T> Repository.handleResponse(response: Response<T>): T {
    return if (response.isSuccessful && response.body() != null) {
        response.body()!!
    } else {
        throw RuntimeException(response.code().toString())
//        val errorCodes = ErrorCode.values()
//        ApiResponse(errorCode = errorCodes.find { it.code == response.code() } ?: ErrorCode.None)
    }
}