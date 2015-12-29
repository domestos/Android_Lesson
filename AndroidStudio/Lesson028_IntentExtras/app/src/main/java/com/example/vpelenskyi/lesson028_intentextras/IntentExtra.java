package com.example.vpelenskyi.lesson028_intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentExtra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_extra);

        TextView tvIntentExtra = (TextView) findViewById(R.id.tvIntentExtra);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        tvIntentExtra.setText(tvIntentExtra.getText()+ name);

    }
}
