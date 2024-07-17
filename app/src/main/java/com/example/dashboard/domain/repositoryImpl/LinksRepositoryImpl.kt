package com.example.dashboard.domain.repositoryImpl

import android.content.Context
import com.example.dashboard.data.local.Link
import com.example.dashboard.data.local.Resource
import com.example.dashboard.data.remote.LinkDao
import com.example.dashboard.data.remote.LinksApiService
import com.example.dashboard.data.repository.LinksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class LinksRepositoryImpl @Inject constructor(
    private val apiService: LinksApiService,
    private val linkDao: LinkDao,
    private val context: Context
) : LinksRepository {

    override suspend fun getLinks(): Resource<List<Link>> {
        return withContext(Dispatchers.IO) {
            try {
                // Make the API call
                val response: Response<List<Link>> = apiService.getLinks()

                if (response.isSuccessful) {
                    val links = response.body() ?: emptyList()
                    linkDao.insertAll(links)
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
                // Handle other exceptions and fallback to cached data if available
                val cachedLinks = linkDao.getAllLinks()
                if (cachedLinks.isNotEmpty()) {
                    Resource.Success(cachedLinks)
                } else {
                    Resource.Error("An error occurred: ${e.localizedMessage}")
                }
            }
        }
    }
}
