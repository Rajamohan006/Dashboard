package com.example.dashboard.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Link(
    val id: String,
    val title: String,
    val url: String,
    val clicks: Int,
    val views: Int,
    val date: String
)
