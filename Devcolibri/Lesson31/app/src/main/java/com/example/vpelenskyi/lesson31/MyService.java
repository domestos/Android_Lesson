package com.example.vpelenskyi.lesson31;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by v.pelenskyi on 04.12.2015.
 */
public class MyService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("MY_SERVICE","Service is began work");

    }
}
