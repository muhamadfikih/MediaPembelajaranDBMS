package com.example.mediapembelajarandbms;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {
    TextView txtSignUp;
    EditText edtNPM, edtPWD;
    Button btnLOGIN;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        txtSignUp = findViewById(R.id.textSignup);
        edtNPM = findViewById(R.id.editNpm);
        edtPWD = findViewById(R.id.editPwd);
        btnLOGIN = findViewById(R.id.btnLogin);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Login");
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });
        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = null;
                String npm = edtNPM.getText().toString();
                try {
                    pwd = edtPWD.getText().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                login(npm, pwd);
            }
        });
    }

    private void login(final String npm, final String password) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(npm).exists()) {
                    if (!npm.isEmpty()) {
                        Items items;
                        items = dataSnapshot.child(npm).getValue(Items.class);
                        if (items.getPassword().equals(password)) {
                            Toast.makeText(Login.this, npm, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MenuUtama.class);
                            intent.putExtra("npm", items.getNpm());
                            intent.putExtra("nama", items.getNama());
                            intent.putExtra("email", items.getEmail());
                            intent.putExtra("password", items.getPassword());
                            startActivity(intent);
                        } else {
                            new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Password Salah!")
                                    .show();
                        }
                    } else {
                        edtNPM.setError("Isi terlebih dahulu");
                        edtPWD.setError("Isi terlebih dahulu");
                        Toast.makeText(Login.this, "Lengkapi terlebih dahulu", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    new SweetAlertDialog(Login.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("User Tidak Ditemukan!")
                            .setContentText("Kami tidak dapat menemukan user anda ...")
                            .setConfirmText("Ulangi")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();

                                }
                            })
                            .setCancelButton("Daftar", new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    startActivity(new Intent(Login.this, SignUp.class));
                                }
                            })
                            .show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setIcon(R.drawable.ic_error);
        builder.setTitle("KELUAR!!");
        builder.setMessage("Yakin ingin keluar ?");
        builder.setCancelable(false);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.show();
    }
}
