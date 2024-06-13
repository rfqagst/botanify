package com.example.botanify.data.retrofit.repository

import android.util.Log
import com.example.botanify.data.retrofit.response.scan.PredictionsResponse
import com.example.botanify.data.retrofit.response.scan.ScanPlantResponse
import com.example.botanify.data.retrofit.services.ClassifyPlantDiseasesServices
import com.example.botanify.data.retrofit.services.IdentifyPlantServices
import com.example.botanify.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject

class ScanRepository @Inject constructor(
    private val plantIdentifyPlantServices: IdentifyPlantServices,
    private val diseaseIdentifyPlantServices: ClassifyPlantDiseasesServices
) {
    private val apiKey = "JjhPIp2Bnb3hM0ELzrmA"

    fun identifyPlantName(image: File): Flow<Resource<ScanPlantResponse>> = flow {
        emit(Resource.Loading())
        val requestImageFile = image.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageMultiPart = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestImageFile
        )
        try {
            val response = plantIdentifyPlantServices.identifyPlantName(imageMultiPart)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }
    }.flowOn(Dispatchers.IO)


    fun classifyPlantDiseasesPests(image: File): Flow<Resource<PredictionsResponse>> = flow {
        emit(Resource.Loading())
        val requestImageFile = image.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageMultiPart = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestImageFile
        )
        try {
            val response = diseaseIdentifyPlantServices.classifyPlantDiseasesPests(
                apiKey = apiKey,
                file = imageMultiPart
            )
            Log.d("classifyPlantDiseasesPests", "classifyPlantDiseasesPests: $response, image: $image")
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
        }
    }.flowOn(Dispatchers.IO)

}