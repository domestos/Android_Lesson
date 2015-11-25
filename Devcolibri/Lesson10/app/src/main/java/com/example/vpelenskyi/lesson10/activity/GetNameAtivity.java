package com.example.vpelenskyi.lesson10.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vpelenskyi.lesson10.R;

/**
 * Created by v.pelenskyi on 25.11.2015.
 */
public class GetNameAtivity extends Activity {
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_name_activity);
        etName = (EditText) findViewById(R.id.etGetName);
    }

    public void onMainActivity(View v){
        Intent intent;
        intent =  new Intent(this, MainActivity.class);
        intent.putExtra("name", etName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
