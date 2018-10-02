package com.myassistant.aldiros.coba_firebase.model;

public class bookingModel {
    public String user_id;
    public String menu;
    public String key_menu;
    public String nama;
    public String umur;
    public String image;

    public bookingModel() {
    }

    public bookingModel(String user_id, String menu, String key_menu, String nama, String umur, String image) {
        this.user_id = user_id;
        this.menu = menu;
        this.key_menu = key_menu;
        this.nama = nama;
        this.umur = umur;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getKey_menu() {
        return key_menu;
    }

    public void setKey_menu(String key_menu) {
        this.key_menu = key_menu;
    }
}
