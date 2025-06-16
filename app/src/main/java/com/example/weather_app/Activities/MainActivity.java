package com.example.weather_app.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.Adapter.HourlyAdapter;
import com.example.weather_app.Domins.Hourly;
import com.example.weather_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7daysBtn=findViewById(R.id.nextTxtBtn);
        next7daysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TommorowActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("10 AM", 20, "cloud"));
        items.add(new Hourly("11 AM", 21, "cloudy_2"));
        items.add(new Hourly("12 PM", 23, "cloudy_sunny"));
        items.add(new Hourly("1 PM", 24, "cloud"));
        items.add(new Hourly("2 PM", 25, "wind"));
        items.add(new Hourly("3 PM", 26, "storm_2"));
        items.add(new Hourly("4 PM", 27, "sun"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
}
