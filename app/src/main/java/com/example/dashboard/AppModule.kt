package com.example.dashboard

import com.example.dashboard.data.remote.LinksApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideLinksApiService(retrofit: Retrofit): LinksApiService =
        retrofit.create(LinksApiService::class.java)

}
