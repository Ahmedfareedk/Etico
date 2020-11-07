package com.example.etico.ui.wire_rope;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.etico.R;

public class WireRopeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_wire_rope, container, false);

        LinearLayout track  = view.findViewById(R.id.layout_track_wire_rope_root);

        track.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_wireRopeFragment_to_navigation);
        });
        

        return view;
    }
}