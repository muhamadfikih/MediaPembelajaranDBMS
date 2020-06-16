package com.example.mediapembelajarandbms.Video;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemVideo implements Parcelable {
    public static final Creator<ItemVideo> CREATOR = new Creator<ItemVideo>() {
        @Override
        public ItemVideo createFromParcel(Parcel in) {
            return new ItemVideo(in);
        }

        @Override
        public ItemVideo[] newArray(int size) {
            return new ItemVideo[size];
        }
    };
    private int judulvideo, linkvideo;

    public ItemVideo() {

    }

    protected ItemVideo(Parcel in) {
        judulvideo = in.readInt();
        linkvideo = in.readInt();
    }

    public int getJudulvideo() {
        return judulvideo;
    }

    public void setJudulvideo(int judulvideo) {
        this.judulvideo = judulvideo;
    }

    public int getLinkvideo() {
        return linkvideo;
    }

    public void setLinkvideo(int linkvideo) {
        this.linkvideo = linkvideo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(judulvideo);
        dest.writeInt(linkvideo);
    }
}
