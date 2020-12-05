package com.example.etico.ui.sling;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.etico.R;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;


public class SLingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sling, container, false);

        LinearLayout track  = view.findViewById(R.id.sling_layout_buttons).findViewById(R.id.layout_track_wire_rope_root);
        HandleNavigationInMainScreenFragments.navigateTo(track, view, R.id.action_sLingFragment_to_detailedSlingsFragment);

        return view;
    }
}