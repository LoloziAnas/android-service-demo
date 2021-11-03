package com.lzitech.servicesdemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart, buttonStop, buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // binding method
        bind();
        buttonStart.setOnClickListener(v -> {
            startService(new Intent(this, MyService.class));
        });
        buttonStop.setOnClickListener(v -> {
            stopService(new Intent(this, MyService.class));
        });
        buttonNext.setOnClickListener(v -> {
            Intent intent = new Intent(this, NextActivity.class);
            startActivity(intent);
        });

    }

    private void bind() {
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonNext = findViewById(R.id.buttonNext);
    }


}