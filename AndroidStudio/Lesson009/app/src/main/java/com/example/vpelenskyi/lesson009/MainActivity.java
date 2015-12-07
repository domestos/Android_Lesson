package com.example.vpelenskyi.lesson009;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btnMethod_1, btnMethod_2, btnMethod_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        btnMethod_1 = (Button) findViewById(R.id.btn_method_1);
        btnMethod_2 = (Button) findViewById(R.id.btn_method_2);
        btnMethod_3 = (Button) findViewById(R.id.btn_method_3);

        btnMethod_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("You clicked on the button Method 1");
            }
        });

        btnMethod_2.setOnClickListener(this);
        btnMethod_3.setOnClickListener(this);
        textView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_method_2:
                textView.setText("You clicked on the button Method 2");
                break;
            case R.id.btn_method_3:
                textView.setText("You clicked on the button Method 3");
                break;
            case R.id.text:
                textView.setText("Lesson 9-10");
                break;
        }
    }
}
