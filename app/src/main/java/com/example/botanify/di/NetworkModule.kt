package com.example.botanify.di

import android.util.Log
import com.example.botanify.data.retrofit.repository.InformationRepository
import com.example.botanify.data.retrofit.repository.PenanggananRepository
import com.example.botanify.data.retrofit.repository.PlantRepository
import com.example.botanify.data.retrofit.repository.ScanRepository
import com.example.botanify.data.retrofit.repository.UserRepository
import com.example.botanify.data.retrofit.services.ClassifyPlantDiseasesServices
import com.example.botanify.data.retrofit.services.IdentifyPlantServices
import com.example.botanify.data.retrofit.services.InformationServices
import com.example.botanify.data.retrofit.services.PenanggananServices
import com.example.botanify.data.retrofit.services.PlantServices
import com.example.botanify.data.retrofit.services.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL_BACKEND = "http://10.0.2.2:3000/"
    private const val BASE_URL_PLANT_SCAN = "http://10.0.2.2:5000/"
    private const val BASE_URL_DEASEASE_SCAN = "https://detect.roboflow.com/"
    private const val API_KEY = "JjhPIp2Bnb3hM0ELzrmA"

    @Provides
    @Singleton
    fun provideApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
//                .header("x-api-key", API_KEY)
                .method(original.method, original.body)

            val request = requestBuilder.build()
            Log.d("API Request", "URL: ${request.url}, Method: ${request.method}")
            Log.d("API Request", "Headers: ${request.headers}")

            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(apiKeyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }


    // PROVIDE RETROFIT

    @Provides
    @Singleton
    @Named("Backend")
    fun provideRetrofitBackend(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_BACKEND)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("PlantScan")
    fun provideRetrofitPlantScan(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_PLANT_SCAN)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("DiseaseScan")
    fun provideRetrofitDiseaseScan(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_DEASEASE_SCAN)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    // PROVIDE SERVICES BACKEND
    @Provides
    @Singleton
    fun providePlantService(@Named("Backend") retrofit: Retrofit): PlantServices {
        return retrofit.create(PlantServices::class.java)
    }

    @Provides
    @Singleton
    fun provideInformationService(@Named("Backend") retrofit: Retrofit): InformationServices {
        return retrofit.create(InformationServices::class.java)
    }

    @Provides
    @Singleton
    fun provideUserServices(@Named("Backend") retrofit: Retrofit): UserServices {
        return retrofit.create(UserServices::class.java)
    }

    @Provides
    @Singleton
    fun providePenanganaanServices(@Named("Backend") retrofit: Retrofit): PenanggananServices {
        return retrofit.create(PenanggananServices::class.java)
    }


    // PROVIDE REPOSITORIES BACKEND
    @Provides
    @Singleton
    fun providePlantRepository(plantServices: PlantServices): PlantRepository {
        return PlantRepository(plantServices)
    }

    @Provides
    @Singleton
    fun provideInformationRepository(informationServices: InformationServices): InformationRepository {
        return InformationRepository(informationServices)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userServices: UserServices): UserRepository {
        return UserRepository(userServices)
    }

    @Provides
    @Singleton
    fun providePenanggananRepository(penanggananServices: PenanggananServices): PenanggananRepository {
        return PenanggananRepository(penanggananServices)
    }


    // PROVIDE SERVICES SCAN
    @Provides
    @Singleton
    fun providePlantScanService(@Named("PlantScan") retrofit: Retrofit): IdentifyPlantServices {
        return retrofit.create(IdentifyPlantServices::class.java)
    }

    @Provides
    @Singleton
    fun provideDiseaseScanService(@Named("DiseaseScan") retrofit: Retrofit): ClassifyPlantDiseasesServices {
        return retrofit.create(ClassifyPlantDiseasesServices::class.java)
    }

    // PROVIDE REPOSITORIES SCAN
    @Provides
    @Singleton
    fun provideScanRepository(
        identifyPlantServices: IdentifyPlantServices,
        classifyPlantDiseasesServices: ClassifyPlantDiseasesServices
    ): ScanRepository {
        return ScanRepository(identifyPlantServices, classifyPlantDiseasesServices)

    }
}