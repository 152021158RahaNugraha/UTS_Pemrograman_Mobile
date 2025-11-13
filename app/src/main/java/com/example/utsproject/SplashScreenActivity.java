package com.example.utsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Load the animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Find the views
        ImageView imgFoto = findViewById(R.id.img_foto);
        TextView tvJudul = findViewById(R.id.tv_judul);
        TextView tvNama = findViewById(R.id.tv_nama);
        TextView tvNim = findViewById(R.id.tv_nim);

        // Apply the animation to the views
        imgFoto.startAnimation(fadeIn);
        tvJudul.startAnimation(fadeIn);
        tvNama.startAnimation(fadeIn);
        tvNim.startAnimation(fadeIn);

        // Tentukan durasi 5 detik
        int SPLASH_TIME_OUT = 5000; // 5000ms = 5 detik

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Pindahkan ke MainActivity setelah 5 detik
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);

                // Tutup SplashScreenActivity agar tidak bisa kembali
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}