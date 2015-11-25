package com.example.vpelenskyi.lesson14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by v.pelenskyi on 25.11.2015.
 */
public class GridLayoutActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
    }


    public void backMainactivity(View v){
        startActivity(new Intent(this, MainActivity.class));
    }



}
