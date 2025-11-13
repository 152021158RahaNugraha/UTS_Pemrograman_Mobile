package com.example.utsproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView; // PENTING: Import ImageView
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    // 1. Variabel untuk menyimpan data
    private ArrayList<Berita> listBerita;

    // 2. Constructor
    public BeritaAdapter(ArrayList<Berita> listBerita) {
        this.listBerita = listBerita;
    }

    // 3. Method untuk membuat ViewHolder (menghubungkan ke layout berita_item.xml)
    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.berita_item, parent, false);
        return new BeritaViewHolder(view);
    }

    // 4. Method untuk 'mengikat' data ke tampilan (ViewHolder)
    @Override
    public void onBindViewHolder(@NonNull BeritaViewHolder holder, int position) {
        Berita berita = listBerita.get(position);

        holder.tvJudul.setText(berita.getJudul());
        holder.tvDeskripsi.setText(berita.getDeskripsi());

        // Set gambar dari ID drawable
        holder.imgGambar.setImageResource(berita.getGambar());
    }

    // 5. Method untuk menghitung jumlah total data
    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    // 6. Class ViewHolder (Sub-Class di dalam Adapter)
    // Menyimpan referensi ke komponen di layout berita_item.xml
    public class BeritaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgGambar;
        public TextView tvJudul;
        public TextView tvDeskripsi;

        public BeritaViewHolder(@NonNull View itemView) {
            super(itemView);
            // Hubungkan variabel dengan ID di layout berita_item.xml
            imgGambar = itemView.findViewById(R.id.img_gambar_berita);
            tvJudul = itemView.findViewById(R.id.tv_judul_berita);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi_berita);
        }
    }
}