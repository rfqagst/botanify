package com.example.botanify.di

import com.example.botanify.data.firebase.repository.AuthRepository
import com.example.botanify.data.firebase.repository.InformationRepositoryFB
import com.example.botanify.data.firebase.repository.PlantRepositoryFB
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

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
    fun provideAuthRepository(): AuthRepository =
        AuthRepository(provideFirebaseAuth(), provideFirebaseDatabase())

    @Provides
    @Singleton
    fun providePlantRepository(): PlantRepositoryFB = PlantRepositoryFB(
        provideFirebaseAuth(), provideFirebaseDatabase(),
        provideFirebaseStorage()
    )

    @Provides
    @Singleton
    fun provideInformationRepository(): InformationRepositoryFB = InformationRepositoryFB(
        provideFirebaseDatabase(),
    )
}