package com.example.myapplication.data.model

data class Event (
    val id: Int = 0,
    val category: String = "",
    val activity: String = "",
    val dateTime: Long = 0,
    val location: String = "",
    val numberOfPeople: Int = 0,
)