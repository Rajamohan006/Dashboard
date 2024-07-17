package com.example.dashboard.data.repository

import com.example.dashboard.data.local.Link
import com.example.dashboard.Resource
import com.example.dashboard.data.remote.LinksApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class LinksRepositoryImpl @Inject constructor(
    private val apiService: LinksApiService,
) : LinksRepository {

    override suspend fun getLinks(): Resource<List<Link>> {
        return withContext(Dispatchers.IO) {
            try {
                // Make the API call
                val response: Response<List<Link>> = apiService.getLinks()

                if (response.isSuccessful) {
                    val links = response.body() ?: emptyList()
                    Resource.Success(links)
                } else {
                    // Handle different HTTP status codes
                    when (response.code()) {
                        401 -> Resource.Unauthorized()
                        else -> Resource.Error("Error ${response.code()}: ${response.message()}")
                    }
                }
            } catch (e: HttpException) {
                // Handle HttpException
                if (e.code() == 401) {
                    Resource.Unauthorized()
                } else {
                    Resource.Error("Network error: ${e.localizedMessage}")
                }
            } catch (e: Exception) {
                Resource.Error("An error occurred: ${e.localizedMessage}")
            }
        }
    }
}
