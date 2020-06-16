package com.example.mediapembelajarandbms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditUser extends AppCompatActivity {
    EditText updtNPM, updtNAMA, updtEMAIL, updtPASSWORD, updtRTYPEPassword;
    RadioGroup updtradioPilih;
    RadioButton updtradioBtnGENDER;
    DatabaseReference database;
    Button buttonUpdate;
    private String Unpm, Unama, Uemail, Upassword, Ugender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        updtNPM = findViewById(R.id.updateNPM);
        updtNAMA = findViewById(R.id.updateName);
        updtEMAIL = findViewById(R.id.updateEmail);
        updtPASSWORD = findViewById(R.id.updatePassword);
        updtRTYPEPassword = findViewById(R.id.updateRetypePassword);
        updtradioPilih = findViewById(R.id.radioGroupGender);
        buttonUpdate = findViewById(R.id.btnUpdate);

        ActionBar title = getSupportActionBar();
        title.setTitle("Edit Profil");

        database = FirebaseDatabase.getInstance().getReference("Login");
        Unpm = getIntent().getStringExtra("npm");
        Unama = getIntent().getStringExtra("nama");
        Uemail = getIntent().getStringExtra("email");
        Upassword = getIntent().getStringExtra("password");
        Ugender = getIntent().getStringExtra("gender");

        updtNPM.setText(Unpm);
        updtEMAIL.setText(Uemail);
        updtNAMA.setText(Unama);
        updtPASSWORD.setText(Upassword);


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updte_npm = updtNPM.getText().toString();
                String updte_nama = updtNAMA.getText().toString();
                String updte_email = updtEMAIL.getText().toString();
                String updte_password = updtPASSWORD.getText().toString();
                String Rudpte_password = updtRTYPEPassword.getText().toString();
                int updte_gender = updtradioPilih.getCheckedRadioButtonId();
                updtradioBtnGENDER = findViewById(updte_gender);
                String updtGENDER = updtradioBtnGENDER.getText().toString();
                if (updte_npm.equals("")) {
                    updtNPM.setError("Tidak boleh kosong");
                    updtNPM.requestFocus();
                } else if (updte_nama.equals("")) {
                    updtNAMA.setError("Tidak boleh kosong");
                    updtNAMA.requestFocus();
                } else if (updte_email.equals("")) {
                    updtEMAIL.setError("Tidak boleh kosong");
                    updtEMAIL.requestFocus();
                } else if (updte_password.equals("")) {
                    updtPASSWORD.setError("Tidak boleh kosong");
                    updtPASSWORD.requestFocus();
                } else if (!Rudpte_password.equals(updte_password)) {
                    updtRTYPEPassword.setError("Password tidak sama");
                    updtRTYPEPassword.requestFocus();
                } else {
                    updateUser(new Items(updte_npm, updte_nama, updte_email, updte_password, updtGENDER), updte_npm);
                }
            }
        });
    }

    private void updateUser(final Items items, String npm) {
        database.child(npm).setValue(items).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                updtNPM.setText("");
                updtNAMA.setText("");
                updtEMAIL.setText("");
                updtPASSWORD.setText("");
                Toast.makeText(EditUser.this, "VideoData Berhasil Di Update", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditUser.this, MenuUtama.class)
                        .putExtra("npm", items.getNpm())
                        .putExtra("nama", items.getNama())
                        .putExtra("email", items.getEmail())
                        .putExtra("password", items.getPassword()));
            }
        });
    }
}