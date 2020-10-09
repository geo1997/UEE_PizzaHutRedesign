package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeliveryAddressActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSliit,btnAsap,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);

        btnSliit=findViewById(R.id.btnSliit);
        btnAsap=findViewById(R.id.btnasap);
        btnSave=findViewById(R.id.btnsave);

        btnSliit.setOnClickListener(this);
        btnAsap.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnSliit){
            btnSliit.setBackgroundResource(R.drawable.btn_sliit_select) ;
        }else if(view.getId()==R.id.btnasap){
            btnAsap.setBackgroundResource(R.drawable.btn_asap_select);
        }else if(view.getId()==R.id.btnsave){
            Toast.makeText(this,"Delivery Details Saved!", Toast.LENGTH_SHORT).show();
            Intent menePage=new Intent(this,MainActivity.class);
            startActivity(menePage);
            finish();
        }

    }
}