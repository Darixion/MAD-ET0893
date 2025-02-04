package com.example.miniprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class bleeding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleeding);

        WebView webView = findViewById(R.id.webView);
        String video = "<iframe width="100%" height="100%" 
            src="https://www.youtube.com/embed/NxO5LvgqZe0?si=iO3qRnT6QSEbI_zc" 
            title="YouTube video player" 
            frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
            referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
    }
}
