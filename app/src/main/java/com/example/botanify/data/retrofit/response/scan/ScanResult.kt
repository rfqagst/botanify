package com.example.botanify.data.retrofit.response.scan

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

data class ScanResult(
    val plantName: String,
    val disease: String,
    val userImageUri: String
)

val gson: Gson = GsonBuilder()
    .registerTypeAdapter(Uri::class.java, UriTypeAdapter())
    .create()

class UriTypeAdapter : TypeAdapter<Uri>() {
    override fun write(out: JsonWriter, value: Uri?) {
        out.value(value.toString())
    }

    override fun read(`in`: JsonReader): Uri {
        return Uri.parse(`in`.nextString())
    }
}