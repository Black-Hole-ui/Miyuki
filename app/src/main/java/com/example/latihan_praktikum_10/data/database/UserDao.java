package com.example.latihan_praktikum_10.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.latihan_praktikum_10.data.entity.Weather;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(Weather weather);

    @Delete
    void delete(Weather weather); // **Tambah ini untuk hapus**

    @Query("SELECT * FROM weather")
    LiveData<List<Weather>> getAllWeatherData();

    @Query("SELECT * FROM weather WHERE city LIKE '%' || :city || '%'")
    LiveData<List<Weather>> getWeatherByCityName(String city);
}
