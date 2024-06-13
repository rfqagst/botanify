package com.example.botanify.data.retrofit.response.scan

import com.google.gson.annotations.SerializedName


data class PredictionsResponse(
	@SerializedName("time")
	val time: Double?,

	@SerializedName("image")
	val image: ImageInfo?,

	@SerializedName("predictions")
	val predictions: List<PredictionsItem>?
)

data class ImageInfo(
	@SerializedName("width")
	val width: Int?,

	@SerializedName("height")
	val height: Int?
)

data class PredictionsItem(
	@SerializedName("confidence")
	val confidence: Double?,

	@SerializedName("class_id")
	val classId: Int?,

	@SerializedName("x")
	val x: Double?,

	@SerializedName("width")
	val width: Double?,

	@SerializedName("y")
	val y: Double?,

	@SerializedName("detection_id")
	val detectionId: String?,

	@SerializedName("class")
	val jsonMemberClass: String?,

	@SerializedName("height")
	val height: Double?
)
