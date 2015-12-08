package com.example.vpelenskyi.lesson3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Attention -- android.R.id.list
        listView = (ListView) findViewById(android.R.id.list);


        // ============ hiden floating action button
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.attachToListView(listView);
        // ============ hiden floating action button


        String[] arrayString = new String[30];
        for (int i = 0; i <arrayString.length ; i++) {
            arrayString[i] = "Item "+(1+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayString);
        listView.setAdapter(adapter);
    }
}
