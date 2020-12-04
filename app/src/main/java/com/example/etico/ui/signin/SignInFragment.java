package com.example.etico.ui.signin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.etico.R;
import com.example.etico.utils.HandleDropDownTextView;
import com.google.android.material.button.MaterialButton;

public class SignInFragment extends Fragment implements View.OnClickListener{
    private AutoCompleteTextView signInAutoCompleteTV;
    private TextView skipTV, createAccTV;
    private View mainView;
    private MaterialButton button;


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
        skipTV = view.findViewById(R.id.skip_tv);
        createAccTV = view.findViewById(R.id.do_not_have_account_tv);
        button = view.findViewById(R.id.sign_in_button);
        skipTV.setOnClickListener(this);
        createAccTV.setOnClickListener(this);
        this.mainView = view;


        setUserTypeAutocompleteTextView();
    }


    private void setUserTypeAutocompleteTextView() {

        HandleDropDownTextView.buildDropDownMenu(getContext(), signInAutoCompleteTV,
                R.layout.user_type_item, getResources().getStringArray(R.array.user_types));
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.do_not_have_account_tv) {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment);
        } else if (id == R.id.skip_tv) {
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_wireRopeFragment);
        }
    }
}