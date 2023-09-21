package com.example.horoscope.menu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.horoscope.horoscope_list.ui.HoroscopeListActivity
import com.example.horoscope.menu.ui.MenuActivity

class MenuViewModel : ViewModel() {
    private val _eventNavigate = MutableLiveData<Class<*>>()
    val eventNavigate: LiveData<Class<*>> = _eventNavigate

    fun onStartGameButtonClick() {
        _eventNavigate.value = HoroscopeListActivity::class.java
    }

    fun onFinishGameButtonClick() {
        _eventNavigate.value = MenuActivity::class.java
    }
}