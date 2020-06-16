package com.example.mediapembelajarandbms;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class ManualBook extends AppCompatActivity {
    PDFView pdfManualBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_book);
        ActionBar title = getSupportActionBar();
        title.setTitle("Manual Book");
        pdfManualBook = findViewById(R.id.MANUALBOOK);
        pdfManualBook.fromAsset("manualbook.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ManualBook.this, splashscreen.class));
    }
}
