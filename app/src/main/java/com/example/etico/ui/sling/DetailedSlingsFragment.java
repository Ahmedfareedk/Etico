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
import com.example.etico.callback.OnRecyclerViewITemCLickListener;
import com.example.etico.model.TrackingModel;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;

import java.util.ArrayList;
import java.util.List;

public class DetailedSlingsFragment extends Fragment implements OnRecyclerViewITemCLickListener {
    private RecyclerView detailedSlingsRecyclerView;
    private IndustrialCranesAdapter detailedSlingsAdapter;
    String[] slingsTitles;
    private View view;
    private TypedArray slingsImages;

    public DetailedSlingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view = inflater.inflate(R.layout.fragment_detailed_slings, container, false);

         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        slingsTitles = getResources().getStringArray(R.array.slings_titles);
        slingsImages = getResources().obtainTypedArray(R.array.sling_images);
        detailedSlingsRecyclerView = view.findViewById(R.id.slings_recycler_view);
        detailedSlingsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        detailedSlingsAdapter = new IndustrialCranesAdapter(fillSlingsList(), this);
        detailedSlingsRecyclerView.setAdapter(detailedSlingsAdapter);

    }

    private List<TrackingModel> fillSlingsList(){
        List<TrackingModel> slingItemsList= new ArrayList<>();
        for(int i = 0 ; i<slingsTitles.length; i++){
            slingItemsList.add(i, new TrackingModel(slingsTitles[i], slingsImages.getResourceId(i, -1)));
        }
        return slingItemsList;
    }

    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_detailedSlingsFragment_to_slingsDataSpecifications);
    }
}