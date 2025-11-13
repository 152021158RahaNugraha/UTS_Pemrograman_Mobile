package com.example.utsproject;

public class CuacaPerJam {
    private String jam;
    private int iconCuaca; // ID drawable
    private String suhu;

    public CuacaPerJam(String jam, int iconCuaca, String suhu) {
        this.jam = jam;
        this.iconCuaca = iconCuaca;
        this.suhu = suhu;
    }

    // Getter
    public String getJam() {
        return jam;
    }

    public int getIconCuaca() {
        return iconCuaca;
    }

    public String getSuhu() {
        return suhu;
    }
}