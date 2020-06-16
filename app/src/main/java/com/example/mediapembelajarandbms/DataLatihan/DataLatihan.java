package com.example.mediapembelajarandbms.DataLatihan;

import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class DataLatihan {

    public static int[] JudulLatihan = {
            R.string.latihan1,
            R.string.latihan2,
            R.string.latihan3,
            R.string.latihan4,
            R.string.latihan5,
            R.string.latihan6,
            R.string.latihan7,
            R.string.latihan8,
            R.string.latihan9,
            R.string.latihan10,
            R.string.latihan11,
            R.string.latihan12,
    };

    public static ArrayList<ItemDataLatihan> getListData() {
        ArrayList<ItemDataLatihan> list = new ArrayList<>();
        for (int position = 0; position < JudulLatihan.length; position++) {
            ItemDataLatihan data = new ItemDataLatihan();
            data.setJudul(JudulLatihan[position]);
            list.add(data);
        }
        return list;
    }
}
