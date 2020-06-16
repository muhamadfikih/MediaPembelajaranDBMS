package com.example.mediapembelajarandbms;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.mediapembelajarandbms.About.About;
import com.example.mediapembelajarandbms.Latihan.ListLatihan;
import com.example.mediapembelajarandbms.Materi.ListMateri;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MenuUtama extends AppCompatActivity implements View.OnClickListener {
    TextView txtUser, txtNpm;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    LinearLayout latihan, materi, about, videoMateri;
    CardView logout, ecampus, website;
    RelativeLayout Edit;
    CarouselView carouselView;
    int[] slide = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(slide[position]);
        }
    };
    private String sUser, sNpm, sEmail, sPassowrd, sGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_utama);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Login");

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(slide.length);
        carouselView.setImageListener(imageListener);

        txtUser = findViewById(R.id.username);
        txtNpm = findViewById(R.id.npm);
        Edit = findViewById(R.id.profil);
        latihan = findViewById(R.id.cvLatihan);
        materi = findViewById(R.id.cvMateri);
        about = findViewById(R.id.cvAbout);
        videoMateri = findViewById(R.id.cvVideo);
        logout = findViewById(R.id.cvLogout);
        ecampus = findViewById(R.id.cvEcampus);
        website = findViewById(R.id.cvWebsite);

        materi.setOnClickListener(this);
        latihan.setOnClickListener(this);
        Edit.setOnClickListener(this);
        logout.setOnClickListener(this);
        ecampus.setOnClickListener(this);
        website.setOnClickListener(this);
        videoMateri.setOnClickListener(this);
        about.setOnClickListener(this);

        sUser = getIntent().getStringExtra("nama");
        sNpm = getIntent().getStringExtra("npm");
        sEmail = getIntent().getStringExtra("email");
        sPassowrd = getIntent().getStringExtra("password");
        sGender = getIntent().getStringExtra("gender");
        txtUser.setText(sUser);
        txtNpm.setText(sNpm);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setIcon(R.drawable.ic_error);
        builder.setTitle("KELUAR!!");
        builder.setMessage("Yakin ingin keluar ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNeutralButton("Tidak jadi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvMateri:
                startActivity(new Intent(MenuUtama.this, ListMateri.class));
                break;
            case R.id.cvLatihan:
                startActivity(new Intent(MenuUtama.this, ListLatihan.class)
                        .putExtra("npm", sNpm)
                        .putExtra("nama", sUser));
                break;
            case R.id.cvAbout:
                startActivity(new Intent(MenuUtama.this, About.class));
                break;
            case R.id.cvVideo:
                startActivity(new Intent(MenuUtama.this, video.class));
                break;
            case R.id.cvLogout:
                startActivity(new Intent(MenuUtama.this, Login.class));
                break;
            case R.id.profil:
                startActivity(new Intent(MenuUtama.this, EditUser.class)
                        .putExtra("npm", sNpm)
                        .putExtra("nama", sUser)
                        .putExtra("email", sEmail)
                        .putExtra("password", sPassowrd)
                        .putExtra("gender", sGender));
                break;
            case R.id.cvEcampus:
                Uri ecampus = Uri.parse("https://ecampus.binainsani.ac.id/binainsani/");
                Intent ecampusIntent = new Intent(Intent.ACTION_VIEW, ecampus);
                startActivity(ecampusIntent);
                break;
            case R.id.cvWebsite:
                Uri webpage = Uri.parse("https://binainsani.ac.id/");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                break;
        }
    }
}
