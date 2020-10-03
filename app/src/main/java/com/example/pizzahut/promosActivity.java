package com.example.pizzahut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pizzahut.adapter.Promo;
import com.example.pizzahut.model.PromoItem;

import java.util.ArrayList;

public class promosActivity extends AppCompatActivity {

    RecyclerView promos;
    ArrayList<PromoItem> promosList;
    private static final String TAG = "promosActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promos);

        promos=findViewById(R.id.promosList);

        promosList=new ArrayList<>();

        promosList.add(new PromoItem(5,R.drawable.new_offer1,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promosList.add(new PromoItem(6,R.drawable.new_offer2,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promosList.add(new PromoItem(7,R.drawable.new_offer3,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));

        promosList.add(new PromoItem(1,R.drawable.most_pop_deal1,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promosList.add(new PromoItem(2,R.drawable.most_pop_deal2,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promosList.add(new PromoItem(3,R.drawable.most_pop_deal3,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));
        promosList.add(new PromoItem(4,R.drawable.most_pop_deal4,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given below"));

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rLayoutManager=layoutManager;
        promos.setLayoutManager(rLayoutManager);
        Promo adapter=new Promo(this,promosList);
        promos.setAdapter(adapter);



    }
}