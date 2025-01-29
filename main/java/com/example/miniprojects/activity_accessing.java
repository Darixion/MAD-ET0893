package com.example.miniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class activity_accessing extends AppCompatActivity {

    ImageView imagebleed, imagefracture, imagechoking, imagefainting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessing);
        imagebleed = findViewById(R.id.image_bleed);

        imagebleed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_accessing.this, bleeding.class);
                startActivity(intent);
            }
        });
        imagefracture = findViewById(R.id.image_fracture);

        imagefracture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_accessing.this, fracture.class);
                startActivity(intent);
            }
        });
        imagechoking = findViewById(R.id.image_choking);

        imagechoking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_accessing.this, choking.class);
                startActivity(intent);
            }
        });
        imagefainting = findViewById(R.id.image_fainting);

        imagefainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_accessing.this, fainting.class);
                startActivity(intent);
            }
        });
    }
}