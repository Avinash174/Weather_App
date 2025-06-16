package com.example.weather_app.Adapter;

import android.content.Context;
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

public class TommorowActivity extends RecyclerView.Adapter<TommorowActivity.ViewHolder> {

    private ArrayList<TommorrowDomain> items;
    private Context context;

    public TommorowActivity(ArrayList<TommorrowDomain> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public TommorowActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_tommorrow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TommorowActivity.ViewHolder holder, int position) {
        TommorrowDomain item = items.get(position);

        holder.dayText.setText(item.getDay());
        holder.statusText.setText(item.getStatus());
        holder.lowText.setText(String.valueOf(item.getMinTemp()));
        holder.highText.setText(String.valueOf(item.getMaxTemp()));

        int imageResId = context.getResources()
                .getIdentifier(item.getPicPath(), "drawable", context.getPackageName());
        holder.icon.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayText, statusText, lowText, highText;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayText = itemView.findViewById(R.id.dayTxt);
            statusText = itemView.findViewById(R.id.status_txt);
            lowText = itemView.findViewById(R.id.lowTxt);
            highText = itemView.findViewById(R.id.textView3);
            icon = itemView.findViewById(R.id.pic);
        }
    }
}
