package es.hol.varenik.lesson025_activity_lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by varenik on 28.12.15.
 */
public class ActivityB extends AppCompatActivity {
    private String TAG = "Log_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d(TAG, "Activit_B: onCreate");


        Button btnActivityC = (Button) findViewById(R.id.btnActivityC);
        btnActivityC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityC.class);
                startActivity(intent);
            }
        });

        Button btnBack = (Button) findViewById(R.id.btnBack);
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
        Log.d(TAG, "Activit_B: onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activit_B: onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activit_B: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activit_B: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activit_B: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activit_B: onDestroy");
    }
}
