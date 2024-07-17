package com.example.dashboard.data.remote

import com.example.dashboard.data.local.Link
import retrofit2.Response
import retrofit2.http.GET

interface LinksApiService {
    @GET("dashboardNew")
    suspend fun getLinks(): Response<List<Link>>
}