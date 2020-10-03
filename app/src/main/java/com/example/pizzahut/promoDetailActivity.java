package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzahut.adapter.Promo;

public class promoDetailActivity extends AppCompatActivity {

    private static final String TAG="promoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        Log.d(TAG,"onCreate:promoActivity");
        getIncomingIntent();

    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: Checking for incoming intent ");
        if(getIntent().hasExtra("promoImg")&&getIntent().hasExtra("promoDe")){
            Log.d(TAG, getIntent().getStringExtra("promoDe"));

            int image=getIntent().getIntExtra("promoImg",0);
            String imageDe=getIntent().getStringExtra("promoDe");
            setImage(image,imageDe);
        }

    }
    private void setImage(int image,String promDetails){

        TextView details=findViewById(R.id.promDText);
        details.setText(promDetails);

        ImageView pro=findViewById(R.id.promDImg);
        pro.setImageResource(image);

    }
}