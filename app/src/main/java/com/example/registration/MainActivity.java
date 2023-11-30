package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final int REGISTRATION_REQUEST_CODE = 1;
    private final String LOGIN = "admin";
    private final String PASSWORD = "password";

    private String registeredLogin;
    private String registeredPassword;

    private Button loginButton;

    private String login;
    private String password;

    private String right;
    private String login_error;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            login = ((EditText) findViewById(R.id.login)).getText().toString();
            password = ((EditText) findViewById(R.id.password)).getText().toString();

            result = findViewById(R.id.answer);

            if ((login.equals(LOGIN) && password.equals(PASSWORD)) || (login.equals(registeredLogin) && password.equals(registeredPassword))) {
                startWelcomeActivity();
            } else {
                startUserRegistrationActivity();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTRATION_REQUEST_CODE && resultCode == RESULT_OK) {

            registeredLogin = data.getStringExtra("login");
            registeredPassword = data.getStringExtra("password");

            ((EditText) findViewById(R.id.login)).setText(registeredLogin);
            ((EditText) findViewById(R.id.password)).setText(registeredPassword);

            result = findViewById(R.id.answer);
            right = getString(R.string.answer_entrance);
            result.setText(right);
            result.setTextColor(Color.BLUE);
        }
    }

    private void startWelcomeActivity() {
        right = getString(R.string.right);
        result.setText(right);
        result.setTextColor(Color.GREEN);

        startActivity(new Intent(MainActivity.this, Welcome.class));
    }

    private void startUserRegistrationActivity() {
        login_error = getString(R.string.error_login);
        result.setText(login_error);
        result.setTextColor(Color.RED);

        ((EditText) findViewById(R.id.login)).setText("");
        ((EditText) findViewById(R.id.password)).setText("");

        Intent intent = new Intent(MainActivity.this, UserRegistration.class);
        startActivityForResult(intent, REGISTRATION_REQUEST_CODE);
    }
}
