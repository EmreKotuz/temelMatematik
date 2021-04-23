package com.example.emre4.a10admdamatematik

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.matematik.emre4.a10admdamatematik.basitEsitsizlik
import com.matematik.emre4.a10admdamatematik.kokluSayilar
import com.matematik.emre4.a10admdamatematik.whatsappBilgi
import kotlinx.android.synthetic.main.activity_kolay_matematik.*
import kotlinx.android.synthetic.main.activity_konular.*

class konular : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konular)

        whatsappTikla.setOnClickListener {
            var intent =Intent(this,whatsappBilgi::class.java)
            startActivity(intent)
        }

        /*whatsappTikla.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk"))
            startActivity(browserIntent)
        }*/
    temelKavramButton.setOnClickListener {
        var intent =Intent(this,sayiler::class.java)
        startActivity(intent)
    }
        basitButton.setOnClickListener {
            var intent=Intent(this,basitEsitsizlik::class.java)
            startActivity(intent)
        }
        rasyonel.setOnClickListener {
            var intent=Intent(this,com.example.emre4.a10admdamatematik.rasyonel::class.java)
            startActivity(intent)
        }
        koklu.setOnClickListener {
            var intent=Intent(this,kokluSayilar::class.java)
            startActivity(intent)
        }
        mutlak .setOnClickListener {
            var intent=Intent(this,mutlakdeger::class.java)
            startActivity(intent)

        }
        bölme.setOnClickListener {
            var intent=Intent(this,bolme::class.java)
            startActivity(intent)
        }
        oranButton.setOnClickListener {
            var intent=Intent(this,oranOranti::class.java)
            startActivity(intent)
        }
    }
}
