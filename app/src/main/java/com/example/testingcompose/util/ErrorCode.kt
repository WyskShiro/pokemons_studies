package com.example.testingcompose.util

enum class ErrorCode(val code: Int) {
    None(0),
    BadRequest(400),
    Unauthorized(401),
    Forbidden(403),
    InternalServerError(500)
}