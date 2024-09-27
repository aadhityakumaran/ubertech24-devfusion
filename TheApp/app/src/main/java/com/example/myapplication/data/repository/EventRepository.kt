package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Event

object EventRepository {
    private val apiService = RetrofitClient.instance

    fun getCategories(): List<String> {
        return apiService.getCategories()
    }

    fun getEvents(category: String): List<Event> {
        return apiService.getEvents(category)
    }

    fun addEvent(event: Event) {
        apiService.addEvent(event);
    }

    fun joinEvent(eventId: Int) {
        apiService.joinEvent(eventId)
    }
}