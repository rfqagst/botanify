package com.example.botanify.utils

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

fun Uri.toFile(context: Context): File? {
    val contentResolver = context.contentResolver
    val fileName = "${System.currentTimeMillis()}.jpg"
    val tempFile = File(context.cacheDir, fileName)
    return try {
        val inputStream = contentResolver.openInputStream(this)
        val outputStream = FileOutputStream(tempFile)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
        tempFile
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}