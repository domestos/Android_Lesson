package es.hol.varenik.lesson025_activity_lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityC extends AppCompatActivity {
    private String TAG = "Log_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Log.d(TAG, "Activit_C: onCreate ");


        Button btnBack = (Button) findViewById(R.id.btnBackToB);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activit_C: onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activit_C: onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activit_C: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activit_C: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activit_C: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activit_C: onDestroy");
    }
}
