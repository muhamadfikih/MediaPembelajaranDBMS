package com.example.mediapembelajarandbms;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intent = getIntent();
        String loadUrl = intent.getStringExtra("Link");

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl(loadUrl);
    }
}
