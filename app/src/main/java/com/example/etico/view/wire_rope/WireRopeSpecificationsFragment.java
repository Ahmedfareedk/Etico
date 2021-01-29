package com.example.etico.view.wire_rope;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.example.etico.R;
import com.example.etico.utils.HandleDropDownTextView;


public class WireRopeSpecificationsFragment extends Fragment {


    private AutoCompleteTextView wireRopeLocationAutoTV;

    public WireRopeSpecificationsFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wire_rope_specifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wireRopeLocationAutoTV = view.findViewById(R.id.wire_rope_location_auto_tv);
        HandleDropDownTextView.buildDropDownMenu(getContext(), wireRopeLocationAutoTV, R.layout.user_type_item, getResources().getStringArray(R.array.wire_rope_locations));
    }
}