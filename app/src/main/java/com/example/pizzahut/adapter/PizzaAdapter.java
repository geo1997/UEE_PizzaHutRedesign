package com.example.pizzahut.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.pizzahut.R;
import com.example.pizzahut.model.PizzaModel;

import java.io.Serializable;
import java.util.ArrayList;

public class PizzaAdapter extends ArrayAdapter<PizzaModel> implements View.OnClickListener{

    private ArrayList<PizzaModel> dataSet;
    Context mContext;


    private static class ViewHolder {
        TextView textViewName, textViewSize, textViewPrice;

    }

    public PizzaAdapter(ArrayList<PizzaModel> data, Context context) {
        super(context, R.layout.menu_single_widget_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        PizzaModel dataModel=(PizzaModel) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final PizzaModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.menu_single_widget_layout, parent, false);
            viewHolder.textViewName = convertView.findViewById(R.id.tv_pizza);
            viewHolder.textViewSize = convertView.findViewById(R.id.tv_medium);
            viewHolder.textViewPrice =  convertView.findViewById(R.id.tv_price);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.textViewName.setText(dataModel.getPizzaName());
        viewHolder.textViewSize.setText(dataModel.getPizzaSize());
        viewHolder.textViewPrice.setText(dataModel.getPizzaPrize());


//        viewHolder.buttonApply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                singleApplyClick(dataModel);
//            }
//        });

        return convertView;
    }


//    private void singleApplyClick( BuyerModel dataModel){
//        Intent intent = new Intent(mContext, ConfirmOrderActivity.class);
//        intent.putExtra("userId",dataModel.getUser().getId());
//        intent.putExtra("buyerModel",(Serializable)dataModel);
//        mContext.startActivity(intent);
//    }
}
