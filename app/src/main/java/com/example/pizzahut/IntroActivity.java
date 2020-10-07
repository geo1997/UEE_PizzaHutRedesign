package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pizzahut.adapter.introSliderAdapter;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    Boolean firstTime;

    private ViewPager introPager;
    private LinearLayout dotLayout;
    private Button skipBtn;
    private introSliderAdapter introSliderAdapter;

    private  TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        View decorView=getWindow().getDecorView();
        int uiOptions=View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);


        introPager=findViewById(R.id.introViewPager);
        dotLayout=findViewById(R.id.dotLayout);
        skipBtn=findViewById(R.id.introButton);



        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homePage = new Intent(IntroActivity.this, homeActivity.class);
                startActivity(homePage);
                finish();
            }
        });

        sharedPreferences = getSharedPreferences("pizzaIntro", MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime", true);

        if (firstTime) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;

                   editor.putBoolean("firstTime", firstTime);
                    editor.apply();
                          introSliderAdapter=new introSliderAdapter(this);
                          introPager.setAdapter(introSliderAdapter);
                          addDotsIndicator(0);
                          introPager.addOnPageChangeListener(viewListener);

               }
       else {
           Intent homePage = new Intent(IntroActivity.this, homeActivity.class);
           startActivity(homePage);
            finish();
        }

    }

    public void addDotsIndicator(int position){
        dots=new TextView[4];
        dotLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.introDotTransWhite));

            dotLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            if (position==0){
                skipBtn.setEnabled(true);
                skipBtn.setText("Skip >>");
            }
            else if(position==dots.length-1){
                skipBtn.setEnabled(true);

                skipBtn.setText("Finish");
            }
            else {
                skipBtn.setEnabled(true);
                skipBtn.setText("Skip >>");
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View view) {

    }
}