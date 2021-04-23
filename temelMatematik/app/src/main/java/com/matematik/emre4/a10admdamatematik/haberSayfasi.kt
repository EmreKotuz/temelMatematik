package com.matematik.emre4.a10admdamatematik

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.emre4.a10admdamatematik.R
import kotlinx.android.synthetic.main.activity_haber_sayfasi.*

class haberSayfasi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haber_sayfasi)
        webHaber.loadUrl("https://teknoek.com/")
    }
}
