package com.lzitech.servicesdemoapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Saved ..", Toast.LENGTH_LONG).show();
        mediaPlayer = MediaPlayer.create(this, R.raw.sun);
        mediaPlayer.setLooping(false);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Starting ..", Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        // if we get killed, after returning from here, restart.
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Done ..", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }
}
