package ru.solar.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {
    private final List<Sport> sportList;

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sportView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout,parent,false);
        return new SportsViewHolder(sportView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        Sport sportItem = sportList.get(position);
        holder.image_item.setImageResource(sportItem.getSportImage());
        holder.text_item.setText(sportItem.getSportName());
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public static class SportsViewHolder extends RecyclerView.ViewHolder{
        ImageView image_item;
        TextView text_item;
        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.itemImageView);
            text_item = itemView.findViewById(R.id.itemTextView);
        }
    }
}
