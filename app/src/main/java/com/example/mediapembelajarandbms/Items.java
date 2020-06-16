package com.example.mediapembelajarandbms;

public class Items {
    private String npm, nama, email, password, gender;

    public Items() {

    }

    public Items(String npm, String nama, String email, String password, String gender) {
        this.npm = npm;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return this.npm
                + " " + nama
                + " " + email
                + " " + password
                + " " + gender;
    }
}
