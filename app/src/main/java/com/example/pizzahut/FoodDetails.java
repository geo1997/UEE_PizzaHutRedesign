package com.example.pizzahut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pizzahut.adapter.CartAdapter;
import com.example.pizzahut.ui.Checkout;

public class FoodDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_food_details);

        Button btncont = (Button)findViewById(R.id.cart_btn);
        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodDetails.this, MainActivity.class));
                Toast.makeText(FoodDetails.this, "Item added to cart", Toast.LENGTH_LONG).show();
            }
        });
    }
}
