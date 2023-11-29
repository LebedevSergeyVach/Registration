package com.example.registration;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class UserRegistration extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);

        Button registrationButton = findViewById(R.id.registrationButton);

        registrationButton.setOnClickListener(view -> {

            String userLogin = ((EditText) findViewById(R.id.user_login)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.user_password)).getText().toString();

            Intent resultIntent = new Intent(UserRegistration.this, MainActivity.class);
            resultIntent.putExtra("login", userLogin);
            resultIntent.putExtra("password", userPassword);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
