package com.example.a1laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textfield = findViewById(R.id.textfield);
    }

    public void click_mainbutton(View view) {
        this.textfield.setText("Have a nice day!");
    }

    public void click_colorbutton(View view) {
        this.textfield.setTextColor(Color.RED);
    }
}