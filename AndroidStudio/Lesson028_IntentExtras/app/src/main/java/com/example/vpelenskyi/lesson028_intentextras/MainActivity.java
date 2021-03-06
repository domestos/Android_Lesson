package com.example.vpelenskyi.lesson028_intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIntentExtra;
    EditText etIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIntent = (EditText) findViewById(R.id.etIntent);

        btnIntentExtra = (Button) findViewById(R.id.btnIntentExtra);
        btnIntentExtra.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent =  new Intent(this, IntentExtra.class);
                        // key  ,  values
        intent.putExtra("name", etIntent.getText().toString());
        startActivity(intent);

    }
}
