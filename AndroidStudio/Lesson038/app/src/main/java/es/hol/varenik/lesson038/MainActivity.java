package es.hol.varenik.lesson038;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public String LOG_TAG = "LOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbh = new DBHelper(this);
        myActions(dbh);


    }

    private void myActions(DBHelper dbh) {
        SQLiteDatabase db = dbh.getWritableDatabase();
        SQLiteDatabase db2 = dbh.getWritableDatabase();
        Log.i(LOG_TAG, " db = db2 - " + db.equals(db2));
        Log.i(LOG_TAG, " db.isOpen = " + db.isOpen() + "\n db2.isOpen = " + db2.isOpen());
        db2.close();
        Log.i(LOG_TAG, " after closed db2: \n " +
                "db.isOpen = " + db.isOpen() + "\n db2.isOpen = " + db.isOpen());


    }

//    private void myActions(DBHelper dbh) {
//        SQLiteDatabase db = dbh.getWritableDatabase();
//        delete(db, "mytable");
//        insert(db, "mytable", "val1");
//        read(db, "mytable");
//        dbh.close();
//    }


//    private void myActions(DBHelper dbh) {
//        SQLiteDatabase db = dbh.getWritableDatabase();
//        delete(db, "mytable");
//        db.beginTransaction();
//        //this value was not insert,
//        //because we must to specify the database that the transaction was successful
//        insert(db, "mytable", "val1");
//        db.endTransaction();
//        insert(db, "mytable", "val2");
//        read(db, "mytable");
//        dbh.close();
//    }


//    private void myActions(DBHelper dbh) {
//        SQLiteDatabase db = dbh.getWritableDatabase();
//        delete(db, "mytable");
//        db.beginTransaction();
//        insert(db, "mytable", "val1");
//        db.setTransactionSuccessful();
//        // we try Insert value after  setTransactionSuccessful(),
//        // this value was inserted, but it is WRONG
//        insert(db, "mytable", "val2");
//        db.endTransaction();
//        insert(db, "mytable", "val3");
//        read(db, "mytable");
//        dbh.close();
//    }

//    private void myActions(DBHelper dbh) {
//        try {
//            SQLiteDatabase db = dbh.getWritableDatabase();
//            delete(db, "mytable");
//
//            db.beginTransaction();
//            insert(db, "mytable", "val1");
//            // when we open transaction  the database is locked,
//            // and we canot creat new connection with databece
//            Log.i(LOG_TAG, "--- CREATE NEW DBHelper)");
//            DBHelper dbh2 = new DBHelper(this);
//            Log.i(LOG_TAG, "--- get DB2");
//            SQLiteDatabase db2 = dbh2.getWritableDatabase();
//            read(db2, "mytable");
//            db2.close();
//
//            db.setTransactionSuccessful();
//            db.endTransaction();
//            read(db, "mytable");
//            dbh.close();
//        } catch (Exception e) {
//
//            Log.i(LOG_TAG, e.getClass() + " Error:  " + e.getMessage());
//        }
//    }


    private void read(SQLiteDatabase db, String mytable) {
        Log.i(LOG_TAG, "Method READ");
        Cursor c;
        c = db.query(mytable, null, null, null, null, null, null);
        if (c != null) {
            Log.i(LOG_TAG, "Records count in table: " + c.getCount());
            if (c.moveToFirst()) {
                do {
                    Log.i(LOG_TAG, c.getString(c.getColumnIndex("val")));
                } while (c.moveToNext());
            }
            c.close();
        }
    }

    private void insert(SQLiteDatabase db, String mytable, String value) {
        Log.i(LOG_TAG, "Method INSERT value = " + value);
        ContentValues cv = new ContentValues();
        cv.put("val", value);
        db.insert(mytable, null, cv);
    }

    private void delete(SQLiteDatabase db, String mytable) {
        Log.i(LOG_TAG, "Method DELETE");
        db.delete(mytable, null, null);
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "NameDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(LOG_TAG, "-- create DB");
            db.execSQL("CREATE TABLE mytable(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "val TEXT" +
                    ");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
