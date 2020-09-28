package com.example.pizzahut.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzahut.R;
import com.example.pizzahut.model.CartItem;
import com.example.pizzahut.adapter.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    public CartFragment(){

    }

    private RecyclerView cartItemsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart, container, false);
        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(new CartItem(0,R.drawable.popularfood1,"Float Cake Vietnam",1,"Rs.1200/=","100",1,1,1));

        Cart cartAdapter = new Cart(cartItemList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        return view;
    }
}
