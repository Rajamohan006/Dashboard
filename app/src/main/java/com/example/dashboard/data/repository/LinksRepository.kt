package com.example.dashboard.data.repository

import com.example.dashboard.data.local.Link
import com.example.dashboard.Resource

interface LinksRepository {
    suspend fun getLinks(): Resource<List<Link>>
}
