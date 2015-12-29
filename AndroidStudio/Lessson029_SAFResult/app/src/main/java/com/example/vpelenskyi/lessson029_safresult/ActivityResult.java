package com.example.vpelenskyi.lessson029_safresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityResult extends AppCompatActivity implements View.OnClickListener {
    Button btnRequest;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_result);

        btnRequest = (Button) findViewById(R.id.btnRequvestActivity);
        btnRequest.setOnClickListener(this);
        etName = (EditText) findViewById(R.id.etName);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", etName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}
