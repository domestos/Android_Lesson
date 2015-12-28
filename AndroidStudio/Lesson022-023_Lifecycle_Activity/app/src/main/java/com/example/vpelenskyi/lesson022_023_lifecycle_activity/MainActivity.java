package com.example.vpelenskyi.lesson022_023_lifecycle_activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "lifecycle_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = new Button(this);
        btn.setText("new Activity");

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.mainActivity);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
        relativeLayout.addView(btn);

        Log.d(TAG, "MAIN onCreat: Activity created");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MAIN onRestart: Activity in Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MAIN onStart:  Activity shown");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MAIN onResume: Activity in focus");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MAIN onPause: Activity in paused");
    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MAIN onStop: Activity of stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MAIN onDestroy: Activity of destroyed");
    }
}
