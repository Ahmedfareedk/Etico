package com.example.etico.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.List;

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
               textView.setEnabled(true);
           }
       });
    }

    public static void buildDropDownMenu(Context context, List<AutoCompleteTextView> textViews, int textViewItemResourceId, String[] textViewEntitiesId){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, textViewItemResourceId, textViewEntitiesId);

        for( int tvId = 0; tvId < textViews.size(); tvId++){
            textViews.get(tvId).setAdapter(adapter);
            int index = tvId;
            textViews.get(tvId).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    textViews.get(index).setEnabled(false);
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(textViews.get(index).isPerformingCompletion()){
                        textViews.get(index).dismissDropDown();
                        textViews.get(index).setEnabled(false);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                    textViews.get(index).setEnabled(true);
                }
            });
        }

    }
}
