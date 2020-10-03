package com.example.pizzahut;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pizzahut.adapter.Promo;
import com.example.pizzahut.model.PromoItem;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    ArrayList<PromoItem> promoList;
    Button btnMenu,btnAcc;
    ImageSlider promFlip;
    private static final String TAG="promoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        View decorView=getWindow().getDecorView();
        int uiOption=View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOption);

        btnMenu=findViewById(R.id.btnMenu);
        btnAcc=findViewById(R.id.btnAccount);

        btnMenu.setOnClickListener(this);
        btnAcc.setOnClickListener(this);

        promFlip=findViewById(R.id.promFlip);

        List<SlideModel> newPromos=new ArrayList<>();
        newPromos.add(new SlideModel(R.drawable.new_offer1));
        newPromos.add(new SlideModel(R.drawable.new_offer2));
        newPromos.add(new SlideModel(R.drawable.new_offer3));

        promFlip.setImageList(newPromos,true);


        recyclerView=findViewById(R.id.promDeals);
        promoList=new ArrayList<>();

        promoList.add(new PromoItem(1,R.drawable.most_pop_deal1,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promoList.add(new PromoItem(2,R.drawable.most_pop_deal2,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promoList.add(new PromoItem(3,R.drawable.most_pop_deal3,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promoList.add(new PromoItem(4,R.drawable.most_pop_deal4,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rLayoutManager=layoutManager;
        recyclerView.setLayoutManager(rLayoutManager);
        Promo adapter=new Promo(this,promoList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnMenu){
           Intent menu=new Intent(this,MainActivity.class);
           startActivity(menu);
        }
        else if(view.getId()==R.id.btnAccount){
            Toast.makeText(this,"Account Clicked",Toast.LENGTH_SHORT).show();
        }

    }
}