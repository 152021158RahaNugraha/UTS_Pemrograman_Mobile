package com.example.utsproject;

public class CuacaHarian {
    private String hari;
    private int iconCuaca; // ID drawable
    private String suhu;
    private String deskripsi;

    public CuacaHarian(String hari, int iconCuaca, String suhu, String deskripsi) {
        this.hari = hari;
        this.iconCuaca = iconCuaca;
        this.suhu = suhu;
        this.deskripsi = deskripsi;
    }

    // Getter
    public String getHari() {
        return hari;
    }

    public int getIconCuaca() {
        return iconCuaca;
    }

    public String getSuhu() {
        return suhu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}