package com.example.vpelenskyi.lesson13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by v.pelenskyi on 25.11.2015.
 */
public class TableLayoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);
    }


    public void backMainactivity(View v){
        startActivity(new Intent(this,  MainActivity.class));
    }
}
