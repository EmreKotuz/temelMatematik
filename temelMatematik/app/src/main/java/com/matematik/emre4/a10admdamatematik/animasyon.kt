package com.matematik.emre4.a10admdamatematik

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.emre4.a10admdamatematik.KolayMatematik
import com.example.emre4.a10admdamatematik.R
import kotlinx.android.synthetic.main.activity_animasyon.*

class animasyon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animasyon)


        val stt = AnimationUtils.loadAnimation(this, R.anim.an)

        val animation = AnimationUtils.loadAnimation(this, R.anim.an);
        val subtitle = findViewById(R.id.image) as ImageView
        image.startAnimation(animation)
        subtitle.startAnimation(stt)

        // yazi . startAnimation (ttb)
        //  subtitlee.startAnimation(ttb)


        object : CountDownTimer(3000, 3000) {
            override fun onFinish() {

                var intent = Intent(applicationContext, KolayMatematik::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)

            }
            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()
    }   }

