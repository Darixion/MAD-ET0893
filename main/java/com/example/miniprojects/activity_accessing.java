package com.example.miniprojects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.sp.mad_et0893_main.R;

public class activity_accessing extends AppCompatActivity {

    CardView bleeding;
    CardView fracture;
    CardView choking;
    CardView fainting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessing);

        bleeding = findViewById(R.id.bleeding);
        fracture = findViewById(R.id.fracture);
        choking = findViewById(R.id.choking);
        fainting = findViewById(R.id.fainting);

        bleeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_accessing.this, bleeding.class);
                startActivity(intent);
            }
        });
        fracture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_accessing.this, fracture.class);
                startActivity(intent);
            }
        });
        choking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_accessing.this, choking.class);
                startActivity(intent);
            }
        });
        fainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_accessing.this, fainting.class);
                startActivity(intent);
            }
        });
    }
}
