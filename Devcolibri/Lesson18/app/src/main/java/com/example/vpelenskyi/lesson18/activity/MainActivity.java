package com.example.vpelenskyi.lesson18.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vpelenskyi.lesson18.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMobile = (ListView) findViewById(R.id.lvMobile);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, initData());
        lvMobile.setAdapter(adapter);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        list.add("Samsung");
        list.add("iPhone");
        list.add("LG");
        list.add("HTC");
        return list;
    }

    public void showPojoListView(View v) {
        Intent intent = new Intent(this, PojoListViewActivity.class);
        startActivity(intent);
    }

}
