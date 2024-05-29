package com.example.botanify.di

import com.example.botanify.data.repo.AuthRepository
import com.example.botanify.data.repo.PlantRepository
import com.google.firebase.auth.FirebaseAuth
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
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = AuthRepository(provideFirebaseAuth())

    @Provides
    @Singleton
    fun providePlantRepository(): PlantRepository = PlantRepository()

}