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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Context context;

    ArrayList<PizzaModel> dataModels;
    ListView listView;
    private static PizzaAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) root.findViewById(R.id.list);

        storeDataToList();
        setDataToList();

        return root;
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