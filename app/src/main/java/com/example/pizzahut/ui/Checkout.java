package com.example.pizzahut.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzahut.Cart;
import com.example.pizzahut.Payment;
import com.example.pizzahut.R;

public class Checkout extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_layout);

        TextView txtpaycont = (TextView)findViewById(R.id.payment_txt);
        txtpaycont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this, Payment.class));
            }
        });
    }
}
