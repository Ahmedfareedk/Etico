package com.example.etico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.etico.R;
import com.example.etico.model.ConstructionModel;

import androidx.annotation.NonNull;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ConstructionAdapter extends RecyclerView.Adapter<ConstructionAdapter.ConstructionViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<ConstructionModel> constructionList;

    public ConstructionAdapter(List<ConstructionModel> constructionList) {
        this.constructionList = constructionList;
    }

    @NonNull
    @Override
    public ConstructionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.construction_cranes_view_item, parent, false);

        return new ConstructionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConstructionViewHolder holder, int position) {

        holder.setContent(constructionList.get(position));

    }

    @Override
    public int getItemCount() {
        return constructionList.size();
    }

    public class ConstructionViewHolder extends RecyclerView.ViewHolder {
        private TextView categoeyTitleTV;
        private RecyclerView constructionRecyclerView;

        private ConstructionViewHolder(@NonNull View itemView) {
            super(itemView);
            categoeyTitleTV = itemView.findViewById(R.id.category_title_tv);
            constructionRecyclerView = itemView.findViewById(R.id.construction_item_recycler);
        }

        private void setContent(ConstructionModel model) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            constructionRecyclerView.setLayoutManager(layoutManager);
            categoeyTitleTV.setText(model.getCraneCategory());
            layoutManager.setInitialPrefetchItemCount(model.getSubCategoryList().size());
            IndustrialCranesAdapter subCatAdapter = new IndustrialCranesAdapter(model.getSubCategoryList());
            constructionRecyclerView.setAdapter(subCatAdapter);
            constructionRecyclerView.setRecycledViewPool(viewPool);

        }
    }
}


