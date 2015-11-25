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
public class GetSurnameAtivity extends Activity {

    EditText etGetSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_surname_activity);
        etGetSurname = (EditText) findViewById(R.id.etGetSurname);
    }


    public void onMainActivity (View v){
        Intent intent  = new Intent (this , MainActivity.class);
        intent.putExtra("surname", etGetSurname.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}
