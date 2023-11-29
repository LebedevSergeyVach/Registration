package com.example.registration;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserRegistration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {

            String userLogin = ((EditText) findViewById(R.id.user_login)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.user_password)).getText().toString();

            startActivity(new Intent(UserRegistration.this, MainActivity.class));
        });
    }
}