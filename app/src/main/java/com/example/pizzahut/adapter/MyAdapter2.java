package com.example.pizzahut.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pizzahut.FragmentEmail;
import com.example.pizzahut.FragmentPassword;
import com.example.pizzahut.FragmentPhone;
import com.example.pizzahut.specail.FirstFragment;
import com.example.pizzahut.specail.SecondFragment;
import com.example.pizzahut.specail.ThirdFragment;

public class MyAdapter2 extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter2(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentEmail firstFragment = new FragmentEmail();
                return firstFragment;
            case 1:
                FragmentPassword secondFragment = new FragmentPassword();
                return secondFragment;
            case 2:
                FragmentPhone thirdFragment = new FragmentPhone();
                return thirdFragment;
            default:
                return null;





        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}