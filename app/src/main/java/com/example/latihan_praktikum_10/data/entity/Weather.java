package com.example.latihan_praktikum_10.data.entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "weather")
public class Weather {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String city;
    private double temperature;
    private String description;

    public Weather(String city, double temperature, String description) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
