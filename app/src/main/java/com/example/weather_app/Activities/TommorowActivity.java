package com.example.weather_app.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.Adapter.TommorrowAdapter;
import com.example.weather_app.Domins.TommorrowDomain;
import com.example.weather_app.R;

import java.util.ArrayList;

public class TommorowActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tommorow_activity);

        Log.d("TommorowActivity", "onCreate: started");

        initRecycleView();
        setVariable();
    }

    private void setVariable() {
        ImageView backBtn = findViewById(R.id.back_btn);
        if (backBtn != null) {
            backBtn.setOnClickListener(view -> {
                Log.d("TommorowActivity", "Back button clicked");
                startActivity(new Intent(TommorowActivity.this, MainActivity.class));
            });
        } else {
            Log.e("TommorowActivity", "back_btn is null! Check your XML ID.");
        }
    }

    private void initRecycleView() {
        ArrayList<TommorrowDomain> item = new ArrayList<>();
        item.add(new TommorrowDomain("Sunday", "cloud", "cloud", 25, 15));
        item.add(new TommorrowDomain("Monday", "storm", "storm", 25, 15));
        item.add(new TommorrowDomain("Tuesday", "cloud_2", "cloud_2", 25, 15));
        item.add(new TommorrowDomain("Wednesday", "cloud_sun", "cloud_sun", 25, 15));
        item.add(new TommorrowDomain("Thursday", "humidity", "humidity", 25, 15));
        item.add(new TommorrowDomain("Friday", "rainy", "rainy", 25, 15));
        item.add(new TommorrowDomain("Saturday", "sun", "sun", 25, 15));

        recyclerView = findViewById(R.id.view2);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            adapter = new TommorrowAdapter(item, this);
            recyclerView.setAdapter(adapter);
        } else {
            Log.e("TommorowActivity", "RecyclerView is null! Check view2 ID in XML.");
        }
    }
}
