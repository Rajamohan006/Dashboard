package com.example.dashboard

import android.content.Context
import androidx.room.Room
import com.example.dashboard.data.database.LinkDatabase
import com.example.dashboard.data.remote.LinkDao
import com.example.dashboard.data.remote.LinksApiService
import com.example.dashboard.data.repository.LinksRepository
import com.example.dashboard.domain.repositoryImpl.LinksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.inopenapp.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer YOUR_TOKEN")
                .build()
            chain.proceed(request)
        }.build())
        .build()

    @Provides
    @Singleton
    fun provideLinksApiService(retrofit: Retrofit): LinksApiService = retrofit.create(LinksApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LinkDatabase =
        Room.databaseBuilder(context, LinkDatabase::class.java, "link_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideLinkDao(db: LinkDatabase): LinkDao = db.linkDao()

    @Provides
    @Singleton
    fun provideLinksRepository(
        apiService: LinksApiService,
        linkDao: LinkDao,
        @ApplicationContext context: Context
    ): LinksRepository = LinksRepositoryImpl(apiService, linkDao, context)
}
