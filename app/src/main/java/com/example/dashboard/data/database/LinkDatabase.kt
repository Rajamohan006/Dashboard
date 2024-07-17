package com.example.dashboard.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dashboard.data.local.Link
import com.example.dashboard.data.remote.LinkDao

@Database(entities = [Link::class], version = 1)
abstract class LinkDatabase : RoomDatabase() {
    abstract fun linkDao(): LinkDao


}
