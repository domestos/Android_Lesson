package com.example.vpelenskyi.lesson027_intentfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        Intent intent = getIntent();
        String action = intent.getAction();

        String format = "", textInfo="";

        if (action.equals("info.fandroid.intent.action.time")){
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }else if(action.equals("info.fandroid.intent.action.date")){
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateOrTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        TextView tvDateOrTime = (TextView) findViewById(R.id.tvDateTime);
        tvDateOrTime.setText(textInfo+ " "+dateOrTime);

    }
}
