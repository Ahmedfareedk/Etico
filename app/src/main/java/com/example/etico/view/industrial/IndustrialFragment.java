package com.example.etico.view.industrial;

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
import com.example.etico.viewmodel.IndustrialViewModel;

import java.util.List;

public class IndustrialFragment extends Fragment implements OnRecyclerViewITemCLickListener, Observer<List<TrackingModel>> {
    private RecyclerView cranesRecyclerView;
    private IndustrialCranesAdapter cranesAdapter;
    private View view;
    private IndustrialViewModel viewModel;

    public IndustrialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_industrial, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cranesRecyclerView = view.findViewById(R.id.industrial_cranes_recycler);
        cranesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(requireActivity()).get(IndustrialViewModel.class);
        viewModel.getAllIndustrialTrackingItems().observe(requireActivity(), this);
    }

    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_viewPagerFragment_to_wireRopeSpecificationsFragment);
    }

    @Override
    public void onChanged(List<TrackingModel> trackingModels) 
    {
        cranesAdapter = new IndustrialCranesAdapter(trackingModels, this);
        cranesRecyclerView.setAdapter(cranesAdapter);
        cranesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
       // getActivity().getViewModelStore().clear();
    }
}