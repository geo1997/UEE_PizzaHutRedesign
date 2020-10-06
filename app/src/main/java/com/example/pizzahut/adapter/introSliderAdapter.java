package com.example.pizzahut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.pizzahut.R;

public class introSliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public introSliderAdapter(Context context) {
        this.context = context;
    }

    public int [] introImages={
            R.drawable.order_mobile,
            R.drawable.delivery_man,
            R.drawable.eat_pizza,
            R.drawable.pizza_round

    };

    public String [] introHedings={
            "Order",
            "Deliver",
            "Eat",
            "Have a Great Pizza!"
    };

    public String [] introDescription={
      "You can choose so many variations of pizzas and other products that made by pizza hut and order it from pizza hut mobile app whenever you want wherever you are at!",
      "As soon as you put your order, we will begin to prepare your pizza and deliver it to you by our ensured pizza delivery persons",
      "You can eat your pizzas as same hot as when you are in the pizza hut.",
            ""
    };

    @Override
    public int getCount() {
      return introHedings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.intro_slide_layout,container,false);

        ImageView image=view.findViewById(R.id.introImg);
        TextView topic=view.findViewById(R.id.txtDesT);
        TextView des=view.findViewById(R.id.txtDes);

        image.setImageResource(introImages[position]);
        topic.setText(introHedings[position]);
        des.setText(introDescription[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
