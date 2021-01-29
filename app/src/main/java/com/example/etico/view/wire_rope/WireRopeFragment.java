package com.example.etico.view.wire_rope;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.etico.R;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;

public class WireRopeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_wire_rope, container, false);

        LinearLayout track  = view.findViewById(R.id.layout_track_wire_rope_root);
        HandleNavigationInMainScreenFragments.navigateTo(track, view, R.id.action_wireRopeFragment_to_viewPagerFragment);

        return view;
    }
}