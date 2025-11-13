package com.example.utsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

// Import 5 Fragment Anda
import com.example.utsproject.BiodataFragment;
import com.example.utsproject.KontakFragment;
import com.example.utsproject.KalkulatorFragment;
import com.example.utsproject.CuacaFragment;
import com.example.utsproject.BeritaFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);
        navView.setItemIconTintList(null);

        // Tampilkan Halaman Biodata saat pertama kali dibuka (tanpa animasi)
        if (savedInstanceState == null) {
            loadFragment(new BiodataFragment(), true);
        }

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Hindari memuat ulang fragmen yang sama
                if (item.getItemId() == navView.getSelectedItemId()) {
                    return false;
                }

                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.navigation_biodata) {
                    selectedFragment = new BiodataFragment();
                } else if (itemId == R.id.navigation_kontak) {
                    selectedFragment = new KontakFragment();
                } else if (itemId == R.id.navigation_kalkulator) {
                    selectedFragment = new KalkulatorFragment();
                } else if (itemId == R.id.navigation_cuaca) {
                    selectedFragment = new CuacaFragment();
                } else if (itemId == R.id.navigation_berita) {
                    selectedFragment = new BeritaFragment();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment, false);
                    return true;
                }

                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment, boolean isInitial) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // Gunakan animasi fade-in/fade-out standar
        if (!isInitial) {
            fragmentTransaction.setCustomAnimations(
                android.R.anim.fade_in,  // Animasi masuk untuk fragmen baru
                android.R.anim.fade_out, // Animasi keluar untuk fragmen lama
                android.R.anim.fade_in,  // Animasi masuk saat kembali (pop)
                android.R.anim.fade_out  // Animasi keluar saat kembali (pop)
            );
        }

        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);

        if (!isInitial) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}