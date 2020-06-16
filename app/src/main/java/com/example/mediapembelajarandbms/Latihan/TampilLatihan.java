package com.example.mediapembelajarandbms.Latihan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediapembelajarandbms.Adapter.AdapterSoal;
import com.example.mediapembelajarandbms.DataLatihan.ItemSoal;
import com.example.mediapembelajarandbms.DataLatihan.KumpulanSoal;
import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class TampilLatihan extends AppCompatActivity {
    private static final int STORAGE_CODE = 100;
    AdapterSoal adapter;
    private String[] dataNomor;
    private RecyclerView rvSoal;
    private ArrayList<ItemSoal> list = new ArrayList<>();
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_latihan);
        rvSoal = findViewById(R.id.rv_soal);
        btnSave = findViewById(R.id.btnSave);
        adapter = new AdapterSoal(this, list);
        ActionBar title = getSupportActionBar();
        rvSoal.setHasFixedSize(true);
        Intent intent = getIntent();
        int code = intent.getIntExtra("requestCode", 0);
        if (code == 0) {
            list.addAll(KumpulanSoal.getPertanyaan1());
            Tampil();
            title.setTitle("Pertemuan 1");
        } else if (code == 1) {
            list.addAll(KumpulanSoal.getPertanyaan2());
            Tampil();
            title.setTitle("Pertemuan 2");
        } else if (code == 2) {
            list.addAll(KumpulanSoal.getPertanyaan3());
            Tampil();
            title.setTitle("Pertemuan 3");
        } else if (code == 3) {
            list.addAll(KumpulanSoal.getPertanyaan4());
            Tampil();
            title.setTitle("Pertemuan 4");
        } else if (code == 4) {
            list.addAll(KumpulanSoal.getPertanyaan5());
            Tampil();
            title.setTitle("Pertemuan 5");
        } else if (code == 5) {
            list.addAll(KumpulanSoal.getPertanyaan6());
            Tampil();
            title.setTitle("Pertemuan 6");
        } else if (code == 6) {
            list.addAll(KumpulanSoal.getPertanyaan7());
            Tampil();
            title.setTitle("Pertemuan 9");
        } else if (code == 7) {
            list.addAll(KumpulanSoal.getPertanyaan8());
            Tampil();
            title.setTitle("Pertemuan 10");
        } else if (code == 8) {
            list.addAll(KumpulanSoal.getPertanyaan9());
            Tampil();
            title.setTitle("Pertemuan 11");
        } else if (code == 9) {
            list.addAll(KumpulanSoal.getPertanyaan10());
            Tampil();
            title.setTitle("Pertemuan 12");
        } else if (code == 10) {
            list.addAll(KumpulanSoal.getPertanyaan11());
            Tampil();
            title.setTitle("Pertemuan 13");
        } else if (code == 11) {
            list.addAll(KumpulanSoal.getPertanyaan12());
            Tampil();
            title.setTitle("Pertemuan 14");
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemSoal item = new ItemSoal();
                startActivity(new Intent(TampilLatihan.this, next.class));
            }
        });
    }

    public void Tampil() {
        rvSoal.setLayoutManager(new LinearLayoutManager(this));
        AdapterSoal adapterSoal = new AdapterSoal(this, list);
        rvSoal.setAdapter(adapterSoal);

    }
}
