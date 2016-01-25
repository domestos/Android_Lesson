package com.example.vpelenskyi.lesson052_cursoradapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by v.pelenskyi on 25.01.2016.
 */
public class DB {
    private static final String DB_NAME = "mydb";
    private static final String DB_TABLE = "mytable";
    private static final int DB_VERSION = 1;

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMG = "_img";
    public static final String COLUMN_TEXT = "mytab";

    private static final String DB_CREATE = "CREATE TABLE " + DB_TABLE + " ( " +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_IMG + " INTEGER, " +
            COLUMN_TEXT + " TEXT " +
            ");";


    private final Context mCtx;

    public DB(Context mCtx) {
        this.mCtx = mCtx;
    }

    private DBHelper dbHelper;
    private SQLiteDatabase mDB;

    public void opne() {
        dbHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    public Cursor getAllData() {
        return mDB.query(DB_TABLE, null, null, null, null, null, null);
    }

    public void addRec(String text, int img) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TEXT, text);
        cv.put(COLUMN_IMG, img);
        mDB.insert(DB_TABLE, null, cv);
    }

    public void deleRec(long id) {
        mDB.delete(DB_TABLE, COLUMN_ID + " =" + id, null);
    }


    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);

            ContentValues cv = new ContentValues();
            for (int i = 1; i < 5; i++) {
                cv.put(COLUMN_TEXT, "sometext " + i);
                cv.put(COLUMN_IMG, R.drawable.ic_3d_rotation_24dp);
                db.insert(DB_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
