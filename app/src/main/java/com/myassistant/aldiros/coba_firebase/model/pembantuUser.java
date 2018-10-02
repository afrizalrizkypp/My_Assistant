package com.myassistant.aldiros.coba_firebase.model;

/**
 * Created by aldiros on 22/04/2018.
 */

public class pembantuUser {
    public String key_menu,  nama, umur, gaji, image, agama, alamat, phone, keterampilan, pengalaman, status, deskripsi;

    public pembantuUser() {
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKey_menu() {
        return key_menu;
    }

    public void setKey_menu(String key_menu) {
        this.key_menu = key_menu;
    }

    public String getKeterampilan() {
        return keterampilan;
    }

    public void setKeterampilan(String keterampilan) {
        this.keterampilan = keterampilan;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
