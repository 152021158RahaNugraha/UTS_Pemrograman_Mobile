package com.example.utsproject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class KalkulatorFragment extends Fragment implements View.OnClickListener {

    // 1. Deklarasi View
    private TextView tvHasil;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnTambah, btnKurang, btnKali, btnBagi, btnEquals, btnClear;
    private Button btnKoma, btnPangkat, btnAkar;

    // 2. Variabel untuk logika kalkulator
    private String currentInput = ""; // Angka yang sedang diketik
    private String operator = ""; // Operator (+, -, *, /)
    private double angkaPertama = 0; // Angka pertama yang disimpan

    public KalkulatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kalkulator, container, false);

        // 3. Hubungkan View
        tvHasil = view.findViewById(R.id.tv_hasil);

        // Tombol Angka
        btn0 = view.findViewById(R.id.btn_0);
        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);
        btn4 = view.findViewById(R.id.btn_4);
        btn5 = view.findViewById(R.id.btn_5);
        btn6 = view.findViewById(R.id.btn_6);
        btn7 = view.findViewById(R.id.btn_7);
        btn8 = view.findViewById(R.id.btn_8);
        btn9 = view.findViewById(R.id.btn_9);

        // Tombol Operasi
        btnTambah = view.findViewById(R.id.btn_tambah);
        btnKurang = view.findViewById(R.id.btn_kurang);
        btnKali = view.findViewById(R.id.btn_kali);
        btnBagi = view.findViewById(R.id.btn_bagi);
        btnPangkat = view.findViewById(R.id.btn_pangkat);
        btnAkar = view.findViewById(R.id.btn_akar);
        btnKoma = view.findViewById(R.id.btn_koma);
        btnEquals = view.findViewById(R.id.btn_equals);
        btnClear = view.findViewById(R.id.btn_clear);

        // 4. Set OnClickListener
        // Kita gunakan 'this' karena Fragment ini sudah 'implements View.OnClickListener'
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnTambah.setOnClickListener(this);
        btnKurang.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
        btnPangkat.setOnClickListener(this);
        btnAkar.setOnClickListener(this);
        btnKoma.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        // Set tampilan awal
        updateTampilan("0");

        return view;
    }

    // 5. Method onClick yang akan menangani semua klik tombol
    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Tombol Angka (0-9)
        if (id == R.id.btn_0) onAngkaClick("0");
        else if (id == R.id.btn_1) onAngkaClick("1");
        else if (id == R.id.btn_2) onAngkaClick("2");
        else if (id == R.id.btn_3) onAngkaClick("3");
        else if (id == R.id.btn_4) onAngkaClick("4");
        else if (id == R.id.btn_5) onAngkaClick("5");
        else if (id == R.id.btn_6) onAngkaClick("6");
        else if (id == R.id.btn_7) onAngkaClick("7");
        else if (id == R.id.btn_8) onAngkaClick("8");
        else if (id == R.id.btn_9) onAngkaClick("9");
        else if (id == R.id.btn_koma) onAngkaClick(".");

            // Tombol Operator (+, -, *, /)
        else if (id == R.id.btn_tambah) onOperatorClick("+");
        else if (id == R.id.btn_kurang) onOperatorClick("-");
        else if (id == R.id.btn_kali) onOperatorClick("*");
        else if (id == R.id.btn_bagi) onOperatorClick("/");

            // Tombol Fungsi Spesial
        else if (id == R.id.btn_pangkat) onFungsiSpesialClick("x²");
        else if (id == R.id.btn_akar) onFungsiSpesialClick("√");

            // Tombol Clear (C)
        else if (id == R.id.btn_clear) onClearClick();

            // Tombol Equals (=)
        else if (id == R.id.btn_equals) onEqualsClick();
    }

    // --- Logika Helper ---

    private void onAngkaClick(String angka) {
        if (currentInput.equals("0")) {
            currentInput = angka;
        } else {
            currentInput += angka;
        }
        updateTampilan(currentInput);
    }

    private void onOperatorClick(String op) {
        // Jika belum ada operator, simpan angka pertama dan operatornya
        if (operator.isEmpty()) {
            angkaPertama = Double.parseDouble(currentInput);
            operator = op;
            currentInput = ""; // Siapkan untuk angka kedua
        }
        // (Logika kalkulator sederhana tidak menangani operator berantai seperti 5 + 5 + 5)
    }

    private void onFungsiSpesialClick(String fungsi) {
        if (currentInput.isEmpty()) return;

        double angka = Double.parseDouble(currentInput);
        double hasil = 0;

        if (fungsi.equals("x²")) {
            hasil = angka * angka;
        } else if (fungsi.equals("√")) {
            hasil = Math.sqrt(angka);
        }

        currentInput = String.valueOf(hasil);
        updateTampilan(currentInput);
        // Reset operator agar bisa mulai perhitungan baru
        operator = "";
    }

    private void onEqualsClick() {
        if (operator.isEmpty() || currentInput.isEmpty()) return;

        double angkaKedua = Double.parseDouble(currentInput);
        double hasil = 0;

        if (operator.equals("+")) {
            hasil = angkaPertama + angkaKedua;
        } else if (operator.equals("-")) {
            hasil = angkaPertama - angkaKedua;
        } else if (operator.equals("*")) {
            hasil = angkaPertama * angkaKedua;
        } else if (operator.equals("/")) {
            if (angkaKedua != 0) {
                hasil = angkaPertama / angkaKedua;
            } else {
                updateTampilan("Error"); // Pembagian dengan nol
                resetKalkulator();
                return;
            }
        }

        currentInput = String.valueOf(hasil);
        updateTampilan(currentInput);
        operator = ""; // Selesai, reset operator
    }

    private void onClearClick() {
        resetKalkulator();
        updateTampilan("0");
    }

    private void resetKalkulator() {
        currentInput = "";
        operator = "";
        angkaPertama = 0;
    }

    private void updateTampilan(String text) {
        tvHasil.setText(text);
    }
}