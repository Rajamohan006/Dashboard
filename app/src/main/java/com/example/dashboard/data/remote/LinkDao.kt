package com.example.dashboard.data.remote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dashboard.data.local.Link

@Dao
interface LinkDao {
    @Query("SELECT * FROM links")
    suspend fun getAllLinks(): List<Link>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(links: List<Link>)

}