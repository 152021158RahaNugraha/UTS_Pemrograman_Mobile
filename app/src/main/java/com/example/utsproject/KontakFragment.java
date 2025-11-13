package com.example.utsproject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager; // IMPORT INI
import androidx.recyclerview.widget.RecyclerView; // IMPORT INI
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList; // IMPORT INI

public class KontakFragment extends Fragment {

    // 1. Deklarasi variabel
    private RecyclerView recyclerView;
    private KontakAdapter kontakAdapter;
    private ArrayList<Kontak> listKontak;

    public KontakFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        // 2. Hubungkan RecyclerView di XML ke variabel
        recyclerView = view.findViewById(R.id.recycler_view_kontak);
        recyclerView.setHasFixedSize(true);

        // 3. Buat data statis (Panggil method)
        buatDataKontak();

        // 4. Inisialisasi Adapter dan set ke RecyclerView
        kontakAdapter = new KontakAdapter(listKontak);
        recyclerView.setAdapter(kontakAdapter);

        // 5. Set LayoutManager (Penting!)
        // Ini memberitahu RecyclerView cara menampilkan item (misal: linear, grid)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    // Method untuk membuat 15 data kontak statis
    private void buatDataKontak() {
        listKontak = new ArrayList<>();
        listKontak.add(new Kontak("Gardi", "081234567890"));
        listKontak.add(new Kontak("Raha", "082345678901"));
        listKontak.add(new Kontak("Bintang", "083456789012"));
        listKontak.add(new Kontak("Dewi Persik", "084567890123"));
        listKontak.add(new Kontak("Eka Permata", "085678901234"));
        listKontak.add(new Kontak("Fajar Nugroho", "086789012345"));
        listKontak.add(new Kontak("Gita Gutawa", "087890123456"));
        listKontak.add(new Kontak("Hendra Setiawan", "088901234567"));
        listKontak.add(new Kontak("Indra Bekti", "089012345678"));
        listKontak.add(new Kontak("Adam", "081123456789"));
        listKontak.add(new Kontak("Kaesang Pangarep", "082234567890"));
        listKontak.add(new Kontak("Luna Maya", "083345678901"));
        listKontak.add(new Kontak("Mandra", "084456789012"));
        listKontak.add(new Kontak("Nina Wang", "085567890123"));
        listKontak.add(new Kontak("Opik", "086678901234"));
    }
}