package com.example.mediapembelajarandbms.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mediapembelajarandbms.R;

public class Tampil_Video extends AppCompatActivity {
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil__video);
        getSupportActionBar().hide();
        video = findViewById(R.id.videoView);
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(video);
        video.setMediaController(vidControl);
        Intent intent = getIntent();
        int code = intent.getIntExtra("requestCode", 0);
        if (code == 0) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Pertemuan%201.mp4?alt=media&token=057e4c04-44b5-49b1-ac9b-1196c0e9edcf";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 1) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Pertemuan%202.mp4?alt=media&token=6333e1cd-eac1-4bf7-a753-0e5fd3bab03c";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 2) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Pertemuan%203.mp4?alt=media&token=f8d4b979-dd8f-483b-b815-a85c3f66b66d";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 3) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Pertemuan%204.mp4?alt=media&token=bc53e0e0-2b4e-404e-8855-986b48de4390";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 4) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Pertemuan%205.mp4?alt=media&token=42d2fe2c-1541-4c3a-9d6f-c3c02ce0a4a8";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 5) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Pertemuan%206.mp4?alt=media&token=db9d1f9b-1d64-486e-a671-522354740fca";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 6) {//9
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Video9.mp4?alt=media&token=402e4315-05aa-4dcc-b0ee-bafd50a37a92";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 7) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/Video10.mp4?alt=media&token=72cf9e15-fa19-4d95-ad6c-5e7d8f1bab50";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 8) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/video11.mp4?alt=media&token=f1c7887d-eaf5-417b-a0fb-e3d6ec4976d4";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 9) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/video12.mp4?alt=media&token=13342f3c-d626-4c4a-8b73-c79833353cfc";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 10) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/video13.mp4?alt=media&token=a9a12d7f-91bc-4028-861c-f7b5d36558d4";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        } else if (code == 11) {
            String vidAddress = "https://firebasestorage.googleapis.com/v0/b/media-pembelajaran-dbms.appspot.com/o/video14.mp4?alt=media&token=5a686c50-0fc7-46e8-9012-c25e5f6fce01";
            Uri vidUri = Uri.parse(vidAddress);
            video.setVideoURI(vidUri);
            video.start();
        }
    }
}
