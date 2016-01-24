package es.hol.varenik.lesson050_simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String ATTRIBUT_NAME_TEXT = "text";
    final String ATTRIBUT_NAME_PB = "pb";
    final String ATTRIBUT_NAME_LL = "ll";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] load = new int[]{41, 48, 22, 35, 30, 67, 51, 88};

        ArrayList<Map<String, Object>> data = new ArrayList<>(load.length);
        Map<String, Object> m;
        for (int i = 0; i < load.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUT_NAME_TEXT, "Day " + i + 1 + " Load " + load[i]);
            m.put(ATTRIBUT_NAME_PB, load[i]);
            m.put(ATTRIBUT_NAME_LL, load[i]);
            data.add(m);
        }


        String from[] = new String[]{
                ATTRIBUT_NAME_TEXT, ATTRIBUT_NAME_PB, ATTRIBUT_NAME_LL};
        int to[] = new int[]{R.id.tvLoad, R.id.pbLoad, R.id.llLoad};

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        adapter.setViewBinder(new MyViewBinder());
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);



    }

    public class MyViewBinder implements SimpleAdapter.ViewBinder {
        int red = getResources().getColor(R.color.Red);
        int orange = getResources().getColor(R.color.Orange);
        int green = getResources().getColor(R.color.Green);

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {
            int i = 0;
            switch (view.getId()){
                //LinerLayout
                case R.id.llLoad:
                    i = ((Integer) data).intValue();
                    if(i<40)
                        view.setBackgroundColor(green);
                    else if (i<70)
                        view.setBackgroundColor(orange);
                    else
                        view.setBackgroundColor(red);
                    return true;
                //ProgressBar
                case R.id.pbLoad:
                    i = ((Integer)data).intValue();
                    ((ProgressBar)view).setProgress(i);
                    return true;
            }
            return false;
        }
    }
}
