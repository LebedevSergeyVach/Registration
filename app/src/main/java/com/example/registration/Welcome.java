package com.example.registration;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Welcome extends AppCompatActivity {
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button logautbutton = findViewById(R.id.logoutButton);

        logautbutton.setOnClickListener(view -> {
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

            Log.d(TAG, "### Switching to activity MainActivity.java ###");
        });

        Button gosButton = findViewById(R.id.gosButton);

        gosButton.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.gosuslugi.ru"));
            startActivity(intent);
        });
    }
}
