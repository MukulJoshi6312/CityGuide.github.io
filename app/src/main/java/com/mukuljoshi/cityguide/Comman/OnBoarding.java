package com.mukuljoshi.cityguide.Comman;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.mukuljoshi.cityguide.HelperClasses.SliderAdapter;
import com.mukuljoshi.cityguide.R;
import com.mukuljoshi.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    //Variable
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGateStarted;
    Animation animation;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_bording);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGateStarted = findViewById(R.id.get_started_btn);

        //call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);


        letsGateStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnBoarding.this,UserDashboard.class);
                startActivity(intent);
            }
        });

    }


    public void skip(View view){
        startActivity(new Intent(OnBoarding.this, UserDashboard.class));
        finish();
    }

    public  void next(View view){
        viewPager.setCurrentItem(currentPos + 1);

    }

    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos  = position;
            if (position == 0) {
                letsGateStarted.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                letsGateStarted.setVisibility(View.INVISIBLE);

            } else if (position == 2) {
                letsGateStarted.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                letsGateStarted.setAnimation(animation);
                letsGateStarted.setVisibility(View.VISIBLE);

            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}