package com.example.emre4.a10admdamatematik

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

import kotlinx.android.synthetic.main.activity_bolme.*
import kotlinx.android.synthetic.main.activity_koklu_sayilar.*

class bolme : AppCompatActivity() {
    private var mAdView: AdView? = null
    private lateinit var mInterstitialAd: InterstitialAd
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameIsInProgress = false
    private var mTimerMilliseconds = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bolme)

        bölmeGeceModu.setOnClickListener {
            if (bölmeGeceModu.isChecked){
                bolmeEkrann.setBackgroundColor(Color.parseColor("#6ADBC83D"))
                bölmeGeceModu.text="Gece modunu kapatmak için tıklayınız"
            }else{
                bolmeEkrann.setBackgroundColor(Color.WHITE)
                bölmeGeceModu.text="Gece Modu"
            }
        }

        MobileAds.initialize(this, "\n" + "ca-app-pub-6537190103014639~4549117005")
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)


        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/9426873312"

        mAdView!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        }
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this)

        // Create the InterstitialAd and set it up.
        mInterstitialAd = InterstitialAd(this).apply {
            adUnitId = com.example.emre4.a10admdamatematik.AD_UeNIT_eIDae
            adListener = (object : AdListener() {
                override fun onAdLoaded() {
                }

                override fun onAdFailedToLoad(errorCode: Int) {

                }

                override fun onAdClosed() {

                    startGame()
                    Toast.makeText(applicationContext, "Çok teşekkür ederiz", Toast.LENGTH_SHORT).show()
                    anaSayfaButton6.text = "Tekrar İzle"

                }
            })
        }

        // Create the "retry" button, which triggers an interstitial between game plays.
        anaSayfaButton6.setOnClickListener { showInterstitial() }


        // Kick off the first play of the "game."
        startGame()
    }


    // Create the game timer, which counts down to the end of the level
// and shows the "retry" button.
    private fun createTimer(milliseconds: Long) {
        mCountDownTimer?.cancel()

        mCountDownTimer = object : CountDownTimer(milliseconds, 50) {
            override fun onTick(millisUntilFinished: Long) {
                mTimerMilliseconds = millisUntilFinished
            }

            override fun onFinish() {
                mGameIsInProgress = false
            }
        }
    }

    // Show the ad if it's ready. Otherwise toast and restart the game.
    private fun showInterstitial() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()


        } else {
            Toast.makeText(this, "Lüten baglantınızı kontrol edip tekrar deneyiniz", Toast.LENGTH_SHORT).show()
            startGame()

        }
    }

    // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
    private fun startGame() {
        if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
            // Create an ad request. If you're running this on a physical device, check your logcat
            // to learn how to enable test ads for it. Look for a line like this one:
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            val adRequest = AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build()

            mInterstitialAd.loadAd(adRequest)


        }

        resumeGame(com.example.emre4.a10admdamatematik.GAME_LENeGTH_MeILLISECONDSae)
    }

    private fun resumeGame(milliseconds: Long) {
        // Create a new timer for the correct length and start it.
        mGameIsInProgress = true
        mTimerMilliseconds = milliseconds
        createTimer(milliseconds)
        mCountDownTimer?.start()
    }

    // Resume the game if it's in progress.
    public override fun onResume() {
        super.onResume()

        if (mGameIsInProgress) {
            resumeGame(mTimerMilliseconds)
        }
    }

    // Cancel the timer if the game is paused.
    public override fun onPause() {
        mCountDownTimer?.cancel()
        super.onPause()
    }

}
