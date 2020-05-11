package com.silicon.hub.firepay;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.silicon.hub.firepay.Utils.Session;

public class OnBoarding extends AppCompatActivity {
    private ViewPager slideViewPager;
    private LinearLayout dotsLayout;

    private TextView[] dots;

    private SliderAdapter sliderAdapter;

    private Button buttonSignup;
    private Button buttonLogin;

    private int currentPage;

    Session session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        slideViewPager = findViewById(R.id.slideViewPager);
        dotsLayout = findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);

        buttonSignup = findViewById(R.id.Onboarding_button_signup);
        buttonLogin = findViewById(R.id.button_login);

        createDots(0);

        slideViewPager.addOnPageChangeListener(viewPagerListener);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnBoarding.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
//                if (currentPage == dots.length - 1){
//
//                }else {
//                    slideViewPager.setCurrentItem(currentPage + 1);
//                }
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*
                slideViewPager.setCurrentItem(currentPage - 1);*/
                Intent intent = new Intent(OnBoarding.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        session = new Session(this);
        //session.setFirstTimeStatus(false);

    }

    private void createDots(int position){
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotsLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            createDots(position);
            // implement next and back button
            currentPage = position;
//            if (currentPage == 0){
//                buttonLogin.setEnabled(true);
////                buttonSignup.setEnabled(false);
////                buttonSignup.setVisibility(View.INVISIBLE);
//
//                buttonLogin.setText("NEXT");
//                buttonSignup.setText("");
//            }else if(currentPage == dots.length - 1){
//                buttonLogin.setEnabled(true);
//                buttonSignup.setEnabled(true);
//                buttonSignup.setVisibility(View.VISIBLE);
//
//                buttonLogin.setText("FINISH");
//                buttonSignup.setText("BACK");
//            }else{
//                buttonLogin.setEnabled(true);
//                buttonSignup.setEnabled(true);
//                buttonSignup.setVisibility(View.VISIBLE);
//
//                buttonLogin.setText("NEXT");
//                buttonSignup.setText("BACK");
//            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
