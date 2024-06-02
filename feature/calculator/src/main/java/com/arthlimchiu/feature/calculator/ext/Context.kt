package com.arthlimchiu.feature.calculator.ext

import android.content.Context
import java.io.File

fun Context.createImageFile(): File {
    val fileName = System.currentTimeMillis().toString()
    return File(filesDir, fileName)
}