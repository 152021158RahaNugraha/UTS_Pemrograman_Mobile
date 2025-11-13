package com.example.utsproject;

public class Kontak {
    private String nama;
    private String telepon;
    // Kita bisa tambahkan int fotoProfil; jika ingin fotonya beda-beda

    // Constructor
    public Kontak(String nama, String telepon) {
        this.nama = nama;
        this.telepon = telepon;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return telepon;
    }
}