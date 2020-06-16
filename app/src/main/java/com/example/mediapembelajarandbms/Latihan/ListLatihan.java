package com.example.mediapembelajarandbms.Latihan;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediapembelajarandbms.Adapter.AdapterListLatihan;
import com.example.mediapembelajarandbms.DataLatihan.DataLatihan;
import com.example.mediapembelajarandbms.DataLatihan.ItemDataLatihan;
import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class ListLatihan extends AppCompatActivity {
    private RecyclerView rv_Latihan;
    private ArrayList<ItemDataLatihan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_latihan);
        ActionBar title = getSupportActionBar();
        title.setTitle("Latihan");
        rv_Latihan = findViewById(R.id.rv_latihan);
        rv_Latihan.setHasFixedSize(true);
        list.addAll(DataLatihan.getListData());
        tampilLatihan();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    private void tampilLatihan() {
        rv_Latihan.setLayoutManager(new LinearLayoutManager(this));
        AdapterListLatihan adapterListLatihan = new AdapterListLatihan(list);
        rv_Latihan.setAdapter(adapterListLatihan);
    }
}
