package com.matematik.emre4.a10admdamatematik

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.emre4.a10admdamatematik.R
import kotlinx.android.synthetic.main.activity_whatsapp_bilgi.*

class whatsappBilgi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp_bilgi)



        ee.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")     //herhangi bi sitenin domain adresi yardımı ile o hosting adresine ulaşmasına sağlıyor
            startActivity(intent)

        }
        e.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk")     //herhangi bi sitenin domain adresi yardımı ile o hosting adresine ulaşmasına sağlıyor
            startActivity(intent)

        }

    }
}
