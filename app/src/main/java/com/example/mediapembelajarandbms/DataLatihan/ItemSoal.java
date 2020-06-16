package com.example.mediapembelajarandbms.DataLatihan;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemSoal implements Parcelable {
    public static final Creator<ItemSoal> CREATOR = new Creator<ItemSoal>() {
        @Override
        public ItemSoal createFromParcel(Parcel in) {
            return new ItemSoal(in);
        }

        @Override
        public ItemSoal[] newArray(int size) {
            return new ItemSoal[size];
        }
    };
    private String txtSoal, txtNo, editTextValue;

    public ItemSoal() {

    }

    public ItemSoal(Parcel in) {
        txtSoal = in.readString();
        txtNo = in.readString();
        editTextValue = in.readString();
    }

    public String getTxtNo() {
        return txtNo;
    }

    public void setTxtNo(String txtNo) {
        this.txtNo = txtNo;
    }

    public String getTxtSoal() {
        return txtSoal;
    }

    public void setTxtSoal(String txtSoal) {
        this.txtSoal = txtSoal;
    }

    public String getEditTextValue() {
        return editTextValue;
    }

    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(txtSoal);
        dest.writeString(txtNo);
        dest.writeString(editTextValue);
    }
}
