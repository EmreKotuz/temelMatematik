package com.example.emre4.a10admdamatematik

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_destek.*

class destek : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destek)

        bitu.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.kotuz.mesajbulutu"))
            startActivity(browserIntent)
        }
        kimya.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.kotuzapp.tytkimya"))
            startActivity(browserIntent)
        }
    }

    fun instagram(view: View?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/kotuz.akademi/?hl=tr"))
        startActivity(browserIntent)
    }

    fun tytmat(view: View?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.matematik.emre4.tytmatematik"))
        startActivity(browserIntent)
    }

    fun tytcog(view: View?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.kotuzapp.tytcografya"))
        startActivity(browserIntent)
    }

    fun kendi(view: View?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.matematik.emre4.a10admdamatematik"))
        startActivity(browserIntent)
    }

}