package com.example.utsproject;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import java.util.Calendar;

public class BiodataFragment extends Fragment {

    private Spinner spinnerProdi;
    private EditText etTanggalLahir;
    private Calendar calendar;
    private ImageView imgKalender;

    public BiodataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biodata, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinnerProdi = view.findViewById(R.id.spinner_prodi);
        etTanggalLahir = view.findViewById(R.id.et_tanggal_lahir);
        calendar = Calendar.getInstance();
        imgKalender = view.findViewById(R.id.img_kalender);

        // Menghapus semua kode pewarnaan untuk memastikan ikon muncul kembali.

        setupSpinnerProdi();
        setupDatePicker();
    }

    private void setupSpinnerProdi() {
        String[] prodiArray = {"Teknik Informatika", "Sistem Informasi", "Desain Komunikasi Visual", "Teknik Mesin", "Teknik Sipil"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                prodiArray
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProdi.setAdapter(adapter);
    }

    private void setupDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String tanggalTerpilih = dayOfMonth + "/" + (month + 1) + "/" + year;
                etTanggalLahir.setText(tanggalTerpilih);
            }
        };

        View.OnClickListener openDatePicker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(),
                        dateSetListener,
                        year, month, day
                );
                datePickerDialog.show();
            }
        };

        etTanggalLahir.setOnClickListener(openDatePicker);
        // Juga buat ikon dapat diklik untuk UX yang lebih baik
        imgKalender.setOnClickListener(openDatePicker);
    }
}