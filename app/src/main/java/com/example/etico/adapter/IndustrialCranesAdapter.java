package com.example.etico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.etico.R;
import com.example.etico.callback.OnRecyclerViewITemCLickListener;
import com.example.etico.model.Crane;

import java.util.List;

public class IndustrialCranesAdapter extends RecyclerView.Adapter<IndustrialCranesAdapter.IndustrialCranesViewHolder> {
    private final List<Crane> industrialCranesList;
    private OnRecyclerViewITemCLickListener listener;



    public IndustrialCranesAdapter(List<Crane> industrialCranesList, OnRecyclerViewITemCLickListener listener) {
        this.industrialCranesList = industrialCranesList;
        this.listener = listener;
    }

    public IndustrialCranesAdapter(List<Crane> industrialCranesList) {
        this.industrialCranesList = industrialCranesList;
    }

    @NonNull
    @Override
    public IndustrialCranesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crane_item, parent, false);

        return new IndustrialCranesViewHolder(view, listener);
    }



    @Override
    public void onBindViewHolder(@NonNull IndustrialCranesViewHolder holder, int position) {
        holder.setCranesItems(industrialCranesList.get(position));
    }

    @Override
    public int getItemCount() {
        return industrialCranesList.size();
    }

    public class IndustrialCranesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView craneTitle;
        private ImageView craneImage;
        private OnRecyclerViewITemCLickListener vListener;

        private IndustrialCranesViewHolder(@NonNull View itemView, OnRecyclerViewITemCLickListener listener) {
            super(itemView);
            this.vListener = listener;
            craneTitle = itemView.findViewById(R.id.industrial_crane_title);
            craneImage = itemView.findViewById(R.id.industrial_crane_image_view);
            itemView.setOnClickListener(this);
        }
        private void setCranesItems(Crane crane){
            craneTitle.setText(crane.getCraneTitle());
            craneImage.setImageResource(crane.getCraneImage());
        }

        @Override
        public void onClick(View view) {
            vListener.onItemClick(getAdapterPosition());
        }
    }

}
