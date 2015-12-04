package com.example.vpelenskyi.lesson32.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by v.pelenskyi on 04.12.2015.
 */
public class LifeCycleService extends Service {

    private static final String TAG = "MY_SERVISE";

    @Override
    public void onCreate() {

        super.onCreate();
        Log.i(TAG , "Service main is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       Log.i(TAG, "Service main is started");
        return super.onStartCommand(intent, flags, startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service main is destroy");
        super.onDestroy();
    }
}
