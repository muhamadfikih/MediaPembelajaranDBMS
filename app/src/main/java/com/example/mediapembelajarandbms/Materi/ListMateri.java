package com.example.mediapembelajarandbms.Materi;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediapembelajarandbms.Adapter.AdapterListMateri;
import com.example.mediapembelajarandbms.DataMateri.Data;
import com.example.mediapembelajarandbms.DataMateri.ItemData;
import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class ListMateri extends AppCompatActivity {
    private RecyclerView rv_Materi;
    private ArrayList<ItemData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi);
        ActionBar title = getSupportActionBar();
        title.setTitle("Materi");
        rv_Materi = findViewById(R.id.rv_materi);
        rv_Materi.setHasFixedSize(true);
        list.addAll(Data.getListData());
        tampilMateri();


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    private void tampilMateri() {
        rv_Materi.setLayoutManager(new LinearLayoutManager(this));
        AdapterListMateri adapterListMateri = new AdapterListMateri(list);
        rv_Materi.setAdapter(adapterListMateri);
    }
}
