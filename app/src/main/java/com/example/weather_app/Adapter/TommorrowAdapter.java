package com.example.weather_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.Domins.TommorrowDomain;
import com.example.weather_app.R;

import java.util.ArrayList;

public class TommorrowAdapter extends RecyclerView.Adapter<TommorrowAdapter.ViewHolder> {

    private ArrayList<TommorrowDomain> items;

    public TommorrowAdapter(ArrayList<TommorrowDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_tommorrow, parent, false); // use correct layout name
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TommorrowAdapter.ViewHolder holder, int position) {
        TommorrowDomain item = items.get(position);

        holder.dayText.setText(item.getDay());
        holder.statusText.setText(item.getStatus());
        holder.tempText.setText(item.getMaxTemp() + "°/" + item.getMinTemp() + "°");

        int imageResId = holder.itemView.getContext().getResources()
                .getIdentifier(item.getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        holder.icon.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayText, statusText, tempText;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayText = itemView.findViewById(R.id.dayTxt);
            statusText = itemView.findViewById(R.id.status_txt);
            tempText = itemView.findViewById(R.id.lowTxt);
            icon = itemView.findViewById(R.id.pic);
        }
    }
}
