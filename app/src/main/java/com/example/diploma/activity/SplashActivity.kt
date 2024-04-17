package com.example.diploma.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.diploma.R
import com.example.diploma.view.main.MainMenu
import java.util.Calendar
import java.util.Calendar.HOUR_OF_DAY

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        val splashImage = findViewById<ImageView>(R.id.splashImage)
        val splash: RelativeLayout = findViewById(R.id.splash)

        val splashLogoText = findViewById<TextView>(R.id.splashLogoText)

        val rightNow = Calendar.getInstance()
        val currentHour = rightNow[HOUR_OF_DAY]

        val colorTo: Int
        val text: String

        when {
            currentHour in 6..11 -> {
                text = getString(R.string.good_morning)
                splashLogoText.text = text
                colorTo = ContextCompat.getColor(this, R.color.splash_morning)
                splash.setBackgroundColor(colorTo)
                splashImage.setImageResource(R.drawable.ic_ico_morning)
            }

            currentHour in 12..17 -> {
                text = getString(R.string.good_day)
                splashLogoText.text = text
                colorTo = ContextCompat.getColor(this, R.color.splash_day)
                splash.setBackgroundColor(colorTo)
                splashImage.setImageResource(R.drawable.ic_ico_day)
            }

            currentHour >= 18 -> {
                text = getString(R.string.good_evening)
                splashLogoText.text = text
                colorTo = ContextCompat.getColor(this, R.color.splash_evening)
                splash.setBackgroundColor(colorTo)
                splashImage.setImageResource(R.drawable.ic_ico_evening)
            }

            else -> {
                text = getString(R.string.good_night)
                splashLogoText.text = text
                colorTo = ContextCompat.getColor(this, R.color.splash_night)
                splash.setBackgroundColor(colorTo)
                splashImage.setImageResource(R.drawable.ic_ico_night)
            }
        }

        val duration = 2000L

        @Suppress("DEPRECATION")
        Handler().postDelayed({
            val animator = ValueAnimator.ofInt(0, 100)

            animator.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)

                    splashLogoText.visibility = View.GONE
                }
            })

            animator.setDuration(duration)
            animator.start()

            val colorAnimation = ValueAnimator.ofObject(
                ArgbEvaluator(),
                ContextCompat.getColor(
                    this@SplashActivity,
                    R.color.splash_day
                ),
                colorTo
            )

            colorAnimation.addUpdateListener { it.animatedValue as Int }

            colorAnimation.addListener(
                object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)

                        @Suppress("DEPRECATION")
                        Handler().postDelayed({
                            val intent = Intent(
                                this@SplashActivity,
                                MainMenu::class.java
                            )
                            startActivity(intent)
                            overridePendingTransition(0, 0)
                            finish()
                        }, 1000)
                    }
                })

            colorAnimation.setDuration(duration)
            colorAnimation.start()
        }, 600)
    }
}