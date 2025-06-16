package com.example.weather_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.Domins.Hourly;
import com.example.weather_app.R;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.ViewHolder> {

    private ArrayList<Hourly> items;

    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_hourly, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.ViewHolder holder, int position) {
        Hourly item = items.get(position);
        holder.hourText.setText(item.getHour());
        holder.tempText.setText(item.getTemp() + "°");

        // Assuming drawable names match picPath
        int imageResId = holder.itemView.getContext().getResources()
                .getIdentifier(item.getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        holder.pic.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hourText, tempText;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hourText = itemView.findViewById(R.id.horly_text);
            tempText = itemView.findViewById(R.id.tempText);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
