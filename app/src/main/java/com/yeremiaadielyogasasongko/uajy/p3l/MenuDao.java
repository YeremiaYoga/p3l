package com.yeremiaadielyogasasongko.uajy.p3l;

import com.google.gson.annotations.SerializedName;

public class MenuDao {

    @SerializedName("id")
    private String id;

    @SerializedName("nama_menu")
    private String nama_menu;

    @SerializedName("deskripsi_menu")
    private String deskripsi_menu;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("harga")
    private String harga;

    @SerializedName("hapus")
    private String hapus;

    @SerializedName("gambar")
    private String gambar;

    public MenuDao(String id, String nama_menu, String deskripsi_menu, String kategori, String harga, String hapus, String gambar) {
        this.id = id;
        this.nama_menu = nama_menu;
        this.deskripsi_menu = deskripsi_menu;
        this.kategori = kategori;
        this.harga = harga;
        this.hapus = hapus;
        this.gambar = gambar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getDeskripsi_menu() {
        return deskripsi_menu;
    }

    public void setDeskripsi_menu(String deskripsi_menu) {
        this.deskripsi_menu = deskripsi_menu;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getHapus() {
        return hapus;
    }

    public void setHapus(String hapus) {
        this.hapus = hapus;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
