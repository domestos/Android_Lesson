package com.example.vpelenskyi.lesson022_023_lifecycle_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by v.pelenskyi on 28.12.2015.
 */


public class NewActivity extends AppCompatActivity {
    private static String TAG = "lifecycle_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.new_activity);
        Button btnBack = new Button(this);
        btnBack.setText("back");
        linearLayout.addView(btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Log.d(TAG, "NEW ACTIVITY onCreat:  Activity created");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "NEW ACTIVITY onRestart: Activity in Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "NEW ACTIVITY onStart: Activity shown");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "NEW ACTIVITY onResume: Activity in focus");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "NEW ACTIVITY onPause: Activity in paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "NEW ACTIVITY onStop: Activity of stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "NEW ACTIVITY onDestroy: Activity of destroyed");
    }

}
