package com.example.myapplication.navigation

sealed class Destinations (val route : String){

    data object HomeScreen : Destinations("homeScreen")
    data object EventScreen : Destinations("eventScreen/{event}") {
        fun createRoute(event: String) = "eventScreen/$event"
    }
    data object AddEventScreen : Destinations("addEventScreen")

}