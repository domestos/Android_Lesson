package es.hol.varenik.lesson049_simpleadapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // names are attribute for Map
    final String ATTRIBUT_NAME_TEXT = "text";
    final String ATTRIBUT_NAME_IMAGE = "image";
    final String ATTRIBUT_NAME_VALUE = "value";

    //images
    final int positiv = android.R.drawable.arrow_up_float;
    final int negativ = android.R.drawable.arrow_down_float;

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSimple = (ListView) findViewById(R.id.lView);
        int[] values = new int[]{8, 4, -3, 2, -5, 0, 3, -6, 1, -1};
        ArrayList<Map<String, Object>> data = new ArrayList<>(values.length);
        Map<String, Object> m;
        int img = 0;
        for (int i = 0; i < values.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUT_NAME_TEXT, "Day " + (i + 1));
            m.put(ATTRIBUT_NAME_VALUE, values[i]);
            if (values[i] == 0) {
                img = 0;

            } else {
                img = (values[i] > 0) ? positiv : negativ;
            }
            m.put(ATTRIBUT_NAME_IMAGE, img);
            data.add(m);
        }

        String form[] = {ATTRIBUT_NAME_TEXT, ATTRIBUT_NAME_VALUE, ATTRIBUT_NAME_IMAGE};
        int to[] = {R.id.tvText, R.id.tvValue, R.id.imageItem};

        MySimpleAdapter sAdapter = new MySimpleAdapter(this, data, R.layout.item, form, to);
        lvSimple.setAdapter(sAdapter);
    }

    class MySimpleAdapter extends SimpleAdapter {
        public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public void setViewText(TextView v, String text) {
            super.setViewText(v, text);
            if (v.getId() == R.id.tvValue) {
                int i = Integer.parseInt(text);
                if (i < 0) {
                    v.setTextColor(Color.RED);
                } else if (i > 0) {
                    v.setTextColor(Color.GREEN);
                }
            }
        }

        @Override
        public void setViewImage(ImageView v, int value) {
            super.setViewImage(v, value);

            if (value == negativ) {
                v.setBackgroundColor(Color.RED);
            } else if (value == positiv) {
                v.setBackgroundColor(Color.GREEN);
            }
        }
    }
}
