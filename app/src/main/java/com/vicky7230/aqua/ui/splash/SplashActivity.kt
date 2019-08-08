package com.vicky7230.aqua.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.vicky7230.aqua.R
import com.vicky7230.aqua.ui.home.HomeActivity


class SplashActivity : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()

        handler.postDelayed({
            startActivity(HomeActivity.getStartIntent(this@SplashActivity))
            finish()
        }, 1500)

    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
