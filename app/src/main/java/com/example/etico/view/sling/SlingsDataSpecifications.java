package com.example.etico.view.sling;

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

import java.util.ArrayList;
import java.util.List;


public class SlingsDataSpecifications extends Fragment {
    private AutoCompleteTextView firstSlingEndFitting;
    private AutoCompleteTextView secondSlingEndFitting;
    private List<AutoCompleteTextView> endFittingDropdownTVs;
    public SlingsDataSpecifications() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_slings_data_specifications, container, false);
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstSlingEndFitting = view.findViewById(R.id.sling_first_end_fitting_auto_tv);
        secondSlingEndFitting = view.findViewById(R.id.sling_second_end_fitting_auto_tv);

        HandleDropDownTextView.buildDropDownMenu(getContext(), getDropdownTVs(), R.layout.user_type_item, getResources().getStringArray(R.array.sling_end_fitting_options));
    }


    //Filling the auto complete text views list
    private List<AutoCompleteTextView> getDropdownTVs(){
        endFittingDropdownTVs = new ArrayList<>();
        endFittingDropdownTVs.add(firstSlingEndFitting);
        endFittingDropdownTVs.add(secondSlingEndFitting);
        return endFittingDropdownTVs;
    }
}