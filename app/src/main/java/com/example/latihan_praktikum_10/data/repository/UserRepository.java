package com.example.latihan_praktikum_10.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.latihan_praktikum_10.data.database.UserDao;
import com.example.latihan_praktikum_10.data.database.UserDatabase;
import com.example.latihan_praktikum_10.data.entity.Weather;
import com.example.latihan_praktikum_10.data.network.ApiService;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private static final String BASE_URL = "https://api.openweathermap.org/";
    private static final String API_KEY = "88402c5ca10a6a1fc82724956254a951";

    private final ApiService apiService;
    private final UserDao userDao;

    public UserRepository(Application application) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        UserDatabase db = UserDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    public LiveData<List<Weather>> getAllWeatherFromDb() {
        return userDao.getAllWeatherData();
    }

    public LiveData<List<Weather>> getWeatherByCityName(String city) {
        return userDao.getWeatherByCityName(city);
    }

    public void fetchWeatherData(String cityName) {
        apiService.getWeather(cityName, API_KEY, "metric").enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JsonObject json = response.body();
                    String city = json.get("name").getAsString();
                    double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
                    String desc = json.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
                    Weather weather = new Weather(city, temp, desc);
                    Executors.newSingleThreadExecutor().execute(() -> userDao.insert(weather));
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
    }

    // Tambah method hapus weather
    public void deleteWeather(Weather weather) {
        Executors.newSingleThreadExecutor().execute(() -> userDao.delete(weather));
    }
}
