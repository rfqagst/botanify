package com.example.botanify.data.retrofit.response.backend

import com.google.gson.annotations.SerializedName

data class ResponseCollection(

	@field:SerializedName("data")
	val data: List<DataItemCollection?>? = null
)

data class DataItemCollection(

	@field:SerializedName("tgl_penyiraman")
	val tglPenyiraman: String? = null,

	@field:SerializedName("nama_tanaman")
	val namaTanaman: String? = null,

	@field:SerializedName("foto_tanaman")
	val fotoTanaman: String? = null,

	@field:SerializedName("jam_penyiraman")
	val jamPenyiraman: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("id_user")
	val idUser: Int? = null
)
