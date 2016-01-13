package com.example.vpelenskyi.lesson040_inflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String LOG_TAG = "LOG_INFALATER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.text, linLayout, true);
        ViewGroup.LayoutParams lp1 = view1.getLayoutParams();

        Log.d(LOG_TAG, "______ Class of view1: " + view1.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view1: " + lp1.getClass().toString());
        //  Log.d(LOG_TAG, "Text of view1: " + ((TextView) view1).getText());

        RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.relLayout);
        LayoutInflater rInflater = getLayoutInflater();
        View view2 = inflater.inflate(R.layout.text, relLayout, false);
        relLayout.addView(view2);
        ViewGroup.LayoutParams lp2 = view2.getLayoutParams();

        Log.d(LOG_TAG, "______ Class of view2: " + view2.getClass().toString());
        Log.d(LOG_TAG, "Class of layoutParams of view2: " + lp2.getClass().toString());
      //  Log.d(LOG_TAG, "Text of view2: " + ((TextView) view2).getText());

    }
}
