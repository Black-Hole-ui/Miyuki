package com.example.latihan_praktikum_10.persentation.ui;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import com.example.latihan_praktikum_10.R;
public class CustomFragment extends Fragment {
    private TextView suhuTextView;
    private float currentTemp = 0f;
    private final String CHANNEL_ID = "suhu_channel";
    private final BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
            currentTemp = temperature / 10f;
            suhuTextView.setText("Suhu Baterai: " + currentTemp + "°C");
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, container, false);

        suhuTextView = view.findViewById(R.id.suhuTextView);
        Button btnNotif = view.findViewById(R.id.btnNotif);

        createNotificationChannel();

        btnNotif.setOnClickListener(v -> showNotification());

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        requireContext().registerReceiver(batteryReceiver, filter);
    }
    @Override
    public void onPause() {
        super.onPause();
        requireContext().unregisterReceiver(batteryReceiver);
    }
    private void showNotification() {
        String status;
        if (currentTemp >= 45) {
            status = "Bahaya! Suhu sangat tinggi: " + currentTemp + "°C";
        } else if (currentTemp >= 36) {
            status = "Peringatan! Suhu cukup tinggi: " + currentTemp + "°C";
        } else {
            status = "Aman. Suhu: " + currentTemp + "°C";
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.baseline_battery_saver_24)
                .setContentTitle("Status Suhu Baterai")
                .setContentText(status)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
        notificationManager.notify(1, builder.build());
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Suhu Channel";
            String description = "Channel untuk notifikasi suhu baterai";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = requireActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
