package es.hol.varenik.lesson042_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String name[] = {"Valera", "Roman", "Dima", "Kiril"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lView = (ListView) findViewById(R.id.lView);

       // ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, name );
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.my_list_item, name );

        lView.setAdapter(arrayAdapter);

    }
}
