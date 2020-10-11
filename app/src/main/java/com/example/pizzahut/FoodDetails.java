package com.example.pizzahut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class FoodDetails extends AppCompatActivity {

    ImageView imageViewBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_food_details);

        Button btncont = (Button)findViewById(R.id.cart_btn);
        imageViewBack = findViewById(R.id.backBtn);
        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodDetails.this, MainActivity.class));
                Toast.makeText(FoodDetails.this, "Item added to cart", Toast.LENGTH_LONG).show();
            }
        });

        ImageView btncart = (ImageView) findViewById(R.id.cartBtn);
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodDetails.this, Cart.class));
            }
        });


        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void onSizeSelected(View view){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.smallpizza :
                Toast.makeText(this,"Small Pizza",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mediumpizza :
                Toast.makeText(this,"Medium Pizza",Toast.LENGTH_SHORT).show();
                break;
            case R.id.largepizza :
                Toast.makeText(this,"Large Pizza",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
