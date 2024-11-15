package com.example.myapplication_ejmplo.ui.Location

data class GoogleGeoResult(
    val results: List<Results>
)
data class Results(
    val geometry: Geometry,
    val formatted_address: String
)

data class Geometry(
    val location: Location
)

data class Location(
    val lat: Double,
    val lng: Double
)