package com.example.pizzahut.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzahut.R;
import com.example.pizzahut.model.PromoItem;
import com.example.pizzahut.promoDetailActivity;

import java.util.ArrayList;

public class Promo extends RecyclerView.Adapter<Promo.ViewHolder> {

    private Context mContext;
    private ArrayList<PromoItem> pList;
    private static final String TAG="Promo";

    public Promo(Context context, ArrayList<PromoItem> list){
        mContext=context;
        pList=list;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(mContext);

        View v=layoutInflater.inflate(R.layout.prom_card,parent,false);

        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder:Clicked ");

        final PromoItem promItem=pList.get(position);
        final ImageView promImg=holder.cardImage;

        holder.promDetails.setText(pList.get(position).getPromDetails());

        promImg.setImageResource(promItem.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, promoDetailActivity.class);
                intent.putExtra("promoImg",promItem.getImage());
                intent.putExtra("promoDe",promItem.getPromDetails());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return pList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cardImage;
        TextView promDetails;
        CardView parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage=itemView.findViewById(R.id.promImage);
            promDetails=itemView.findViewById(R.id.promDetails);
            parentLayout=itemView.findViewById(R.id.promCard);
        }


    }

}
