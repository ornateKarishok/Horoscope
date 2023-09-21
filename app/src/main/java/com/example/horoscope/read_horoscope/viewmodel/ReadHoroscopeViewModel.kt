package com.example.horoscope.read_horoscope.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.horoscope.model.Horoscope
import com.example.horoscope.read_horoscope.model.HoroscopeModel
import com.google.gson.JsonObject

class ReadHoroscopeViewModel(body: JsonObject) : ViewModel() {
    private var _horoscopeLiveData = HoroscopeModel().getHoroscope(body)
    var horoscopeLiveData: LiveData<Horoscope> = _horoscopeLiveData
}