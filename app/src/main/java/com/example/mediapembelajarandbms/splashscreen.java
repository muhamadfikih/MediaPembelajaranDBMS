package com.example.mediapembelajarandbms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {
    Button btnStart;
    TextView manualBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        btnStart = findViewById(R.id.start);
        manualBook = findViewById(R.id.manualbook);
        btnStart.setVisibility(View.INVISIBLE);
        manualBook.setVisibility(View.INVISIBLE);
        btnStart.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnStart.setVisibility(View.VISIBLE);
                manualBook.setVisibility(View.VISIBLE);
                if (!jikaConnect()) {
                    new AlertDialog.Builder(splashscreen.this)
                            .setTitle("ERROR!")
                            .setMessage("Mohon cek kembali koneksi anda")
                            .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                } else {
                    btnStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(splashscreen.this, Login.class));
                        }
                    });
                    manualBook.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(splashscreen.this, ManualBook.class));
                        }
                    });
                }
            }
        }, 4300);
    }

    public boolean jikaConnect() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }

}
