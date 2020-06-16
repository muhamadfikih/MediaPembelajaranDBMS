package com.example.mediapembelajarandbms.DataLatihan;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemDataLatihan implements Parcelable {

    public static final Creator<ItemDataLatihan> CREATOR = new Creator<ItemDataLatihan>() {
        @Override
        public ItemDataLatihan createFromParcel(Parcel in) {
            return new ItemDataLatihan(in);
        }

        @Override
        public ItemDataLatihan[] newArray(int size) {
            return new ItemDataLatihan[size];
        }
    };
    private int judul, foto;

    public ItemDataLatihan() {

    }

    protected ItemDataLatihan(Parcel in) {
        judul = in.readInt();
        foto = in.readInt();
    }

    public int getJudul() {
        return judul;
    }

    public void setJudul(int judul) {
        this.judul = judul;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(judul);
        dest.writeInt(foto);
    }
}
