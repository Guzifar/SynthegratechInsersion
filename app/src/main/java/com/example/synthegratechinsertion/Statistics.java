package com.example.synthegratechinsertion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
    String name = "", email = "", type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            email = bundle.getString("email");
            type = bundle.getString("type");
        }
        BarChart barChart = findViewById(R.id.barChart);
        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<BarEntry> barDatas = new ArrayList<>();
        ArrayList<PieEntry> pieDatas = new ArrayList<>();

        for (int i=1; i<10; i++){
            float value = (float) (i*10.0);
            BarEntry barData = new BarEntry(i, value);
            barDatas.add(barData);
        }

        BarDataSet barDataSet = new BarDataSet(barDatas, "Expenses");
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));

        for (int i=1; i<10; i++){
            float value = (float) (i*10.0);
            PieEntry pieData = new PieEntry(i, value);
            pieDatas.add(pieData);
        }

        PieDataSet pieDataSet = new PieDataSet(pieDatas, "Expenses");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieDataSet.setDrawValues(false);
        pieChart.setData(new PieData(pieDataSet));

        ImageButton aButton = findViewById(R.id.accountButton);
        ImageButton hButton = findViewById(R.id.homeButton);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle.putString("name", name);
                bundle.putString("email", email);
                bundle.putString("type", type);
                Intent intent = new Intent(Statistics.this, Account.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle.putString("name", name);
                bundle.putString("email", email);
                bundle.putString("type", type);
                Intent intent = new Intent(Statistics.this, Dashboard.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}
