package com.example.utsproject;

public class Berita {
    private String judul;
    private String deskripsi;
    private int gambar; // Tipe data int untuk ID drawable

    // Constructor
    public Berita(String judul, String deskripsi, int gambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    // Getter
    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getGambar() {
        return gambar;
    }
}