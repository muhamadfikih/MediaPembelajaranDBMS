package com.example.mediapembelajarandbms.Materi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mediapembelajarandbms.R;
import com.github.barteksc.pdfviewer.PDFView;

public class DetailMateri extends AppCompatActivity {
    PDFView pdf_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);
        pdf_view = findViewById(R.id.PDF);
        Intent intent = getIntent();
        int code = intent.getIntExtra("requestMateri", 0);
        ActionBar title = getSupportActionBar();
        if (code == 0) {
            pdf_view.fromAsset("Pertemuan1.pdf").load();
            title.setTitle("Pertemuan 1");
        } else if (code == 1) {
            pdf_view.fromAsset("Pertemuan2.pdf").load();
            title.setTitle("Pertemuan 2");
        } else if (code == 2) {
            pdf_view.fromAsset("Pertemuan3.pdf").load();
            title.setTitle("Pertemuan 3");
        } else if (code == 3) {
            pdf_view.fromAsset("Pertemuan4.pdf").load();
            title.setTitle("Pertemuan 4");
        } else if (code == 4) {
            pdf_view.fromAsset("Pertemuan5.pdf").load();
            title.setTitle("Pertemuan 5");
        } else if (code == 5) {
            pdf_view.fromAsset("Pertemuan6.pdf").load();
            title.setTitle("Pertemuan 6");
        } else if (code == 6) {
            pdf_view.fromAsset("Pertemuan9.pdf").load();
            title.setTitle("Pertemuan 9");
        } else if (code == 7) {
            pdf_view.fromAsset("Pertemuan10.pdf").load();
            title.setTitle("Pertemuan 10");
        } else if (code == 8) {
            pdf_view.fromAsset("Pertemuan11.pdf").load();
            title.setTitle("Pertemuan 11");
        } else if (code == 9) {
            pdf_view.fromAsset("Pertemuan12.pdf").load();
            title.setTitle("Pertemuan 12");
        } else if (code == 10) {
            pdf_view.fromAsset("Pertemuan13.pdf").load();
            title.setTitle("Pertemuan 13");
        } else {
            pdf_view.fromAsset("Pertemuan14.pdf").load();
            title.setTitle("Pertemuan 14");
        }
    }
}
