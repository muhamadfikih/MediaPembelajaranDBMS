package com.example.mediapembelajarandbms.About;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;
import java.util.List;

public class About extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar title = getSupportActionBar();
        title.setTitle("About");

        models = new ArrayList<>();
        models.add(new Model("Muhamad Fikih Firdaus",
                "21 Tahun",
                "Ingin menjadi Android Developer",
                "Universitas Bina Insani",
                "@fikih20",
                "+6289658516981", R.drawable.fikih));
        models.add(new Model("Yunica Lintang Pratama",
                "21 Tahun",
                "Pengajar",
                "Universitas Bina Insani",
                "@yunica03",
                "+6289653832418", R.drawable.yunica));

        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.ViewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
        Integer[] colors_temp = {
                getResources().getColor(R.color.home),
                getResources().getColor(R.color.settings)
        };

        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
