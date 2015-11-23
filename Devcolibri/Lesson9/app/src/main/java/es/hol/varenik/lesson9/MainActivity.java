package es.hol.varenik.lesson9;

import android.content.Context;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onPosition(View v){
        Context context = getApplicationContext();
        Configuration configuration = getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Портретний", Toast.LENGTH_LONG).show();
        }else if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, " Альбомний", Toast.LENGTH_LONG).show();
        }
    }
}
