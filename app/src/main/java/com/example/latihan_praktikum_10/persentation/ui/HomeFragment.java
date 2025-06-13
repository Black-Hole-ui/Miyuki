package com.example.latihan_praktikum_10.persentation.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan_praktikum_10.R;
import com.example.latihan_praktikum_10.persentation.adapter.WeatherAdapter;
import com.example.latihan_praktikum_10.persentation.viewmodel.UserViewModel;

public class HomeFragment extends Fragment {
    private UserViewModel viewModel;
    private WeatherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_weather);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WeatherAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getAllWeatherFromDb().observe(getViewLifecycleOwner(), adapter::setData);

        // Pasang long click listener untuk hapus item
        adapter.setOnItemLongClickListener(weather -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Hapus Cuaca")
                    .setMessage("Yakin ingin menghapus data cuaca untuk " + weather.getCity() + "?")
                    .setPositiveButton("Hapus", (dialog, which) -> {
                        viewModel.deleteWeather(weather);
                    })
                    .setNegativeButton("Batal", null)
                    .show();
        });

        return view;
    }
}
