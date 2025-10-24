package com.example.canteenchecker.adminapp.models

import com.example.canteenchecker.adminapp.api.IAdministrationApi
import com.example.canteenchecker.adminapp.api.InMemoryAdministrationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): IAdministrationApi = InMemoryAdministrationApiService()
}