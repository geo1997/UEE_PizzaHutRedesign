package com.example.pizzahut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_layout);

        TextView txtpaycont = (TextView)findViewById(R.id.payment_txt);
        Button btnCheckout = (Button)findViewById(R.id.button2);
        TextView txtpaycont11 = (TextView)findViewById(R.id.total_items5);

        txtpaycont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this, Payment.class));
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this, MainActivity.class));
                Toast.makeText(Checkout.this, "Payment Successfully Completed", Toast.LENGTH_LONG).show();
            }
        });

        txtpaycont11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this, FoodDetails.class));
                Toast.makeText(Checkout.this, "Payment Successfully Completed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
