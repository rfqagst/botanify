package com.example.botanify.data.retrofit.response.backend

import com.google.gson.annotations.SerializedName

data class HamaResponse(

	@field:SerializedName("HamaResponse")
	val hamaResponse: List<HamaResponseItem?>? = null
)

data class HamaResponseItem(

	@field:SerializedName("id_penanganan")
	val idPenanganan: Int? = null,

	@field:SerializedName("penanganan")
	val penanganan: String? = null,

	@field:SerializedName("nama_hama")
	val namaHama: String? = null
)
