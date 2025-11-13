package com.example.utsproject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager; // IMPORT INI
import androidx.recyclerview.widget.RecyclerView; // IMPORT INI
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList; // IMPORT INI

public class BeritaFragment extends Fragment {

    // 1. Deklarasi variabel
    private RecyclerView recyclerView;
    private BeritaAdapter beritaAdapter;
    private ArrayList<Berita> listBerita;

    public BeritaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_berita, container, false);

        // 2. Hubungkan RecyclerView di XML ke variabel
        recyclerView = view.findViewById(R.id.recycler_view_berita);
        recyclerView.setHasFixedSize(true);

        // 3. Buat data statis (Panggil method)
        buatDataBerita();

        // 4. Inisialisasi Adapter dan set ke RecyclerView
        beritaAdapter = new BeritaAdapter(listBerita);
        recyclerView.setAdapter(beritaAdapter);

        // 5. Set LayoutManager (Penting!)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    // Method untuk membuat data berita statis
    private void buatDataBerita() {
        listBerita = new ArrayList<>();

        // (Pastikan gambar_berita_1 dan gambar_berita_2 ada di folder res/drawable)
        listBerita.add(new Berita(
                "OpenAI Rilis Model Baru",
                "OpenAI baru saja mengumumkan platform baru untuk membuat kustom AI...",
                R.drawable.openai // Menggunakan ID drawable
        ));

        listBerita.add(new Berita(
                "Panda di Kebun Binatang Nasional",
                "Program panda di Kebun Binatang Nasional akan berakhir setelah...",
                R.drawable.panda // Menggunakan ID drawable
        ));

        listBerita.add(new Berita(
                "Cuaca Panas Melanda Kota",
                "BMKG memprediksi cuaca panas akan terus berlanjut hingga akhir pekan...",
                R.drawable.bmkg // Pakai gambar yang sama lagi
        ));

        listBerita.add(new Berita(
                "Teknologi AI di Smartphone",
                "Bagaimana AI mengubah cara kita menggunakan smartphone setiap hari...",
                R.drawable.openai // Pakai gambar yang sama lagi
        ));

        listBerita.add(new Berita(
                "Tips Belajar Pemrograman Mobile",
                "Simak 5 tips mudah untuk memulai karir di bidang pemrograman mobile...",
                R.drawable.android
        ));
    }
}