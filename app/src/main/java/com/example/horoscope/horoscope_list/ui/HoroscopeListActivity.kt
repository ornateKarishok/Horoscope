package com.example.horoscope.horoscope_list.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscope.R
import com.example.horoscope.databinding.ActivityHoroscopeListBinding
import com.example.horoscope.read_horoscope.ui.ReadHoroscopeActivity

class HoroscopeListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeListBinding
    private val intentKeyReadHoroscope = "READ_HOROSCOPE_ACTIVITY"

    private val listOfSignsImages = listOf(
        R.drawable._1aries,
        R.drawable._2taurus,
        R.drawable._3gemini,
        R.drawable._4cancer,
        R.drawable._5leo,
        R.drawable._6virgo,
        R.drawable._7libra,
        R.drawable._8scorpio,
        R.drawable._9sagittarius,
        R.drawable._10capricorn,
        R.drawable._11aquarius,
        R.drawable._12pisces,
    )
    private var horoscopeSignsAdapter = HoroscopeSignsAdapter(listOfSignsImages)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()
    }

    private fun prepareRecyclerView() {
        horoscopeSignsAdapter.setOnClickListener(object :
            HoroscopeSignsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val nextActivity =
                    Intent(this@HoroscopeListActivity, ReadHoroscopeActivity::class.java)
                nextActivity.putExtra(
                    intentKeyReadHoroscope,
                    getSignByPosition(position)
                )
                startActivity(nextActivity)
            }

        })
        binding.apply {
            gifList.apply {
                layoutManager = GridLayoutManager(this@HoroscopeListActivity, 2)
                adapter = horoscopeSignsAdapter
            }
        }
    }

    fun getSignByPosition(position: Int) =
        when (position) {
            0 -> "Aries"
            1 -> "Taurus"
            2 -> "Gemini"
            3 -> "Cancer"
            4 -> "Leo"
            5 -> "Virgo"
            6 -> "Libra"
            7 -> "Scorpio"
            8 -> "Sagittarius"
            9 -> "Capricorn"
            10 -> "Aquarius"
            11 -> "Pisces"
            else -> ""
        }
}