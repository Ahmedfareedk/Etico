package com.example.etico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.etico.R;
import com.example.etico.model.Crane;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class IndustrialCranesAdapter extends RecyclerView.Adapter<IndustrialCranesAdapter.IndustrialCranesViewHolder> {
    private List<Crane> industrialCranesList;

    public IndustrialCranesAdapter(List<Crane> industrialCranesList) {
        this.industrialCranesList = industrialCranesList;
    }

    @NonNull
    @Override
    public IndustrialCranesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.industrial_crane_item, parent, false);

        return new IndustrialCranesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndustrialCranesViewHolder holder, int position) {
        holder.setCranesItems(industrialCranesList.get(position));
    }

    @Override
    public int getItemCount() {
        return industrialCranesList.size();
    }

    public class IndustrialCranesViewHolder extends RecyclerView.ViewHolder {
        private TextView craneTitle;
        private ImageView craneImage;

        private IndustrialCranesViewHolder(@NonNull View itemView) {
            super(itemView);
            craneTitle = itemView.findViewById(R.id.industrial_crane_title);
            craneImage = itemView.findViewById(R.id.industrial_crane_image_view);
            
            itemView.getRootView().setOnClickListener(v->{
                Toast.makeText(itemView.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            });
        }


        private void setCranesItems(Crane crane){
            craneTitle.setText(crane.getCraneTitle());
            craneImage.setImageResource(crane.getCraneImage());
        }
    }


}
