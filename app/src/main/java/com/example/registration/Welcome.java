package com.example.registration;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Welcome extends AppCompatActivity {
    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        button = findViewById(R.id.gos_button);

        button.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.gosuslugi.ru"));
            startActivity(intent);
        });
    }
}
