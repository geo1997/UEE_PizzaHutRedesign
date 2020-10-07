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

import com.example.pizzahut.R;
import com.example.pizzahut.adapter.PizzaAdapter;
import com.example.pizzahut.model.PizzaModel;
import com.example.pizzahut.model.RecyclerViewDataAdapter;
import com.example.pizzahut.model.SectionDataModel;
import com.example.pizzahut.model.SingleItemModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Context context;

    ArrayList<PizzaModel> dataModels;
    ListView listView;
    private static PizzaAdapter adapter;

    ArrayList<SectionDataModel> allSampleData;


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
        allSampleData = new ArrayList<SectionDataModel>();

        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView) root.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(context, allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

        //
        return root;
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }
    private void storeDataToList() {

        dataModels = new ArrayList<>();
        for(int i =0 ; i<20 ;i++){
           PizzaModel pizzaModel = new PizzaModel();
           pizzaModel.setPizzaName("Pizza with ginger");
           pizzaModel.setPizzaSize("Medium");
           pizzaModel.setPizzaPrize("24,90");

           dataModels.add(pizzaModel);
        }
    }

    private void setDataToList() {
        adapter = new PizzaAdapter(dataModels, context);
        listView.setAdapter(adapter);
    }
}