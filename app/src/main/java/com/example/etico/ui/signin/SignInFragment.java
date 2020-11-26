package com.example.etico.ui.signin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.etico.R;
import com.example.etico.utils.HandleDropDownTextView;

public class SignInFragment extends Fragment {
    private AutoCompleteTextView signInAutoCompleteTV;



    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInAutoCompleteTV = view.findViewById(R.id.sign_in_user_type_auto_complete_tv);
        setUserTypeAutocompleteTextView();
    }


    private void setUserTypeAutocompleteTextView() {

        HandleDropDownTextView.buildDropDownMenu(getContext(), signInAutoCompleteTV,
                R.layout.user_type_item, getResources().getStringArray(R.array.user_types));
    }
}