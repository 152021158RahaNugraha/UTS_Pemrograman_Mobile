package com.example.utsproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CuacaPerJamAdapter extends RecyclerView.Adapter<CuacaPerJamAdapter.CuacaPerJamViewHolder> {

    private ArrayList<CuacaPerJam> listCuacaPerJam;

    public CuacaPerJamAdapter(ArrayList<CuacaPerJam> listCuacaPerJam) {
        this.listCuacaPerJam = listCuacaPerJam;
    }

    @NonNull
    @Override
    public CuacaPerJamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuaca_per_jam_item, parent, false);
        return new CuacaPerJamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuacaPerJamViewHolder holder, int position) {
        CuacaPerJam cuaca = listCuacaPerJam.get(position);
        holder.tvJam.setText(cuaca.getJam());
        holder.imgIcon.setImageResource(cuaca.getIconCuaca());
        holder.tvSuhu.setText(cuaca.getSuhu());
    }

    @Override
    public int getItemCount() {
        return listCuacaPerJam.size();
    }

    // ViewHolder
    public class CuacaPerJamViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJam, tvSuhu;
        public ImageView imgIcon;

        public CuacaPerJamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJam = itemView.findViewById(R.id.tv_jam);
            imgIcon = itemView.findViewById(R.id.img_icon_cuaca_per_jam);
            tvSuhu = itemView.findViewById(R.id.tv_suhu_per_jam);
        }
    }
}