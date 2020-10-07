package com.example.pizzahut;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentDeliveryAddress extends Fragment implements View.OnClickListener {

    Button btnSliit,btnAsap,btnSave;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_delivery_address, container, false);

        btnSliit=root.findViewById(R.id.btnSliit);
        btnAsap=root.findViewById(R.id.btnasap);
        btnSave=root.findViewById(R.id.btnsave);

        btnSliit.setOnClickListener((View.OnClickListener) this);
        btnAsap.setOnClickListener((View.OnClickListener) this);
        btnSave.setOnClickListener((View.OnClickListener) this);


        return root;
    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnSliit){
            btnSliit.setBackgroundResource(R.drawable.btn_sliit_select) ;
        }else if(view.getId()==R.id.btnasap){
            btnAsap.setBackgroundResource(R.drawable.btn_asap_select);
        }else if(view.getId()==R.id.btnsave){
            Toast.makeText(getActivity(),"Delivery Details Saved!", Toast.LENGTH_SHORT).show();
            Intent menePage=new Intent(getActivity(),homeActivity.class);
            startActivity(menePage);

        }

    }

}