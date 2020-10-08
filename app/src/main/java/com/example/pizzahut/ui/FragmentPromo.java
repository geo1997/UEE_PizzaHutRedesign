package com.example.pizzahut.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pizzahut.R;
import com.example.pizzahut.adapter.Promo;
import com.example.pizzahut.model.PromoItem;

import java.util.ArrayList;


public class FragmentPromo extends Fragment {

    RecyclerView promos;
    ArrayList<PromoItem> promosList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_promo, container, false);



        promos=root.findViewById(R.id.promosList);


        promosList=new ArrayList<>();
        promosList.add(new PromoItem(4,R.drawable.new_offer4,
                "This offer contains two classic/signature large pan pizzas with two appetizers for Rs.3800.From this offer you can save upto Rs.1000. You can choose the type of pizzas given option below"));
        promosList.add(new PromoItem(5,R.drawable.new_offer5,
                "Get two classic/signature personal pan pizzas for Rs.800.From this offer you can save upto Rs.340.You can choose the type of pizzas given option below"));
        promosList.add(new PromoItem(7,R.drawable.new_offer7,
                "This offer contains one personal pan pizza for your child with appetizers. You can choose the type of pizzas given option below"));
        promosList.add(new PromoItem(8,R.drawable.new_offer8,
                "This offer contains meals for 8 person for reasonable price . You can choose the type of pizzas given option below"));

        promosList.add(new PromoItem(1,R.drawable.most_pop_deal1,
                "This offer contains meals for 8 person for reasonable price best thing is you get two large pizzas. You can choose the type of pizzas given option below"));
        promosList.add(new PromoItem(2,R.drawable.most_pop_deal2,
                "Buy Large Pan pizza & get the opportunity to get another Large Pizza with 50% off. This order is valid until 31 st of August. Choose your pizza from the option below "));
        promosList.add(new PromoItem(3,R.drawable.most_pop_deal3,
                "This offer provides the opportunity to get personal pan pizza and 2 bottles of coke zero for free when you buy a Large pan pizza.Choose your pizza from the option below "));
        promosList.add(new PromoItem(4,R.drawable.most_pop_deal4,
                "This offer contains meals for 4 person with reasonable price of Rs.3000. You can choose the type of pizzas given option below"));
        promosList.add(new PromoItem(5,R.drawable.most_pop_deal5,
                "This online offer contains meals for 5 person with an unbelievable price Rs.2500. best thing is you get two medium pizzas with appetizers and jumbo coke. You can choose the type of pizzas given option below "));
        promosList.add(new PromoItem(6,R.drawable.most_pop_deal6,
                "You get Chicken sausage roll for free when you buy any type of personal pan pizza via online.You can choose the type of pizzas given option below"));
        promosList.add(new PromoItem(7,R.drawable.most_pop_deal7,
                "This offer mostly suitable for couples who like to have a best offer from the pizza hut. It's contains Large pan pizza with appetizers and 2 coke.You can choose the type of pizzas given option below"));

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager rLayoutManager=layoutManager;
        promos.setLayoutManager(rLayoutManager);
        Promo adapter=new Promo(getActivity(),promosList);
        promos.setAdapter(adapter);
        return root;
    }
}
