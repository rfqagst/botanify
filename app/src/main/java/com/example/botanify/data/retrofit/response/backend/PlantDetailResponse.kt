package com.example.botanify.data.retrofit.response.backend

import com.google.gson.annotations.SerializedName

data class PlantDetailResponse(

	@field:SerializedName("data")
	val data: Data? = null
)

data class Data(

	@field:SerializedName("deskripsi_tanaman")
	val deskripsiTanaman: String? = null,

	@field:SerializedName("nama_tanaman")
	val namaTanaman: String? = null,

	@field:SerializedName("foto_tanaman")
	val fotoTanaman: String? = null,

	@field:SerializedName("id_tanaman")
	val idTanaman: Int? = null
)
