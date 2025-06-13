package com.example.latihan_praktikum_10.persentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan_praktikum_10.R;
import com.example.latihan_praktikum_10.data.entity.Weather;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Weather> weatherList;

    // Interface untuk long click listener
    public interface OnItemLongClickListener {
        void onItemLongClick(Weather weather);
    }

    private OnItemLongClickListener longClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.longClickListener = listener;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        Weather weather = weatherList.get(position);
        holder.cityName.setText(weather.getCity());
        holder.temperature.setText(String.format("%s°C", weather.getTemperature()));
        holder.description.setText(weather.getDescription());

        // Pasang listener long click di itemView
        holder.itemView.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                longClickListener.onItemLongClick(weather);
                return true; // event handled
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return weatherList != null ? weatherList.size() : 0;
    }

    public void setData(List<Weather> weatherList) {
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView cityName, temperature, description;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.city_name);
            temperature = itemView.findViewById(R.id.temperature);
            description = itemView.findViewById(R.id.description);
        }
    }
}
