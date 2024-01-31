package com.example.registration;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class UserRegistration extends AppCompatActivity {
    private static final String TAG = "MyApp";
    private final static String EMPTY = "";
    
    private TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);

        Button registrationButton = findViewById(R.id.registrationButton);

        registrationButton.setOnClickListener(view -> {

            String userLogin = ((EditText) findViewById(R.id.user_login)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.user_password)).getText().toString();

            result = findViewById(R.id.answer);

            if (userLogin.equals(EMPTY) || userPassword.equals(EMPTY)) {
                userRegisterError();
                clearingFields(R.id.user_login, R.id.user_password);
            } else {
                startMainActivity(userLogin, userPassword);
                clearingFields(R.id.user_login, R.id.user_password);
                Log.d(TAG, "### Switching to activity MainActivity with data retention UserRegistration ###");
            }
        });
    }

    private void userRegisterError() {
        String loginError = getString(R.string.error_login);
        result.setText(loginError);
        result.setTextColor(Color.RED);
    }

    private void startMainActivity(String userLogin, String userPassword) {
        String right = getString(R.string.right);
        result.setText(right);
        result.setTextColor(Color.GREEN);

        Intent resultIntent = new Intent(UserRegistration.this, MainActivity.class);
        resultIntent.putExtra("login", userLogin);
        resultIntent.putExtra("password", userPassword);

        setResult(RESULT_OK, resultIntent);
        finish();
    }

    protected void clearingFields(int login, int password) {
        ((EditText)findViewById(login)).setText(EMPTY);
        ((EditText)findViewById(password)).setText(EMPTY);
    }
}
