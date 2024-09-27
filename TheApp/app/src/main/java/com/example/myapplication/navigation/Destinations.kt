package com.example.myapplication.navigation

sealed class Destinations (val route : String){

    data object HomeScreen : Destinations("homeScreen")
    data object EventScreen : Destinations("eventScreen")
    data object AddEventScreen : Destinations("addEventScreen")

}