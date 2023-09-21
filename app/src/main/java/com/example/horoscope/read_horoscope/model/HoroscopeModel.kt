package com.example.horoscope.read_horoscope.model

import androidx.lifecycle.MutableLiveData
import com.example.horoscope.model.Horoscope
import com.example.horoscope.network.RetrofitInstance
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HoroscopeModel {

    fun getHoroscope(body: JsonObject): MutableLiveData<Horoscope> {
        val horoscopeLiveData = MutableLiveData<Horoscope>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.api.getHoroscope(body)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    horoscopeLiveData.value = response.body()
                }
            }
        }
        return horoscopeLiveData
    }

}