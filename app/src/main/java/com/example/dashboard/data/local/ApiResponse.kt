package com.example.dashboard.data.local

data class ApiResponse(
    val errors: List<Any>,
    val message: String,
    val name: String,
    val status: Boolean,
    val statusCode: Int
)