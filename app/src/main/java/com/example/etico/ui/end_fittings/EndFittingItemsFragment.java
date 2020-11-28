package com.example.etico.ui.end_fittings;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etico.R;
import com.example.etico.adapter.IndustrialCranesAdapter;
import com.example.etico.model.Crane;

import java.util.ArrayList;
import java.util.List;

public class EndFittingItemsFragment extends Fragment {
    private RecyclerView endFittingsRecyclerView;
    private IndustrialCranesAdapter adapter;
    String[] endFittingsTitles;
    private TypedArray endFittingsImages;


    public EndFittingItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_end_fitting_items, container, false);

         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        endFittingsRecyclerView = view.findViewById(R.id.end_fittings_recycler_view);
        endFittingsTitles = getResources().getStringArray(R.array.end_fittings_titles);
        endFittingsImages = getResources().obtainTypedArray(R.array.end_fittings_images);

        adapter = new IndustrialCranesAdapter(fillEndFittingsList());
        endFittingsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        endFittingsRecyclerView.setAdapter(adapter);
    }

    private List<Crane> fillEndFittingsList(){
         List<Crane> endFittingItemsList= new ArrayList<>();
        for(int i = 0 ; i<endFittingsTitles.length; i++){
            endFittingItemsList.add(i, new Crane(endFittingsTitles[i], endFittingsImages.getResourceId(i, -1)));
        }
        return endFittingItemsList;
    }
}