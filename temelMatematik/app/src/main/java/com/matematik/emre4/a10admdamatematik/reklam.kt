package com.matematik.emre4.a10admdamatematik

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.emre4.a10admdamatematik.BuildConfig
import com.example.emre4.a10admdamatematik.KolayMatematik
import com.example.emre4.a10admdamatematik.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem

import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener

import kotlinx.android.synthetic.main.activity_reklam2.*

class reklam : AppCompatActivity(), RewardedVideoAdListener {

    private lateinit var mRewardedVideoAd: RewardedVideoAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reklam2)



        MobileAds.initialize(this, "ca-app-pub-6537190103014639~4549117005")
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.rewardedVideoAdListener = this

            loadRewardedVideoAd()


    }

        private fun loadRewardedVideoAd() {
            mRewardedVideoAd.loadAd("ca-app-pub-6537190103014639/3660365681",
                    AdRequest.Builder().build())
        }


        override fun onRewarded(reward: RewardItem) {
            Toast.makeText(this, "onRewarded! currency: ${reward.type} amount: ${reward.amount}",
                    Toast.LENGTH_SHORT).show()


            // Reward the user.
        }

        override fun onRewardedVideoAdLeftApplication() {
            Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show()
        }


        override fun onRewardedVideoAdFailedToLoad(errorCode: Int) {
            Toast.makeText(this, "internetinizi kontrol ediniz.", Toast.LENGTH_SHORT).show()
            mRewardedVideoAd.show()


        }

        override fun onRewardedVideoAdLoaded() {
            Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show()

            mRewardedVideoAd.show()
            tiklaaa.text="noluyok mk"
            tiklaaa.setBackgroundColor(Color.YELLOW)

        }

        override fun onRewardedVideoAdOpened() {
            Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoStarted() {
            Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show()


        }

        override fun onRewardedVideoCompleted() {
            Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show()
        }

        override fun onRewardedVideoAdClosed() {
            loadRewardedVideoAd()
        }

    override fun onPause() {
        super.onPause()
        mRewardedVideoAd.pause(this)
    }

    override fun onResume() {
        super.onResume()
        mRewardedVideoAd.resume(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mRewardedVideoAd.destroy(this)


    }

}