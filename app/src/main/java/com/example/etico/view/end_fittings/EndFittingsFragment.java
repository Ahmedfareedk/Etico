package com.example.etico.view.end_fittings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.etico.R;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;


public class EndFittingsFragment extends Fragment {


    public EndFittingsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shackle_hook, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout track  = view.findViewById(R.id.shackles_layout_buttons).findViewById(R.id.layout_track_wire_rope_root);
        HandleNavigationInMainScreenFragments.navigateTo(track, view, R.id.action_shackleHookFragment_to_endFittingItemsFragment);
       // track.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_shackleHookFragment_to_endFittingItemsFragment));
    }
}