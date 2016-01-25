package com.example.vpelenskyi.lesson052_cursoradapter;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int CM_DELETE_ID = 1;
    DB db;
    ListView lvCursor;
    SimpleCursorAdapter scAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DB(this);
        db.opne();

        cursor = db.getAllData();
        startManagingCursor(cursor);

        String[] from = new String[]{DB.COLUMN_IMG, DB.COLUMN_TEXT};
        int[] to = new int[]{R.id.itemImage, R.id.itemText};

        scAdapter = new SimpleCursorAdapter(this,R.layout.item,cursor ,from,to);
        lvCursor = (ListView) findViewById(R.id.lvCursor);
        lvCursor.setAdapter(scAdapter);

        registerForContextMenu(lvCursor);

    }

    public void onButtonClick(View v) {
        db.addRec("sometext " + (cursor.getCount() + 1), R.drawable.ic_3d_rotation_24dp);
        cursor.requery();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Delete this Item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == CM_DELETE_ID){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            db.deleRec(acmi.id);
            cursor.requery();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
