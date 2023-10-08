package com.google.maps.android.compose.model

data class GDPData(
    val country: String,
    val growthRates: List<Float>
)

data class PopulationData(
    val seriesName: String,
    val seriesCode: String,
    val countryName: String,
    val countryCode: String,
    val years: Map<String, Int>
)