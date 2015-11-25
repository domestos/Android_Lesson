package com.example.vpelenskyi.lesson12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
        Button btnLLH, btnLLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLLH = (Button) findViewById(R.id.btnLLH);
        btnLLV = (Button) findViewById(R.id.btnLLV);
    }

    public void showActivity(View v){
        Intent intent ;
        switch (v.getId()){
            case R.id.btnLLH :
                intent = new Intent(this, LinerLayoutHorizontalActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLLV :
                intent = new Intent(this, LinerLayoutVerticalActivity.class);
                startActivity(intent);
                break;
        }
    }
}
