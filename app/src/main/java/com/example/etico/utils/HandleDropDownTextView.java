package com.example.etico.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class HandleDropDownTextView {

    public static void buildDropDownMenu(Context context, AutoCompleteTextView textView, int textViewItemResourceId, String[] textViewEntitiesId){
       ArrayAdapter<String> adapter = new ArrayAdapter<>(context, textViewItemResourceId, textViewEntitiesId);
       textView.setAdapter(adapter);
       textView.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               textView.setEnabled(false);
           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               if(textView.isPerformingCompletion()){
                   textView.dismissDropDown();
                   textView.setEnabled(false);
               }
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });
    }
}
