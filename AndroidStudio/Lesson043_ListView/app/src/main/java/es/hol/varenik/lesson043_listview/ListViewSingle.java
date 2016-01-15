package es.hol.varenik.lesson043_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListViewSingle extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "myLog";

    String[] names;
    ListView lView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lView = (ListView) findViewById(R.id.lView);
        lView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.array_names,
                android.R.layout.simple_list_item_single_choice);

        lView.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        names = getResources().getStringArray(R.array.array_names);
    }

    @Override
    public void onClick(View v) {
        Log.i(LOG_TAG, "checked: " + names[lView.getCheckedItemPosition()]);
    }

}
