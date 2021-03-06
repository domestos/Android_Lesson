package com.example.vpelenskyi.lesson030_safr;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button btnColor, btnAlign;
    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        btnAlign = (Button) findViewById(R.id.btnAlign);
        btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(this);
        btnAlign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;


            case R.id.btnAlign:
                intent = new Intent(this, ActivityAlign.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGN);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myLog", "requestCode = " + requestCode + ", resultCodel = " + resultCode);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("color", Color.WHITE);
                    textView.setTextColor(color);
                    break;

                case REQUEST_CODE_ALIGN:
                    int align = data.getIntExtra("align", Gravity.LEFT);
                    textView.setGravity(align);

                    break;
            }


        }
    }
}
