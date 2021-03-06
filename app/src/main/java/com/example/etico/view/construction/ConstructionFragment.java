package com.example.etico.view.construction;

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
import android.widget.Toast;

import com.example.etico.R;
import com.example.etico.adapter.ConstructionAdapter;
import com.example.etico.callback.OnRecyclerViewITemCLickListener;
import com.example.etico.model.ConstructionModel;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;
import com.example.etico.viewmodel.ConstructionViewModel;


import java.util.List;


public class ConstructionFragment extends Fragment implements OnRecyclerViewITemCLickListener, Observer<List<ConstructionModel>> {
    private RecyclerView constructionRecyclerView;
    private View view;
    private ConstructionViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_construction, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        constructionRecyclerView = view.findViewById(R.id.main_construction_recycler_view);
        constructionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(requireActivity()).get(ConstructionViewModel.class);

        viewModel.getAllConstructionTrackingItems().observe(requireActivity(), this);
    }


    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_viewPagerFragment_to_wireRopeSpecificationsFragment);
    }

    @Override
    public void onChanged(List<ConstructionModel> constructionModels) {
        ConstructionAdapter adapter = new ConstructionAdapter(constructionModels, ConstructionFragment.this);
        constructionRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}