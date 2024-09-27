package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.Event
import com.example.myapplication.data.repository.EventRepository

class AddEventViewModel : ViewModel() {

    fun addEvent(
        category: String,
        activity: String,
        dateTime: Long,
        location: String
    ) {
        // Add event logic here
        EventRepository.addEvent(
            Event(
                category = category,
                activity = activity,
                dateTime = dateTime,
                location = location
            )
        )
    }


}