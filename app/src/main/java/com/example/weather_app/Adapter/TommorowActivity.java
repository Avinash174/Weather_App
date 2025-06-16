package com.example.weather_app.Adapter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.Adapter.TommorrowAdapter;
import com.example.weather_app.Domins.TommorrowDomain;
import com.example.weather_app.R;

import java.util.ArrayList;

public class TommorowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TommorrowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tommorow_activity); // ✅ Fixed bracket

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<TommorrowDomain> items = new ArrayList<>();
        items.add(new TommorrowDomain("Monday", "cloud", 25, 18, "Cloudy"));
        items.add(new TommorrowDomain("Tuesday", "sun", 27, 19, "Sunny"));
        items.add(new TommorrowDomain("Wednesday", "rain", 22, 17, "Rainy"));

        adapter = new TommorrowAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}
