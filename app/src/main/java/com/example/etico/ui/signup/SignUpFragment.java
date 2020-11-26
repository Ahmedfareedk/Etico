package com.example.etico.ui.signup;

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


public class SignUpFragment extends Fragment {
    private AutoCompleteTextView userTypeTextView;


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userTypeTextView = view.findViewById(R.id.sign_up_user_type_auto_complete_tv);

        setUserTypeAutocompleteTextView();
    }

    private void setUserTypeAutocompleteTextView() {

        HandleDropDownTextView.buildDropDownMenu(getContext(), userTypeTextView,
                R.layout.user_type_item, getResources().getStringArray(R.array.user_types));

    }
}