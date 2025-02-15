package com.example.miniprojects;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class activity_additionalresources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additionalresources);

        // Initialize TextViews inside onCreate
        TextView txtEmergency = findViewById(R.id.txt_emergency);
        TextView txtNonEmergency = findViewById(R.id.txt_non_emergency);

        // Set click listeners
        txtEmergency.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:995"));
            startActivity(intent);
        });

        txtNonEmergency.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + Uri.encode("1777"))); // Prevents formatting
            startActivity(intent);
        });

    }
}