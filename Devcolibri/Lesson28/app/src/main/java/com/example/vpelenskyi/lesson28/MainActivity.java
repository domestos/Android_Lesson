package com.example.vpelenskyi.lesson28;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  "LogValera";
    private  MyAsyncTask task;
    private  String returnTextAsynctask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickAsyncTask(View v) {
        task = new MyAsyncTask();
        task.execute();
        try {
            returnTextAsynctask = task.get(2, TimeUnit.SECONDS);
            Toast.makeText(this, returnTextAsynctask, Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            Toast.makeText(this, "sorry, but time out", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    class MyAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            Log.i(TAG, "begin do method doInBackground");
            try {
                Log.i(TAG, "time work this method 3 second");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello baby";

        }

        @Override
        protected void onPostExecute(String s) {
            Log.i(TAG, "do method onPostExecute get string - " + s);
            super.onPostExecute(s);
        }
    }
}
