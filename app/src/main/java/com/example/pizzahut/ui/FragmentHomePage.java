package com.example.pizzahut.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pizzahut.R;
import com.example.pizzahut.adapter.Promo;
import com.example.pizzahut.model.PromoItem;

import java.util.ArrayList;
import java.util.List;


public class FragmentHomePage extends Fragment {

    RecyclerView recyclerView;
    ArrayList<PromoItem> promoList;
    Button btnMenu;
    ImageSlider promFlip;
    private static final String TAG="promoActivity";
    private long backPressedTime;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_page, container, false);

        btnMenu=root.findViewById(R.id.btnMenu);


        btnMenu.setOnClickListener((View.OnClickListener) getActivity());

        promFlip=root.findViewById(R.id.promFlip);

        List<SlideModel> newPromos=new ArrayList<>();
        newPromos.add(new SlideModel(R.drawable.new_offer4));
        newPromos.add(new SlideModel(R.drawable.new_offer5));
        newPromos.add(new SlideModel(R.drawable.new_offer7));
        newPromos.add(new SlideModel(R.drawable.new_offer8));

        promFlip.setImageList(newPromos,true);


        recyclerView=root.findViewById(R.id.promDeals);
        promoList=new ArrayList<>();

        promoList.add(new PromoItem(1,R.drawable.most_pop_deal1,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given option below"));
        promoList.add(new PromoItem(2,R.drawable.most_pop_deal2,
                "Buy Large Pan pizza & get the opportunity to get another Large Pizza with 50% off. This order is valid until 31 st of August. Choose your pizza from the option below "));
        promoList.add(new PromoItem(3,R.drawable.most_pop_deal3,
                "This offer provides the opportunity to get personal pan pizza and 2 bottles of coke zero for free when you buy a Large pan pizza.Choose your pizza from the option below "));
        promoList.add(new PromoItem(4,R.drawable.most_pop_deal4,
                "This offer contains meals for 4 person with reasonable price of Rs.3000. You can choose the type of pizzas given option below"));
        promoList.add(new PromoItem(4,R.drawable.most_pop_deal5,
                "This online offer contains meals for 5 person with an unbelievable price Rs.2500. best thing is you get two medium pizzas with appetizers and jumbo coke. You can choose the type of pizzas given option below "));
        promoList.add(new PromoItem(4,R.drawable.most_pop_deal6,
                "You get Chicken sausage roll for free when you buy any type of personal pan pizza via online.You can choose the type of pizzas given option below"));
        promoList.add(new PromoItem(4,R.drawable.most_pop_deal7,
                "This offer mostly suitable for couples who like to have a best offer from the pizza hut. It's contains Large pan pizza with appetizers and 2 coke.You can choose the type of pizzas given option below"));


        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager rLayoutManager=layoutManager;
        recyclerView.setLayoutManager(rLayoutManager);
        Promo adapter=new Promo(getContext(),promoList);
        recyclerView.setAdapter(adapter);

        return root;




    }

//
//    @Override
//    public void onBackPressed() {
//        if(backPressedTime+2000>System.currentTimeMillis()){
//            super.onBackPressed();
//        }else{
//            Toast.makeText(this,"Press back Again to exit",Toast.LENGTH_SHORT).show();
//        }
//        backPressedTime=System.currentTimeMillis();
//    }



}