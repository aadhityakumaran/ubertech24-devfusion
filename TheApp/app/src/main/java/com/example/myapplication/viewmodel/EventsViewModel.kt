package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.Event
import com.example.myapplication.data.repository.EventRepository

class EventsViewModel (
    private val category: String
) : ViewModel() {

    var events: List<Event> = emptyList()

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        events = EventRepository.getEvents(category)
    }
}