package com.example.botanify.data.retrofit.response.backend

import com.google.gson.annotations.SerializedName

data class InformationResponse(

	@field:SerializedName("InformationResponse")
	val informationResponse: List<InformationResponseItem?>? = null
)

data class InformationResponseItem(

	@field:SerializedName("penerbit")
	val penerbit: String? = null,

	@field:SerializedName("isi_artikel")
	val isiArtikel: String? = null,

	@field:SerializedName("kategori")
	val kategori: String? = null,

	@field:SerializedName("foto_informasi")
	val fotoInformasi: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("id_informasi")
	val idInformasi: Int? = null
)
