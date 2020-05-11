package com.silicon.hub.firepay;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.silicon.hub.firepay.Utils.Session;

public class SplashScreenActivity extends AppCompatActivity {

    Session session;
    ImageView firePayImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.LauncherTheme);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_screen);

        firePayImageView = findViewById(R.id.firepay_icon);

        // all this code is not running
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(firePayImageView, "scaleX", 1.0f, 4.5f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(firePayImageView, "scaleY", 1.0f, 4.5f);
        animatorX.setDuration(5000);
        animatorY.setDuration(5000);
        animatorX.setInterpolator(new OvershootInterpolator());
        animatorY.setInterpolator(new OvershootInterpolator());
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY);
        set.start();

        session = new Session(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToAppropriateScreen();
                finish();
            }
        }, 3000);
/*
        finish();
*/

    }

    private void goToAppropriateScreen() {
        if(session.isFirstTimeStatus()){
            Intent intent = new Intent(SplashScreenActivity.this, OnBoarding.class);
            startActivity(intent);
            session.setFirstTimeStatus(false); // I should probably move this line into the
            // OnBoardingActivity, and change it once the user clicks on any button there (Login or Sign up)
        }else if(session.isLoggedIn()){ // if the user is not logged in, open the log in screen
            Intent intent =  new Intent(SplashScreenActivity.this, HomeActivity.class);
            startActivity(intent);
        }else{// the only condition left is that user is logged in and this is not the first time of using the app
            Intent intent =  new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
