package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzahut.adapter.Promo;

public class promoDetailActivity extends AppCompatActivity implements View.OnClickListener {

    CardView option;
    Button addToCart;

    private static final String TAG="promoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        Log.d(TAG,"onCreate:promoActivity");
        getIncomingIntent();

        option=findViewById(R.id.btnPromoOption);
        addToCart=findViewById(R.id.btnAddToCart);

        option.setOnClickListener(this);
        addToCart.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnPromoOption){
            Toast.makeText(this,"Options Selected",Toast.LENGTH_SHORT).show();
        }
        if(view.getId()==R.id.btnAddToCart){
            Toast.makeText(this,"Item added to the Cart",Toast.LENGTH_SHORT).show();
        }

    }
}