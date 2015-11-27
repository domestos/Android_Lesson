package com.example.vpelenskyi.lesson21;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 22;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
    }


    public void showNotification(View v) {
        Intent intent = new Intent(this, FinishActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);

        builder.setSmallIcon(R.drawable.ace1)
                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.add198))
                .setTicker("Ticker Notification")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentText("Content Text")
                .setContentTitle("Content Title Lesson 20")
                .setContentIntent(pendingIntent)
                .setProgress(100, 20, true)
        ;

        Notification notification = builder.build();

        notification.defaults = Notification.DEFAULT_LIGHTS;

        long[] vibretion  = new long[]{100,1000, 100, 1500, 1000, 100,100,1000, 100, 1500, 1000, 100,100,1000, 100, 1500, 1000, 100,100,1000, 100, 1500, 1000, 100 };
        notification.vibrate = vibretion;

        notification.flags = notification.flags | Notification.FLAG_ONGOING_EVENT;

        notification.sound = Uri.parse("android.resource://com.example.vpelenskyi.lesson21/"+R.raw.soud);

        nm.notify(NOTIFICATION_ID, notification);
    }


  public void cancelNotification(View view) {
       nm.cancel(NOTIFICATION_ID);
   }


}
