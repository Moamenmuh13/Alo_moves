package com.example.alomoves.data.repositories

import android.content.Context
import com.example.alomoves.data.models.GymClasses
import com.google.gson.Gson

class ClassesRepository(private val context: Context) {

    fun getClasses(): GymClasses {
        val json = context.assets.open("response.json").bufferedReader().use {
            it.readText()
        }
        return Gson().fromJson(json, GymClasses::class.java)
    }
}

