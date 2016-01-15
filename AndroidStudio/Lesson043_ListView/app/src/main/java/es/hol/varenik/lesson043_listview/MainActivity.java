package es.hol.varenik.lesson043_listview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSingleList).setOnClickListener(this);
        findViewById(R.id.btnMutipleList).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnSingleList:
                intent = new Intent(this, ListViewSingle.class);
                startActivity(intent);
                break;
            case R.id.btnMutipleList:
                intent = new Intent(this, ListViewMultiple.class);
                startActivity(intent);
                break;
        }

    }
}
