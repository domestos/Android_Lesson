package es.hol.varenik.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by varenik on 04.12.15.
 */
public class MyActivity extends Activity {
    private ListView listView;
    private int count = 30;
    private String[] list = createArray(count);

    private String[] createArray(int count) {
        list = new String[count];
        for (;count>0; count--){
            list[count-1] = "Item " + count;
        }

        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        listView = (ListView) findViewById(R.id.lvItem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

    }

    public void nextIntent(View v){
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }

}
