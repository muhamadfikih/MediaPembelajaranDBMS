package com.example.mediapembelajarandbms.Video;

import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class VideoData {
    public static int[] LinkVideo = {
            R.string.link_pertemuan1,
            R.string.link_pertemuan2,
            R.string.link_pertemuan3,
            R.string.link_pertemuan4,
            R.string.link_pertemuan5,
            R.string.link_pertemuan6,
            R.string.link_pertemuan9,
            R.string.link_pertemuan10,
            R.string.link_pertemuan11,
            R.string.link_pertemuan12,
            R.string.link_pertemuan13,
            R.string.link_pertemuan14
    };
    public static int[] JudulVideo = {
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

    public static ArrayList<ItemVideo> getListVideo() {
        ArrayList<ItemVideo> list = new ArrayList<>();
        for (int position = 0; position < JudulVideo.length; position++) {
            ItemVideo data = new ItemVideo();
            data.setLinkvideo(LinkVideo[position]);
            data.setJudulvideo(JudulVideo[position]);
            list.add(data);
        }
        return list;
    }
}

