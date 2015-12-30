package es.hol.varenik.lesson034_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by varenik on 30.12.15.
 */
public class DBHelper extends SQLiteOpenHelper {
    String SQLOG = "SQLite_log";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(SQLOG, "-- creat data base --");
        db.execSQL("CREATE TABLE mytable (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name text," +
                "email text" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
