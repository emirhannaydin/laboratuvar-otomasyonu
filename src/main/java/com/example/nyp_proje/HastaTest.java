package com.example.nyp_proje;



public class HastaTest {
    int id;
    String hasta_adi;
    String hasta_soyadi;
    String cinsiyet;
    String test_turu;
    String birim_adi;
    int deger;

    public HastaTest(int id, String hasta_adi, String hasta_soyadi, String cinsiyet, String test_turu, String birim_adi, int deger) {
        this.id = id;
        this.hasta_adi = hasta_adi;
        this.hasta_soyadi = hasta_soyadi;
        this.cinsiyet = cinsiyet;
        this.test_turu = test_turu;
        this.birim_adi = birim_adi;
        this.deger = deger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHasta_adi() {
        return hasta_adi;
    }

    public void setHasta_adi(String hasta_adi) {
        this.hasta_adi = hasta_adi;
    }

    public String getHasta_soyadi() {
        return hasta_soyadi;
    }

    public void setHasta_soyadi(String hasta_soyadi) {
        this.hasta_soyadi = hasta_soyadi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getTest_turu() {
        return test_turu;
    }

    public void setTest_turu(String test_turu) {
        this.test_turu = test_turu;
    }

    public String getBirim_adi() {
        return birim_adi;
    }

    public void setBirim_adi(String birim_adi) {
        this.birim_adi = birim_adi;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }
}
