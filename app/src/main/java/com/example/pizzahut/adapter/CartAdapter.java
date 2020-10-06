package com.example.pizzahut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzahut.R;
import com.example.pizzahut.model.CartItem;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    private Context pcontext;
    private ArrayList<CartItem> plist;

    public CartAdapter(Context context, ArrayList<CartItem> list){
        pcontext = context;
        plist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(pcontext);
        View view = layoutInflater.inflate(R.layout.cart_item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem cartItem = plist.get(position);
        ImageView image = holder.item_image;
        TextView title,price;

        title = holder.item_title;
        price = holder.item_price;

        image.setImageResource(cartItem.getImage());
        title.setText(cartItem.getTitle());
        price.setText(cartItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView item_image;
        TextView item_title,item_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.product_image);
            item_title = itemView.findViewById(R.id.product_title);
            item_price = itemView.findViewById(R.id.product_price);
        }
    }
}
