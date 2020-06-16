package com.example.mediapembelajarandbms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextView txtSignIn;
    EditText edtNPM, edtNAMA, edtEMAIL, edtPASSWORD, edtRTYPEPassword;
    RadioGroup radioPilih;
    RadioButton radioBtnGENDER;
    Button btnDaftar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        txtSignIn = findViewById(R.id.textSignIn);
        btnDaftar = findViewById(R.id.btnDaftar);
        edtNPM = findViewById(R.id.editNPM);
        edtNAMA = findViewById(R.id.editName);
        edtEMAIL = findViewById(R.id.editEmail);
        edtPASSWORD = findViewById(R.id.editPassword);
        edtRTYPEPassword = findViewById(R.id.editRetypePassword);
        radioPilih = findViewById(R.id.radioGroupGender);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Login");

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NPM = edtNPM.getText().toString();
                String NAMA = edtNAMA.getText().toString();
                String EMAIL = edtEMAIL.getText().toString();
                String PASSWORD = edtPASSWORD.getText().toString();
                String RETYPEPASSWORD = edtRTYPEPassword.getText().toString();
                int pilihGender = radioPilih.getCheckedRadioButtonId();
                radioBtnGENDER = findViewById(pilihGender);
                String GENDER = radioBtnGENDER.getText().toString();

                if (NPM.equals("")) {
                    edtNPM.setError("Tidak boleh kosong");
                    edtNPM.requestFocus();
                } else if (NAMA.equals("")) {
                    edtNAMA.setError("Tidak boleh kosong");
                    edtNAMA.requestFocus();
                } else if (EMAIL.equals("")) {
                    edtEMAIL.setError("Tidak boleh kosong");
                    edtEMAIL.requestFocus();
                } else if (PASSWORD.equals("")) {
                    edtPASSWORD.setError("Tidak boleh kosong");
                    edtPASSWORD.requestFocus();
                } else if (!RETYPEPASSWORD.equals(PASSWORD)) {
                    edtRTYPEPassword.setError("Password tidak sama");
                    edtRTYPEPassword.requestFocus();
                } else {
                    Items items = new Items(NPM, NAMA, EMAIL, PASSWORD, GENDER);
                    databaseReference.child(NPM).setValue(items).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            edtNPM.setText("");
                            edtNAMA.setText("");
                            edtEMAIL.setText("");
                            edtPASSWORD.setText("");
                            radioPilih.clearCheck();
                            edtRTYPEPassword.setText("");

                            Toast.makeText(SignUp.this, "Data Berhasil Di Tambahkan", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, Login.class));
                        }
                    });

                }
            }
        });
    }

    private void ClearText() {
        edtNPM.setText("");
        edtNAMA.setText("");
        edtEMAIL.setText("");
        edtPASSWORD.setText("");
        radioPilih.clearCheck();
        edtRTYPEPassword.setText("");
    }
}
