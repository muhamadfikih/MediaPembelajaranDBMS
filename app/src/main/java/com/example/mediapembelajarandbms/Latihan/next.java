package com.example.mediapembelajarandbms.Latihan;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mediapembelajarandbms.R;
import com.google.firebase.database.DatabaseReference;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.example.mediapembelajarandbms.Adapter.AdapterSoal.listSoal;

public class next extends AppCompatActivity {
    private static final int STORAGE_CODE = 100;
    TextView tv;
    Button simpan;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        tv = findViewById(R.id.tv);
        simpan = findViewById(R.id.SIMPAN);

        ActionBar title = getSupportActionBar();
        title.setTitle("Hasil");

        for (int i = 0; i < listSoal.size(); i++) {
            tv.setText(tv.getText() + " " + listSoal.get(i).getEditTextValue() + System.getProperty("line.separator"));
        }
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permission = {
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        };
                        requestPermissions(permission, STORAGE_CODE);
                    } else {
                        savePDF();
                    }
                } else {
                    savePDF();
                }
            }
        });
    }

    private void savePDF() {
        Document document = new Document();
        String mFileName = new SimpleDateFormat("yyyyMMdd ", Locale.getDefault()).format(System.currentTimeMillis());
        String mFilePath = Environment.getExternalStorageDirectory() + "/" + mFileName + ".pdf";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(mFilePath));
            document.open();
            String mText = tv.getText().toString();

            document.addAuthor("Muhamad Fikih");
            document.add(new Paragraph(mText));
            document.close();
            Toast.makeText(this, mFileName + ".pdf\nis saved to\n" + mFilePath, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(this, "Permission denied ...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
