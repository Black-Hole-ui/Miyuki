package com.example.latihan_praktikum_10.persentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.latihan_praktikum_10.data.entity.Weather;
import com.example.latihan_praktikum_10.data.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
    }

    public LiveData<List<Weather>> getAllWeatherFromDb() {
        return repository.getAllWeatherFromDb();
    }

    public void searchCityWeather(String cityName) {
        repository.fetchWeatherData(cityName);
    }

    // Tambah method hapus weather
    public void deleteWeather(Weather weather) {
        repository.deleteWeather(weather);
    }
}
