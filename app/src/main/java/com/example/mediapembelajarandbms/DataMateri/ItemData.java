package com.example.mediapembelajarandbms.DataMateri;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemData implements Parcelable {
    public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
        @Override
        public ItemData createFromParcel(Parcel in) {
            return new ItemData(in);
        }

        @Override
        public ItemData[] newArray(int size) {
            return new ItemData[size];
        }
    };
    private String materi;
    private int foto, judul;

    public ItemData() {

    }

    protected ItemData(Parcel in) {
        materi = in.readString();
        foto = in.readInt();
        judul = in.readInt();
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getJudul() {
        return judul;
    }

    public void setJudul(int judul) {
        this.judul = judul;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(materi);
        dest.writeInt(foto);
        dest.writeInt(judul);
    }
}
