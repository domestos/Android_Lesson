package com.example.vpelenskyi.lesson12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by v.pelenskyi on 25.11.2015.
 */
public class LinerLayoutHorizontalActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_horizontal);


    }

    public void backMainActivity(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}
