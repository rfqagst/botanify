package com.example.botanify.di

import com.example.botanify.data.repo.AuthRepository
import com.example.botanify.data.repo.PlantRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
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
    fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = AuthRepository(provideFirebaseAuth(),provideFirebaseDatabase())

    @Provides
    @Singleton
    fun providePlantRepository(): PlantRepository = PlantRepository(provideFirebaseAuth(),provideFirebaseDatabase(),
        provideFirebaseStorage()
    )

}