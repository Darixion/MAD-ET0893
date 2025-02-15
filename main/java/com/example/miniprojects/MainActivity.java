package com.example.miniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button btnAcs, btnnrby, btnaddi;
    ImageView imagebleed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcs = findViewById(R.id.btn_acs);   // button accessing
        btnnrby = findViewById(R.id.btn_nrby); //button nearby hospitals/clinics
        btnaddi = findViewById(R.id.btn_addi); //button additional resources


        btnAcs.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, activity_accessing.class);
        startActivity(intent);



                }
            });


        btnaddi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_additionalresources.class);
                startActivity(intent);


    }
       });

        btnnrby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }
}