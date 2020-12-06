package com.example.etico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.etico.R;
import com.example.etico.callback.OnRecyclerViewITemCLickListener;
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
    private OnRecyclerViewITemCLickListener listener;

    public ConstructionAdapter(List<ConstructionModel> constructionList, OnRecyclerViewITemCLickListener listener) {
        this.constructionList = constructionList;
        this.listener = listener;
    }

    public ConstructionAdapter(List<ConstructionModel> constructionList) {
        this.constructionList = constructionList;
    }

    @NonNull
    @Override
    public ConstructionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.construction_cranes_view_item, parent, false);

        return new ConstructionViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConstructionViewHolder holder, int position) {

        holder.setContent(constructionList.get(position), position);


    }

    @Override
    public int getItemCount() {
        return constructionList.size();
    }

    public class ConstructionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView categoeyTitleTV;
        private RecyclerView constructionRecyclerView;
        private OnRecyclerViewITemCLickListener vListener;

        private ConstructionViewHolder(@NonNull View itemView, OnRecyclerViewITemCLickListener listener)  {
            super(itemView);
            this.vListener = listener;
            categoeyTitleTV = itemView.findViewById(R.id.category_title_tv);
            constructionRecyclerView = itemView.findViewById(R.id.construction_item_recycler);
            itemView.setOnClickListener(this);
        }

        private void setContent(ConstructionModel model, int position) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            constructionRecyclerView.setLayoutManager(layoutManager);
            categoeyTitleTV.setText(model.getCraneCategory());
            layoutManager.setInitialPrefetchItemCount(model.getSubCategoryList().size());
            IndustrialCranesAdapter subCatAdapter = new IndustrialCranesAdapter(model.getSubCategoryList(), listener);
            constructionRecyclerView.setAdapter(subCatAdapter);
            constructionRecyclerView.setRecycledViewPool(viewPool);

        }

        @Override
        public void onClick(View view) {
            vListener.onItemClick(getAdapterPosition());
        }
    }
}


