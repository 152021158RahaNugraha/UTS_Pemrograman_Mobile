package com.example.utsproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class CuacaFragment extends Fragment {

    // 1. Deklarasi untuk 7-Day Forecast (Vertikal)
    private RecyclerView recyclerViewCuaca;
    private CuacaAdapter cuacaAdapter;
    private ArrayList<CuacaHarian> listCuaca;

    // 2. DEKLARASI BARU untuk Hourly Forecast (Horizontal)
    private RecyclerView recyclerViewCuacaPerJam;
    private CuacaPerJamAdapter cuacaPerJamAdapter;
    private ArrayList<CuacaPerJam> listCuacaPerJam;

    public CuacaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuaca, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- Setup 7-Day Forecast (Vertikal) ---
        recyclerViewCuaca = view.findViewById(R.id.recycler_view_cuaca_harian);
        recyclerViewCuaca.setHasFixedSize(true);
        buatDataCuaca(); // Buat data
        cuacaAdapter = new CuacaAdapter(listCuaca); // Buat adapter
        recyclerViewCuaca.setAdapter(cuacaAdapter); // Set adapter
        recyclerViewCuaca.setLayoutManager(new LinearLayoutManager(getContext())); // Set layout


        // --- SETUP BARU: Hourly Forecast (Horizontal) ---
        recyclerViewCuacaPerJam = view.findViewById(R.id.recycler_view_cuaca_per_jam);
        recyclerViewCuacaPerJam.setHasFixedSize(true);

        // Buat LayoutManager horizontal
        LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(getContext());
        layoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewCuacaPerJam.setLayoutManager(layoutManagerHorizontal);

        buatDataCuacaPerJam(); // Buat data
        cuacaPerJamAdapter = new CuacaPerJamAdapter(listCuacaPerJam); // Buat adapter
        recyclerViewCuacaPerJam.setAdapter(cuacaPerJamAdapter); // Set adapter
    }

    // Method untuk data 7 hari (sudah ada)
    private void buatDataCuaca() {
        listCuaca = new ArrayList<>();
        // (Ganti R.drawable.ic_partly_cloudy, dll. dengan ikon PNG Anda)
        listCuaca.add(new CuacaHarian("Sen", R.drawable.cloudy, "26°C", "Partly Cloudy"));
        listCuaca.add(new CuacaHarian("Sel", R.drawable.rain, "24°C", "Showers")); // Ganti ikon
        listCuaca.add(new CuacaHarian("Rab", R.drawable.cloudy, "28°C", "Mostly Sunny")); // Ganti ikon
        listCuaca.add(new CuacaHarian("Kam", R.drawable.rain, "23°C", "Light Rain")); // Ganti ikon
        listCuaca.add(new CuacaHarian("Jum", R.drawable.cloudy, "28°C", "Sunny")); // Ganti ikon
        listCuaca.add(new CuacaHarian("Sab", R.drawable.cloudy, "28°C", "Partly Cloudy")); // Ganti ikon
        listCuaca.add(new CuacaHarian("Min", R.drawable.rain, "22°C", "Rain Likely")); // Ganti ikon
    }

    // METHOD BARU: untuk data per jam
    private void buatDataCuacaPerJam() {
        listCuacaPerJam = new ArrayList<>();
        // (Ganti R.drawable.ic_partly_cloudy, dll. dengan ikon PNG Anda)
        listCuacaPerJam.add(new CuacaPerJam("Now", R.drawable.cloudy, "22°"));
        listCuacaPerJam.add(new CuacaPerJam("13:00", R.drawable.rain, "21°")); // Ganti ikon
        listCuacaPerJam.add(new CuacaPerJam("14:00", R.drawable.cloudy, "20°")); // Ganti ikon
        listCuacaPerJam.add(new CuacaPerJam("15:00", R.drawable.rain, "21°")); // Ganti ikon
        listCuacaPerJam.add(new CuacaPerJam("16:00", R.drawable.cloudy, "20°")); // Ganti ikon
        listCuacaPerJam.add(new CuacaPerJam("17:00", R.drawable.cloudy, "19°")); // Ganti ikon
    }
}