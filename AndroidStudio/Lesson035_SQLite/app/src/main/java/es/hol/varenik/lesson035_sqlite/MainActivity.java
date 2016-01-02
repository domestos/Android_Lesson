package es.hol.varenik.lesson035_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edName, edEmail, edId;
    SQLiteOpenHelper DBHelper;
    int version = 1;
    String LOG_SQLITE = "LOGSQLite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper = new DBHelper(getApplicationContext(), "MyDataBase", null, version);


        edName = (EditText) findViewById(R.id.edName);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edId = (EditText) findViewById(R.id.edId);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnRead).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnUpdate).setOnClickListener(this);
        findViewById(R.id.btnDeleteId).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAdd:
                insert(db, cv);
                break;
            case R.id.btnRead:
                read(db);
                break;
            case R.id.btnClear:
                clear(db);
                break;
            case R.id.btnUpdate:
                String id = edId.getText().toString();
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                update(db, cv);
                break;
            case R.id.btnDeleteId:
                String id2 = edId.getText().toString();
                if (id2.equalsIgnoreCase("")) {
                    break;
                }
                delete(db);
                break;
        }


        db.close();
    }

    private void delete(SQLiteDatabase db) {
        String id = edId.getText().toString();
        int delCount = db.delete("nametable", "id = " + id, null);
        Log.i(LOG_SQLITE, "delete row count : "+ delCount);

    }

    private void insert(SQLiteDatabase db, ContentValues cv) {

        cv.put("name", edName.getText().toString());
        cv.put("email", edEmail.getText().toString());
        Log.i(LOG_SQLITE, "insert in data base:  cv " + cv.toString());

        long rowID = db.insert("nametable", null, cv);
        Log.i(LOG_SQLITE, "row inserted " + rowID);

    }

    private void read(SQLiteDatabase db) {

        Cursor c = db.query("nametable", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int idColIdex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int emailColIndex = c.getColumnIndex("email");

            do {
                Log.i(LOG_SQLITE, " id = " + c.getString(idColIdex) +
                        "name = " + c.getString(nameColIndex) +
                        "emil = " + c.getString(emailColIndex));
            } while (c.moveToNext());
            c.close();
        } else {
            Log.i(LOG_SQLITE, "row = 0");
        }

    }

    private void clear(SQLiteDatabase db) {
        db.delete("nametable", null, null);
    }

    private void update(SQLiteDatabase db, ContentValues cv) {
        cv.put("name", edName.getText().toString());
        cv.put("email", edEmail.getText().toString());

        int updCount = db.update("nametable", cv, "id = ?", new String[]{edId.getText().toString()});
        Log.i(LOG_SQLITE, "update row count : " + updCount);

    }
}
