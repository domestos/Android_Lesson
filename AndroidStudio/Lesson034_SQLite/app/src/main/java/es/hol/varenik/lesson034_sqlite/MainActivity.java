package es.hol.varenik.lesson034_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etEmail;
    DBHelper dbHelper;
    String SQLOG = "SQLite_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.email);
        etName = (EditText) findViewById(R.id.name);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnRead).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);

        dbHelper = new DBHelper(getApplicationContext(), "myDB", null, 1);


    }

    @Override
    public void onClick(View v) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAdd:
                insert(db, cv);
                break;
            case R.id.btnRead:
                select(db);
                break;
            case R.id.btnClear:
                clear(db);
                break;

        }
        dbHelper.close();

    }

    private void clear(SQLiteDatabase db) {
        Log.i(SQLOG, "--- clear mytable---");
        int clearCount = db.delete("mytable", null, null);
        Log.i(SQLOG, "clear count = " + clearCount);
    }

    private void select(SQLiteDatabase db) {
        Cursor c = db.query("mytable", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int emailColIndex = c.getColumnIndex("email");

            do {
                Log.i(SQLOG, "ID = " + c.getInt(idColIndex)
                        + " name : " + c.getString(nameColIndex)
                        + " email: " + c.getString(emailColIndex));
            } while (c.moveToNext());

        } else {
            Log.i(SQLOG, "rowID = 0");
        }
        c.close();
    }

    private void insert(SQLiteDatabase db, ContentValues cv) {
        Log.i(SQLOG, "--- Insert in mytable ---");

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();


        cv.put("name", name);
        cv.put("email", email);

        Log.i(SQLOG,  "cv :" + cv.toString());

        long rowId = db.insert("mytable", null, cv);
        Log.i(SQLOG, "row inserted, ID = " + rowId);
    }
}
