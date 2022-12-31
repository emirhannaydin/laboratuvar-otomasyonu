package com.example.nyp_proje;

import java.sql.Date;

public class Hasta {
    int id;
    String hasta_adi;
    String hasta_soyadi;
    Date dogum_tarihi;
    String cinsiyet;
    int kilo;
    int boy;

    public Hasta(int id, String hasta_adi, String hasta_soyadi, Date dogum_tarihi, String cinsiyet, int kilo, int boy) {
        this.id = id;
        this.hasta_adi = hasta_adi;
        this.hasta_soyadi = hasta_soyadi;
        this.dogum_tarihi = dogum_tarihi;
        this.cinsiyet = cinsiyet;
        this.kilo = kilo;
        this.boy = boy;
    }

    public Hasta() {

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

    public Date  getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(Date  dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }
}
