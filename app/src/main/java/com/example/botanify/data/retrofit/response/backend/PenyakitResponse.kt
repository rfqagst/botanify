package com.example.botanify.data.retrofit.response.backend

import com.google.gson.annotations.SerializedName

data class PenyakitResponse(

	@field:SerializedName("PenyakitResponse")
	val penyakitResponse: List<PenyakitResponseItem?>? = null
)

data class PenyakitResponseItem(

	@field:SerializedName("id_penanganan")
	val idPenanganan: Int? = null,

	@field:SerializedName("penanganan")
	val penanganan: String? = null,

	@field:SerializedName("nama_penyakit")
	val namaPenyakit: String? = null
)
