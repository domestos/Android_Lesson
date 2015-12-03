package com.example.vpelenskyi.lesson29;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by v.pelenskyi on 03.12.2015.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        try {
            for (int i = 0; i <= 5; i++) {
                Log.i("[MY_TASK]", "Task is working...");
                Log.i("[MY_TASK]", "Task canceled..."+isCancelled()); //shows status
                TimeUnit.SECONDS.sleep(2);
                if(isCancelled()){
                    return null;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
