package com.example.mediapembelajarandbms;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediapembelajarandbms.Adapter.AdapterListVideo;
import com.example.mediapembelajarandbms.DataMateri.Data;
import com.example.mediapembelajarandbms.DataMateri.ItemData;

import java.util.ArrayList;

public class video extends AppCompatActivity {
    private RecyclerView rv_Video;
    private ArrayList<ItemData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_video);
        ActionBar title = getSupportActionBar();
        title.setTitle("Video Materi");
        rv_Video = findViewById(R.id.rv_video);
        rv_Video.setHasFixedSize(true);
        list.addAll(Data.getListData());
        tampilVideo();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }

    private void tampilVideo() {
        rv_Video.setLayoutManager(new LinearLayoutManager(this));
        AdapterListVideo adapterListVideo = new AdapterListVideo(list);
        rv_Video.setAdapter(adapterListVideo);
    }
}
