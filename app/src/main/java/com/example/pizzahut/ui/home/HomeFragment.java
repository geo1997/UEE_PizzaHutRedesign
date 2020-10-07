package com.example.pizzahut.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pizzahut.R;
import com.example.pizzahut.adapter.MyAdapter;
import com.example.pizzahut.adapter.PizzaAdapter;
import com.example.pizzahut.model.PizzaModel;
import com.example.pizzahut.model.RecyclerViewDataAdapter;
import com.example.pizzahut.model.SectionDataModel;
import com.example.pizzahut.model.SingleItemModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Context context;

    ArrayList<PizzaModel> dataModels;
    ListView listView;
    private static PizzaAdapter adapter;

    ArrayList<SectionDataModel> allSampleData;

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        listView = (ListView) root.findViewById(R.id.list);
//
//        storeDataToList();
//        setDataToList();

//
//        allSampleData = new ArrayList<SectionDataModel>();
//
//        createDummyData();
//
//
//        RecyclerView my_recycler_view = (RecyclerView) root.findViewById(R.id.my_recycler_view);
//
//        my_recycler_view.setHasFixedSize(true);
//
//        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(context, allSampleData);
//
//        my_recycler_view.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//
//        my_recycler_view.setAdapter(adapter);

        //

        tabLayout=  root.findViewById(R.id.tabLayout);
        viewPager= root.findViewById(R.id.viewPager);








        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        tabLayout.addTab(tabLayout.newTab().setText("Appetizers"));
        tabLayout.addTab(tabLayout.newTab().setText("favorite"));
        tabLayout.addTab(tabLayout.newTab().setText("Deloitte Pizza"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(context,getChildFragmentManager(), tabLayout.getTabCount());
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
    }
}