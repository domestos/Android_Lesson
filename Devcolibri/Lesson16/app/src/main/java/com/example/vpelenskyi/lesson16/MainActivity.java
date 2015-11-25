package com.example.vpelenskyi.lesson16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "VALOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onInfoLog(View v) {
        Log.i(TAG, "info log ");
    }

    public void onErrorLog(View v) {
        Log.e(TAG, "error log ");

    }

    public void onWarnLog(View v) {
        Log.w(TAG, "warn log ");

    }

    public void onDebugLog(View v) {
        Log.d(TAG, "debug log");
        Log.v(TAG, "verbose log");
        Log.wtf(TAG, "wtf log");
    }
}
