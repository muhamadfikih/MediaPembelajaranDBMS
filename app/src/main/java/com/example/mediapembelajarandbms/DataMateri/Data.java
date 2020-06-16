package com.example.mediapembelajarandbms.DataMateri;

import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class Data {

    public static int[] screenMateri = {
            R.drawable.materi1,
            R.drawable.materi2,
            R.drawable.materi3,
            R.drawable.materi4,
            R.drawable.materi5,
            R.drawable.materi6,
            R.drawable.materi7,
            R.drawable.materi8,
            R.drawable.materi9,
            R.drawable.materi10,
            R.drawable.materi11,
            R.drawable.materi12
    };

    public static int[] JudulMateri = {
            R.string.pertemuan1,
            R.string.pertemuan2,
            R.string.pertemuan3,
            R.string.pertemuan4,
            R.string.pertemuan5,
            R.string.pertemuan6,
            R.string.pertemuan7,
            R.string.pertemuan8,
            R.string.pertemuan9,
            R.string.pertemuan10,
            R.string.pertemuan11,
            R.string.pertemuan12
    };

    public static ArrayList<ItemData> getListData() {
        ArrayList<ItemData> list = new ArrayList<>();
        for (int position = 0; position < JudulMateri.length; position++) {
            ItemData data = new ItemData();
            data.setFoto(screenMateri[position]);
            data.setJudul(JudulMateri[position]);
            list.add(data);
        }
        return list;
    }
}
