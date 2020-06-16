package com.example.mediapembelajarandbms.About;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mediapembelajarandbms.R;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.item_about, container, false);

        ImageView Foto;
        TextView Nama_Lengkap, Umur, CitaCita, Sekolah, Instagram, Whatsapp;

        Foto = v.findViewById(R.id.gambar);
        Nama_Lengkap = v.findViewById(R.id.namaLengkap);
        Umur = v.findViewById(R.id.Umur);
        CitaCita = v.findViewById(R.id.citaCita);
        Sekolah = v.findViewById(R.id.sekolah);
        Instagram = v.findViewById(R.id.instagram);
        Whatsapp = v.findViewById(R.id.whatsapp);

        Foto.setImageResource(models.get(position).getFotoprofil());
        Nama_Lengkap.setText(models.get(position).getNamalengkap());
        Umur.setText(models.get(position).getUmur());
        CitaCita.setText(models.get(position).getCitacita());
        Sekolah.setText(models.get(position).getSekolah());
        Instagram.setText(models.get(position).getInstagram());
        Whatsapp.setText(models.get(position).getWhatsapp());
        container.addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
