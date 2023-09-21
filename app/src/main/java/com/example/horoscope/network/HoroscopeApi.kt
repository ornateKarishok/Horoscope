package com.example.horoscope.network

import com.example.horoscope.model.Horoscope
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface HoroscopeApi {
    @Headers("Content-Type: application/json")
    @POST(".")
    suspend fun getHoroscope(@Body body: JsonObject): Response<Horoscope>
}