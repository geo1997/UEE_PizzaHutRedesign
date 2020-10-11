package com.example.pizzahut;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pizzahut.adapter.CartAdapter;
import com.example.pizzahut.model.CartItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import prihanofficial.com.kokis.logics.Kokis;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CartItem> cartItems;

    ImageView imageViewBack;
    Menu menuMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageViewBack = findViewById(R.id.backBtn);
        recyclerView = findViewById(R.id.cart_items_recyclerview);

        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("BBQ Chicken Pizza","Rs.1560",R.drawable.bbq_chicken));
        cartItems.add(new CartItem("Smoked Chicken Pizza","Rs.1200",R.drawable.smoked_chicken));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager1 = layoutManager;

        recyclerView.setLayoutManager(layoutManager1);

        CartAdapter adapter = new CartAdapter(this,cartItems);

        recyclerView.setAdapter(adapter);

        Button btncont = (Button)findViewById(R.id.cart_continue_btn);
        btncont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart.this, Checkout.class));
            }
        });


        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    public void onLayoutSelected(View view){
        LinearLayout linearLayout = findViewById(R.id.remove_item_button);
        Toast.makeText(this,"Item removed from cart",Toast.LENGTH_SHORT).show();

    }






}