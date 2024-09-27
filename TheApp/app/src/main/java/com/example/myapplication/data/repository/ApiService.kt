package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Event
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    @GET("categories")
    fun getCategories(): List<String>

    @GET("events")
    fun getEvents(category: String): List<Event>

    @POST("events")
    fun addEvent(event: Event)

    @PUT("events/{eventId}")
    fun joinEvent(eventId: Int)
}