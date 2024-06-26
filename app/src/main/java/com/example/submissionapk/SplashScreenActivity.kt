package com.example.submissionapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splashscreen)
        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3500)
    }
}