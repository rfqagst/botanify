package com.example.botanify.data.retrofit.response.scan

import com.google.gson.annotations.SerializedName

data class ScanPlantResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("accuracy")
	val accuracy: String? = null,

	@field:SerializedName("category")
	val category: String? = null
)
