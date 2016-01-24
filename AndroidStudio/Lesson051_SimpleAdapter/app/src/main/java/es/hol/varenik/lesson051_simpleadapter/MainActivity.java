package es.hol.varenik.lesson051_simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final int CM_DELETE_ID = 1;
    private static final int CM_EDIT_ID = 2;
    final String ATTRIBUT_NAME_TEXT = "text";
    final String ATTRIBUT_NAME_IMAGE = "image";

    ListView lvSimple;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUT_NAME_TEXT, "sometext " + (data.size()));
            m.put(ATTRIBUT_NAME_IMAGE, R.drawable.ic_3d_rotation_24dp);
            data.add(m);
        }

        String[] from = new String[]{ATTRIBUT_NAME_TEXT, ATTRIBUT_NAME_IMAGE};
        int to[] = new int[]{R.id.itemText, R.id.itemImae};
        sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);

        registerForContextMenu(lvSimple);
    }

    public void onButtonClick(View v) {
        m = new HashMap<String, Object>();
        m.put(ATTRIBUT_NAME_TEXT, "sometext " + (data.size()));
        m.put(ATTRIBUT_NAME_IMAGE, R.drawable.ic_3d_rotation_24dp);
        data.add(m);
        sAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Delete item");
        menu.add(0, CM_EDIT_ID, 0, "Edit item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == CM_DELETE_ID) {
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo)
                    item.getMenuInfo();
            data.remove(acmi.position);
            sAdapter.notifyDataSetChanged();

            return true;
        }else if(item.getItemId() == CM_EDIT_ID){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo)
                    item.getMenuInfo();
              Map<String, Object> m =   data.get(acmi.position);
                m.clear();
                m.put(ATTRIBUT_NAME_IMAGE,R.drawable.ic_3d_rotation_24dp);
                m.put(ATTRIBUT_NAME_TEXT, "my position "+acmi.position);


            Log.i("position", "pos = " +data.toString());
            sAdapter.notifyDataSetChanged();

        return true;
        }
        return super.onContextItemSelected(item);
    }
}
