package es.hol.varenik.lesson048_simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] texts = {"Sometext 1", "Sometext 2", "Sometext 3", "Sometext 4", "Sometext 5"};
        boolean[] checked = {true, false, false, true, false};
        int img = R.drawable.ic_comment_24dp;

        ArrayList<Map<String, Object>> data = new ArrayList<>(texts.length);
        Map<String, Object> m;
        for (int i = 0; i < texts.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        String[] form = {ATTRIBUTE_NAME_TEXT,
                ATTRIBUTE_NAME_CHECKED,
                ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.itemText, R.id.itemCheckbox, R.id.itemImage};

        SimpleAdapter spAdapter = new SimpleAdapter(this, data, R.layout.item, form, to);

        lvSimple = (ListView) findViewById(R.id.lView);
        lvSimple.setAdapter(spAdapter);
    }
}
