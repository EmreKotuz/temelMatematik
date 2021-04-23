package com.example.emre4.a10admdamatematik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_kullanici_giris.*

class kullaniciGiris : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val ageFromPreferences: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kullanici_giris)

    }
}