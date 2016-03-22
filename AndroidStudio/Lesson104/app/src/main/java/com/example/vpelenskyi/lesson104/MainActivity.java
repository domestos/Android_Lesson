package com.example.vpelenskyi.lesson104;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String  TAG_LOG = "myLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG_LOG, "MainActivity onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG_LOG, "MainActivity onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_LOG, "MainActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_LOG, "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_LOG, "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG_LOG, "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG_LOG, "MainActivity onDestroy");
    }
}
