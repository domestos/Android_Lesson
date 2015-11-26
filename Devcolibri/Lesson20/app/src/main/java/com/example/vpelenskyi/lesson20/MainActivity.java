package com.example.vpelenskyi.lesson20;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager nm;
    private final int NITIFICATION_ID = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showNotification(View view) {
        Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(getApplicationContext());

        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.business189)
                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ball40))
                .setTicker("Notification")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Lesson 20 Notification")
                .setContentText("push if you want know secret");

        Notification notification = builder.build();
                nm.notify(NITIFICATION_ID, notification);

    }
}
