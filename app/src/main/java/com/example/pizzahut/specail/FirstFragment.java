package com.example.pizzahut.specail;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pizzahut.R;
import com.example.pizzahut.adapter.PizzaAdapter;
import com.example.pizzahut.model.PizzaModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    Context context;

    ArrayList<PizzaModel> dataModels;
    ListView listView;
    private static PizzaAdapter adapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.context = context;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        listView = (ListView) root.findViewById(R.id.list);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        storeDataToList();
        setDataToList();
    }

    private void storeDataToList() {

        dataModels = new ArrayList<>();
        for(int i =0 ; i<6 ;i++) {
            PizzaModel pizzaModel = new PizzaModel();

            pizzaModel.setPizzaName("Devilled Chicken");
            pizzaModel.setPizzaSize("Small");
            pizzaModel.setPizzaPrize("Rs.410");
            dataModels.add(pizzaModel);

        }

    }

    private void setDataToList() {
        adapter = new PizzaAdapter(dataModels, context);
        listView.setAdapter(adapter);
    }
}