package com.example.vpelenskyi.lesson27;

import android.app.Activity;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ProgressBar progressBar;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvProgressBarValue);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
    }

    public void onProgressButton(View v) {
        new MyProgressBarAsyncTask().execute();
    }
    class MyProgressBarAsyncTask extends AsyncTask<Void, Integer, Void> {

        private int processBarValue = 0 ;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Begin AsyncTask process", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Finish AsyncTask process", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            textView.setText(values[0] + " %");
        }

        @Override
        protected Void doInBackground(Void... params) {
            while (processBarValue<100){
                processBarValue++;
                publishProgress(processBarValue);
                SystemClock.sleep(200);
            }
            return null;
        }
    }
}
