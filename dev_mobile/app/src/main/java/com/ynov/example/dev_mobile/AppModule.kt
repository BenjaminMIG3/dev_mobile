package com.ynov.example.dev_mobile

import com.ynov.example.dev_mobile.data.ApiService
import com.ynov.example.dev_mobile.data.TvShowRepositoryImpl
import com.ynov.example.dev_mobile.domain.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(apiService: ApiService): TvShowRepository {
        return TvShowRepositoryImpl(apiService)
    }
}