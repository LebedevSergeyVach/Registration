package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String LOGIN = "admin";
    private String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {

            String login = ((EditText) findViewById(R.id.login)).getText().toString();
            String password = ((EditText) findViewById(R.id.password)).getText().toString();

            TextView result = findViewById(R.id.answer);

            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                String right = getString(R.string.right);
                result.setText(right);
                result.setTextColor(Color.GREEN);

                startActivity(new Intent(MainActivity.this, Welcome.class));
            } else {
                String login_error = getString(R.string.error_login);

                result.setText(login_error);
                result.setTextColor(Color.RED);

                ((EditText) findViewById(R.id.login)).setText("");
                ((EditText) findViewById(R.id.password)).setText("");

                startActivity(new Intent(MainActivity.this, UserRegistration.class));
            }
        });
    }
}