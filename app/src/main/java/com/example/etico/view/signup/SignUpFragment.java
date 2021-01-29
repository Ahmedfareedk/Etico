package com.example.etico.view.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.etico.R;


public class SignUpFragment extends Fragment implements View.OnClickListener {

    private TextView alreadyhaveAcc;


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
        alreadyhaveAcc = view.findViewById(R.id.already_have_account_tv);
        alreadyhaveAcc.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_signInFragment);
        });

    }



    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.already_have_account_tv){

        }
    }
}