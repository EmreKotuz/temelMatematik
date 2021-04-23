package com.example.emre4.a10admdamatematik

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.matematik.emre4.a10admdamatematik.haberSayfasi
import kotlinx.android.synthetic.main.activity_kolay_matematik.*
import kotlinx.android.synthetic.main.activity_kullanici_giris.*
import java.util.*

val randommmm= arrayListOf(R.mipmap.matsayfa,R.mipmap.matsayfaa,R.mipmap.matsayfaaa,R.mipmap.matsayfaaaa)

class KolayMatematik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kolay_matematik)
        arkaPlanResim.setOnClickListener {
            val random = Random()
            val button = random.nextInt(randommmm.count())
            arkaPlanResim.setBackgroundResource(randommmm[button])
        }

        val random = Random()
        val button = random.nextInt(randommmm.count())
        arkaPlanResim.setBackgroundResource(randommmm[button])

   haber.setOnClickListener {
       val ıntent = Intent(applicationContext, haberSayfasi::class.java)
       startActivity(ıntent)
       Toast.makeText(this,"internet hızınıza göre 1-2 saniye gecikebilir..",Toast.LENGTH_SHORT).show()
   }

   konularaGiris.setOnClickListener {
       val ıntent = Intent(applicationContext, konular::class.java)
       startActivity(ıntent)
   }
}

    fun destekOl(view: View) {
        val ıntent = Intent(applicationContext, destek::class.java)
        startActivity(ıntent)
    }

}
