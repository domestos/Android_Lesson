package com.example.vpelenskyi.lesson136_cursorloader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    DB db;
    SimpleCursorAdapter scAdapter;
    ListView lvData;
    final int CM_DELETE_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DB(this);
        db.open();

        String[] from = new String[]{db.COLUMN_TXT, db.COLUMN_IMG};
        int[] to = new int[]{R.id.itemText, R.id.itemImage};

        scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);

        lvData = (ListView) findViewById(R.id.lvData);
        lvData.setAdapter(scAdapter);

        registerForContextMenu(lvData);

        getSupportLoaderManager().initLoader(0, null, this);


    }

    public void onClickAdd(View v){
        ContentValues cv = new ContentValues();
        db.addRec("SomeText"+(scAdapter.getCount() +1),R.drawable.ic_account_balance_24dp);
        getSupportLoaderManager().getLoader(0).forceLoad();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,CM_DELETE_ID,0,"Delete item");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == CM_DELETE_ID){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            db.deleRec(acmi.id);
        }
        return super.onContextItemSelected(item);

    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (db != null) {

            return new MyCursorLoader(this, db);
        } else {
            System.out.println("db = null");
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        scAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    //Attention!! this class must be static
    static class MyCursorLoader extends CursorLoader {

        DB db;

        public MyCursorLoader(Context context, DB db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            Cursor cursor = db.getAllData();
            // when use timeUnit we can see how CoursorLoader works asynchronously
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return cursor;

            //return super.loadInBackground();
        }
    }
}
