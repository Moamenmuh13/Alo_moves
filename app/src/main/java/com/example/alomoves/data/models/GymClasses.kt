package com.example.alomoves.data.models

class GymClasses : ArrayList<GymClassesItem>()
data class GymClassesItem(
    val id: Int?,
    val image: String?,
    val classesTitle: String?,
    val classesDuration: String?,
    val classesDescription: String?
)