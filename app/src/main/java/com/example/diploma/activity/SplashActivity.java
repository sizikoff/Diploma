package com.example.diploma.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.diploma.view.MainMenu;
import com.example.diploma.R;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {

    private RelativeLayout splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ImageView splashImage = findViewById(R.id.splashImage);
        splash = findViewById(R.id.splash);

        TextView splashLogoText = findViewById(R.id.splashLogoText);

        Calendar rightNow = Calendar.getInstance();
        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY);

        int colorTo;
        String text;
        if (currentHour >= 6 && currentHour < 12) {
            text = "Доброе утро";
            splashLogoText.setText(text);
            colorTo = ContextCompat.getColor(this, R.color.splash_morning);
            splash.setBackgroundColor(colorTo);
            splashImage.setImageResource(R.drawable.ic_ico_morning);
        } else if (currentHour >= 12 && currentHour < 18) {
            text = "Добрый день";
            splashLogoText.setText(text);
            colorTo = ContextCompat.getColor(this, R.color.splash_day);
            splash.setBackgroundColor(colorTo);
            splashImage.setImageResource(R.drawable.ic_ico_day);
        } else if (currentHour >= 18) {
            text = "Добрый вечер";
            splashLogoText.setText(text);
            colorTo = ContextCompat.getColor(this, R.color.splash_evening);
            splash.setBackgroundColor(colorTo);
            splashImage.setImageResource(R.drawable.ic_ico_evening);
        } else {
            text = "Доброй ночи";
            splashLogoText.setText(text);
            colorTo = ContextCompat.getColor(this, R.color.splash_night);
            splash.setBackgroundColor(colorTo);
            splashImage.setImageResource(R.drawable.ic_ico_night);
        }

        int duration = 2000;


        new Handler().postDelayed(() -> {

            ValueAnimator animator = ValueAnimator.ofInt(0, 100);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                    splashLogoText.setVisibility(View.GONE);


                }
            });
            animator.setDuration(duration);
            animator.start();

            // Анимация фона
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), ContextCompat.getColor(SplashActivity.this, R.color.splash_day), colorTo);
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    int color = (int) animator.getAnimatedValue();
                }
            });
            colorAnimation.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                    new Handler().postDelayed(() -> {
                        Intent intent = new Intent(SplashActivity.this, MainMenu.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                    }, 1000);
                }
            });
            colorAnimation.setDuration(duration);
            colorAnimation.start();

        }, 600);

    }

}