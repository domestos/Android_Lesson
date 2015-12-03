package com.example.vpelenskyi.lesson29;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task = new MyAsyncTask();

    }

    public void onStatus(View v){
        Toast.makeText(this, task.getStatus().toString(), Toast.LENGTH_SHORT).show();
    }
    public void onStartTask(View v) {
        task.execute();

    }

    public void onCanceltask(View v) {
        task.cancel(false);   // if will set true method onStartTask will ending work. but we can getting  error (exception)
    }
}
