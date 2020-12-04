package com.example.etico.ui.sling;

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

public class DetailedSlingsFragment extends Fragment {
    private RecyclerView detailedSlingsRecyclerView;
    private IndustrialCranesAdapter detailedSlingsAdapter;
    String[] slingsTitles;
    private TypedArray slingsImages;

    public DetailedSlingsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_slings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        slingsTitles = getResources().getStringArray(R.array.slings_titles);
        slingsImages = getResources().obtainTypedArray(R.array.sling_images);
        detailedSlingsRecyclerView = view.findViewById(R.id.slings_recycler_view);
        detailedSlingsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        detailedSlingsAdapter = new IndustrialCranesAdapter(fillSlingsList());
        detailedSlingsRecyclerView.setAdapter(detailedSlingsAdapter);

    }

    private List<Crane> fillSlingsList(){
        List<Crane> slingItemsList= new ArrayList<>();
        for(int i = 0 ; i<slingsTitles.length; i++){
            slingItemsList.add(i, new Crane(slingsTitles[i], slingsImages.getResourceId(i, -1)));
        }
        return slingItemsList;
    }
}