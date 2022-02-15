package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;

   private EditText user_field;
   private Button button;
   private TextView result;
   private ImageView photo;
   private LineChartView chart;
    private Object List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Выбери, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        user_field = findViewById(R.id.user_field);
        button = findViewById(R.id.button);
        photo = findViewById(R.id.photo);
        chart = findViewById(R.id.chart);


        setButtonListener();
        setUpChart();
    }

    public void setButtonListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerText = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, user_field.getText() + spinnerText, Toast.LENGTH_LONG).show();
                photo.setVisibility(View.INVISIBLE);

            }
        });
    }

    public void setUpChart(){
        Axis x = new Axis();
        ChartData a = chart.getChartData();
        a.setAxisXBottom(x);
        a.setAxisYLeft(x);
        List<PointValue> values = new ArrayList<PointValue>();
        values.add(new PointValue(0, 3));
        values.add(new PointValue(2, 2));
        values.add(new PointValue(2, 2));
        values.add(new PointValue(3, 3));
        ChartData chartData = chart.getChartData();
        LineChartData lineChartData = chart.getLineChartData();


        Line line = new Line(values).setColor(Color.GREEN).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        lineChartData.setLines(lines);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    }
