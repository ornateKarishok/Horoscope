package com.example.horoscope.menu.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.horoscope.R
import com.example.horoscope.databinding.ActivityMenuBinding
import com.example.horoscope.horoscope_list.ui.HoroscopeListActivity
import com.example.horoscope.menu.viewmodel.MenuViewModel

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private var vmMenu: MenuViewModel = MenuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)

        binding.viewmodel = vmMenu
        binding.executePendingBindings()

        observe()
    }

    private fun observe() {
        vmMenu.eventNavigate.observe(this) { navigate ->
            if (HoroscopeListActivity::class.java == navigate) {
                val nextActivity = Intent(this, navigate)
                startActivity(nextActivity)
            } else
                if (MenuActivity::class.java == navigate) {
                    closeApp()
                }
        }
    }

    private fun closeApp() {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle(resources.getString(R.string.are_you_sure_you_want_to_exit))
            .setPositiveButton(resources.getString(R.string.yes)) { _, _ ->
                finish()
            }
            .setNegativeButton(
                resources.getString(R.string.no)
            ) { dialog, _ ->
                dialog.cancel()
            }
        builder.create()
        builder.show()
    }
}