package com.example.etico.view.sling;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.example.etico.viewmodel.SlingsViewModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedSlingsFragment extends Fragment implements OnRecyclerViewITemCLickListener, Observer<List<TrackingModel>> {
    private RecyclerView detailedSlingsRecyclerView;
    private IndustrialCranesAdapter detailedSlingsAdapter;
    private View view;
    private SlingsViewModel viewModel;

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
        detailedSlingsRecyclerView = view.findViewById(R.id.slings_recycler_view);
        detailedSlingsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModel = new ViewModelProvider(requireActivity()).get(SlingsViewModel.class);
        viewModel.getALlSlingsData().observe(requireActivity(), this);
    }


    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_detailedSlingsFragment_to_slingsDataSpecifications);
    }

    @Override
    public void onChanged(List<TrackingModel> trackingModels) {
        detailedSlingsAdapter = new IndustrialCranesAdapter(trackingModels, this);
        detailedSlingsRecyclerView.setAdapter(detailedSlingsAdapter);
    }
}