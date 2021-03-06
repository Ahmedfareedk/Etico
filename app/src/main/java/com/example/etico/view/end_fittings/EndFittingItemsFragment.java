package com.example.etico.view.end_fittings;

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
import com.example.etico.viewmodel.EndFittingsViewModel;

import java.util.ArrayList;
import java.util.List;

public class EndFittingItemsFragment extends Fragment implements OnRecyclerViewITemCLickListener, Observer<List<TrackingModel>> {
    private RecyclerView endFittingsRecyclerView;
    private IndustrialCranesAdapter adapter;
    private View view;
    private EndFittingsViewModel viewModel;


    public EndFittingItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view =inflater.inflate(R.layout.fragment_end_fitting_items, container, false);

         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        endFittingsRecyclerView = view.findViewById(R.id.end_fittings_recycler_view);
        endFittingsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModel = new ViewModelProvider(requireActivity()).get(EndFittingsViewModel.class);
        viewModel.getAllEndFittingsData().observe(requireActivity(), this);


    }


    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_endFittingItemsFragment_to_endFittingDataSpecifications);
    }

    @Override
    public void onChanged(List<TrackingModel> trackingModels) {
        adapter = new IndustrialCranesAdapter(trackingModels, this);
        endFittingsRecyclerView.setAdapter(adapter);

    }
}