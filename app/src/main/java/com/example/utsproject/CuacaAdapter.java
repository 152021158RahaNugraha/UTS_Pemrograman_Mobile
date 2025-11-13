package com.example.utsproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CuacaAdapter extends RecyclerView.Adapter<CuacaAdapter.CuacaViewHolder> {

    private ArrayList<CuacaHarian> listCuaca;

    public CuacaAdapter(ArrayList<CuacaHarian> listCuaca) {
        this.listCuaca = listCuaca;
    }

    @NonNull
    @Override
    public CuacaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuaca_item, parent, false);
        return new CuacaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuacaViewHolder holder, int position) {
        CuacaHarian cuaca = listCuaca.get(position);

        holder.tvHari.setText(cuaca.getHari());
        holder.imgIcon.setImageResource(cuaca.getIconCuaca());
        holder.tvSuhu.setText(cuaca.getSuhu());
        holder.tvDeskripsi.setText(cuaca.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return listCuaca.size();
    }

    // ViewHolder
    public class CuacaViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHari, tvSuhu, tvDeskripsi;
        public ImageView imgIcon;

        public CuacaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHari = itemView.findViewById(R.id.tv_hari);
            imgIcon = itemView.findViewById(R.id.img_icon_cuaca);
            tvSuhu = itemView.findViewById(R.id.tv_suhu_harian);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi_harian);
        }
    }
}