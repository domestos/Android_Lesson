package com.example.vpelenskyi.lesson044;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends AppCompatActivity {
    String LOG_TAG = "myLog";
    String[] names;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.names);
        listView = (ListView) findViewById(R.id.lView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.names,
                android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(LOG_TAG, "onClick: position = " + position + ", id = " + id);
            }
        });

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(LOG_TAG, "onSelect: position = " + position + ", id = " + id);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i(LOG_TAG, "onNothingSelect: nothing");

            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.i(LOG_TAG, "scrollState: "+scrollState);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i(LOG_TAG, "firstVisibleItem: "+firstVisibleItem+" visibleItemCount: "+visibleItemCount+" totalItemCount: "+totalItemCount);
            }
        });

    }
}
