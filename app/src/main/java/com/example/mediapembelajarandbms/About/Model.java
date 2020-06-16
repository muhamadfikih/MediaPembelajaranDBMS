package com.example.mediapembelajarandbms.About;

public class Model {
    private String namalengkap, umur, citacita, sekolah, instagram, whatsapp;
    private int fotoprofil;

    public Model(String namalengkap, String umur, String citacita, String sekolah, String instagram, String whatsapp, int fotoprofil) {
        this.namalengkap = namalengkap;
        this.umur = umur;
        this.citacita = citacita;
        this.sekolah = sekolah;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
        this.fotoprofil = fotoprofil;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getCitacita() {
        return citacita;
    }

    public void setCitacita(String citacita) {
        this.citacita = citacita;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public int getFotoprofil() {
        return fotoprofil;
    }

    public void setFotoprofil(int fotoprofil) {
        this.fotoprofil = fotoprofil;
    }
}
