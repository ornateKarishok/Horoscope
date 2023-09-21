package com.example.horoscope.read_horoscope.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.horoscope.R
import com.example.horoscope.databinding.ActivityReadHoroscopeBinding
import com.example.horoscope.read_horoscope.viewmodel.ReadHoroscopeViewModel
import com.google.gson.JsonObject
import java.text.SimpleDateFormat
import java.util.*


class ReadHoroscopeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadHoroscopeBinding
    private lateinit var vmReadHoroscope: ReadHoroscopeViewModel
    private val intentKeyReadHoroscope = "READ_HOROSCOPE_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_read_horoscope)

        val jsonObject = JsonObject()
        val selectedSign = intent.getStringExtra(intentKeyReadHoroscope)
        jsonObject.addProperty("date", getCurrentDate())
        jsonObject.addProperty("lang", "en")
        jsonObject.addProperty("sign", selectedSign)

        vmReadHoroscope = ReadHoroscopeViewModel(jsonObject)
        binding.executePendingBindings()
        observe()
    }

    private fun observe() {
        vmReadHoroscope.horoscopeLiveData.observe(this) {
            binding.progressBarFl.visibility = View.GONE
            binding.horoscopeCv.visibility = View.VISIBLE
            binding.signTitle.text = vmReadHoroscope.horoscopeLiveData.value?.sign
            binding.signHoroscope.text = vmReadHoroscope.horoscopeLiveData.value?.horoscope
        }
    }

    private fun getCurrentDate(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        return formatter.format(date)
    }

}