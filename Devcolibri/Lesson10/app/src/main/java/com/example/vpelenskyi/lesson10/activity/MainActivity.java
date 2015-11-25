package com.example.vpelenskyi.lesson10.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vpelenskyi.lesson10.R;

public class MainActivity extends AppCompatActivity {

    TextView tvGetName , tvGetSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGetName = (TextView) findViewById(R.id.tvGetName);
        tvGetSurname = (TextView) findViewById(R.id.tvGetSurname);
    }

    public void showActivity(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnSayName:
                intent = new Intent(this, GetNameAtivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_GET_NAME);
                break;

            case R.id.btnSaySurname:
                intent = new Intent(this, GetSurnameAtivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_GET_SURNAME);
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode){
                case RequestCode.REQUEST_CODE_GET_NAME :
                    tvGetName.setText(data.getStringExtra("name"));
                    break;
                case RequestCode.REQUEST_CODE_GET_SURNAME:
                    tvGetSurname.setText(data.getStringExtra("surname"));
                    break;



            }
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_LONG);
        }
    }
}
