package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.EventRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel () {

    var categories: List<String> = emptyList()

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        viewModelScope.launch {
            categories = EventRepository.getCategories()
        }
    }

}