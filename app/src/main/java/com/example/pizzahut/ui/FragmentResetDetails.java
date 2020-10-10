package com.example.pizzahut.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pizzahut.R;
import com.example.pizzahut.adapter.MyAdapter;
import com.example.pizzahut.adapter.MyAdapter2;
import com.example.pizzahut.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class FragmentResetDetails extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_reset_details, container, false);

//
//
//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(context,getChildFragmentManager());
//        ViewPager viewPager = root.findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = root.findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);


        tabLayout=  root.findViewById(R.id.tabLayout);
        viewPager= root.findViewById(R.id.viewPager);



        tabLayout.addTab(tabLayout.newTab().setText("Email"));
        tabLayout.addTab(tabLayout.newTab().setText("Password"));
        tabLayout.addTab(tabLayout.newTab().setText("Phone"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter2 adapter = new MyAdapter2(context,getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }
}