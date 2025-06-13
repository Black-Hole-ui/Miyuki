package com.example.latihan_praktikum_10.persentation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.latihan_praktikum_10.R;
import com.example.latihan_praktikum_10.persentation.viewmodel.UserViewModel;

public class KontentFragment extends Fragment {
    private UserViewModel userViewModel;
    private EditText editSearch;
    private Button buttonSearch;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kontent, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editSearch = view.findViewById(R.id.edit_search);
        buttonSearch = view.findViewById(R.id.button_search);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        buttonSearch.setOnClickListener(v -> {
            String cityName = editSearch.getText().toString().trim();
            if (!cityName.isEmpty()) {
                userViewModel.searchCityWeather(cityName);
            }
        });
    }
}
