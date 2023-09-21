package com.example.horoscope.model

import com.google.gson.annotations.SerializedName

data class Horoscope(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("sign") val sign: String
)
