package com.example.utsproject;

import android.content.Intent; // IMPORT BARU
import android.net.Uri; // IMPORT BARU
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView; // IMPORT BARU
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;


public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.KontakViewHolder> {

    private ArrayList<Kontak> listKontak;

    public KontakAdapter(ArrayList<Kontak> listKontak) {
        this.listKontak = listKontak;
    }

    @NonNull
    @Override
    public KontakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kontak_item, parent, false);
        return new KontakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KontakViewHolder holder, int position) {
        Kontak kontak = listKontak.get(position);

        holder.tvNama.setText(kontak.getNama());
        holder.tvTelepon.setText(kontak.getTelepon());
        // holder.imgFoto.setImageResource(...);

        // --- INI LOGIKA BARU ---
        holder.imgTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nomor telepon dari data
                String nomorTelepon = kontak.getTelepon();

                // Buat Intent untuk membuka aplikasi Telepon (Dialer)
                // ACTION_DIAL akan membuka dialer dengan nomor sudah terisi
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + nomorTelepon));

                // Mulai Activity
                holder.itemView.getContext().startActivity(dialIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKontak.size();
    }


    public class KontakViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView imgFoto;
        public TextView tvNama;
        public TextView tvTelepon;
        public ImageView imgTelepon; // VARIABEL BARU

        public KontakViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_foto_kontak);
            tvNama = itemView.findViewById(R.id.tv_nama_kontak);
            tvTelepon = itemView.findViewById(R.id.tv_telepon_kontak);
            imgTelepon = itemView.findViewById(R.id.img_telepon_icon); // HUBUNGKAN ID BARU
        }
    }
}