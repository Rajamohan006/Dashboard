package com.example.dashboard.data.local

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Unauthorized<T>(data: T? = null) : Resource<T>(data, "Unauthorized: Please login again")
}
