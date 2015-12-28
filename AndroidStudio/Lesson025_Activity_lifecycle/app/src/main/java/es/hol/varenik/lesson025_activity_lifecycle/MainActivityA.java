package es.hol.varenik.lesson025_activity_lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivityA extends AppCompatActivity {

    private String TAG = "Log_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activit_A: onCreate");

        Button btnActivityA = (Button) findViewById(R.id.btnActivityB);
        btnActivityA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityB.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activit_A: onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activit_A: onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activit_A: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activit_A: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activit_A: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activit_A: onDestroy");
    }
}

