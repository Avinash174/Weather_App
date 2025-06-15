package com.example.weather_app.Adapter; // Ensure this package matches your project structure

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather_app.R; // Ensure this R points to your project's resources

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.ViewHolder> {

    // Now accepting separate lists for each data point instead of a model class
    private ArrayList<String> hours;
    private ArrayList<String> temps;
    private ArrayList<String> picPaths;
    private Context context;

    public HourlyAdapter(ArrayList<String> hours, ArrayList<String> temps, ArrayList<String> picPaths) {
        this.hours = hours;
        this.temps = temps;
        this.picPaths = picPaths;
    }

    @NonNull
    @Override
    public HourlyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single hourly item
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly, parent, false);
        context = parent.getContext(); // Initialize context here
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.ViewHolder holder, int position) {
        // Retrieve data directly from the lists based on position
        String hour = hours.get(position);
        String temp = temps.get(position);
        String picName = picPaths.get(position);

        // Set hour and temperature text
        holder.hourTxt.setText(hour);
        holder.tempTxt.setText(temp);

        // Get the drawable resource ID from its name (e.g., "cloud", "sunny")
        int drawableResourceId = context.getResources().getIdentifier(
                picName, "drawable", context.getPackageName());

        // Check if the drawable resource was found
        if (drawableResourceId != 0) {
            holder.pic.setImageResource(drawableResourceId);
        } else {
            // Log an error and set a default image if the drawable is not found
            Log.e("HourlyAdapter", "Drawable not found for: " + picName);
            // Fallback to a default icon if the specified drawable is missing
            holder.pic.setImageResource(R.drawable.ic_launcher_foreground); // You should have a default_weather_icon.png or similar
        }
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        // All lists should have the same size, so we can pick any
        return hours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hourTxt, tempTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find views by their IDs from the viewholder_hourly.xml layout
            hourTxt = itemView.findViewById(R.id.horly_text);
            tempTxt = itemView.findViewById(R.id.tempText);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
