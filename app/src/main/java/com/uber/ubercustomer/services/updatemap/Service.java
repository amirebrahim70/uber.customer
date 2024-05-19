package com.uber.ubercustomer.services.updatemap;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Service extends android.app.Service {
    private static final long INTERVAL_MS = 1000; // 5 seconds
    private static final int ALARM_REQUEST_CODE = 123;
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotification();
        scheduleAlarm();
        // Return START_STICKY to ensure the service restarts automatically if it's killed by the system
        return START_STICKY;
    }
    private void scheduleAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, Receiver.class);
        alarmIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long triggerAtMillis = System.currentTimeMillis() + INTERVAL_MS;
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, alarmIntent);
    }
    private void createNotification() {
        // Create a notification to run the service as a foreground service
        String channelId = "my_channel_id";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("My Foreground Service")
                .setContentText("Running in the foreground");

        // Create the notification channel for Android Oreo and above
            NotificationChannel channel = new NotificationChannel(channelId, "My Foreground Service", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        // Start the service as a foreground service
        startForeground(1, builder.build());
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        this.registerReceiver(new Receiver(), new IntentFilter("com.uber.ubercustomer.services.updatemap.receiver"));
        super.onCreate();
    }


}
