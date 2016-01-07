package es.hol.varenik.lesson036_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by varenik on 03.01.16.
 */
public class DBHelper extends SQLiteOpenHelper {
    String SQL_LOG = "SQL_LOG";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE nameTable(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "people INTEGER," +
                "region TEXT" +
                ");");
        Log.i(SQL_LOG, "Class DBHelper created db");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
