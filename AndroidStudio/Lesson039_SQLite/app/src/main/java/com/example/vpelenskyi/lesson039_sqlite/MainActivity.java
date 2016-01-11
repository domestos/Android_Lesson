package com.example.vpelenskyi.lesson039_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "mylog";
    final String DB_NAME = "staff";
    //final int DB_VERSION = 1;
    final int DB_VERSION = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbh = new DBHelper(this, DB_NAME, null, DB_VERSION);
        SQLiteDatabase db = dbh.getWritableDatabase();
        Log.i(LOG_TAG, "-- " + DB_NAME + " db v." + DB_VERSION);
        writesStaff(db);

    }

    private void writesStaff(SQLiteDatabase db) {
        Cursor c = db.rawQuery("select * from people", null);
        logCursor(c, "Table people");
        c.close();

       c = db.rawQuery("select * from position", null);
        logCursor(c, "Table position");
        c.close();

        String sqlQuery = "SELECT PL.name AS Name, PS.name AS Position, PS.salary AS Salary " +
                "FROM people as PL " +
                "INNER JOIN position PS " +
                "ON PL.posid =  PS.id ";
        c = db.rawQuery(sqlQuery,null);
        logCursor(c, "INNER JOIN ");
        c.close();

    }

    private void logCursor(Cursor c, String title) {
        if (c != null) {
            if (c.moveToFirst()) {
                Log.i(LOG_TAG, title + ". " + c.getCount() + " row");
                StringBuilder sb = new StringBuilder();
                do {
                    sb.setLength(0);
                    for (String cn : c.getColumnNames()) {
                        sb.append(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.i(LOG_TAG, sb.toString());

                } while (c.moveToNext());
            }
        } else {
            Log.i(LOG_TAG, "Cursor is null");
        }
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(LOG_TAG, "--onCreat database --");
            String[] people_name = {"Иван", "Марья", "Петр", "Антон", "Даша",
                    "Борис", "Костя", "Игорь"};
            String[] people_positions = {"Программер", "Бухгалтер",
                    "Программер", "Программер", "Бухгалтер", "Директор",
                    "Программер", "Охранник"};

            ContentValues cv = new ContentValues();

            db.execSQL("CREATE TABLE people(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "position TEXT" +
                    ");");

            for (int i = 0; people_name.length > i; i++) {
                cv.clear();
                cv.put("name", people_name[i]);
                cv.put("position", people_positions[i]);
                db.insert("people", null, cv);

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(LOG_TAG, "-- onUpgrade dadtabase from" + oldVersion + " to " + newVersion + " version ---");

            int[] position_id = {1, 2, 3, 4};
            String[] position_name = {"Директор", "Программер",
                    "Бухгалтер", "Охранник"};
            int[] position_salary = {15000, 13000, 10000, 8000};
            ContentValues cv = new ContentValues();

            try {
                db.beginTransaction();
                db.execSQL("CREATE TABLE position(" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT," +
                        "salary INTEGER" +
                        ");");

                for (int i = 0; i < position_id.length; i++) {
                    cv.clear();
                    cv.put("id", position_id[i]);
                    cv.put("name", position_name[i]);
                    cv.put("salary", position_salary[i]);
                    db.insert("position", null, cv);
                }

                db.execSQL("alter table people add column posid integer;");
                for (int i = 0; position_id.length > i; i++) {
                    cv.clear();
                    cv.put("posid", position_id[i]);
                    db.update("people", cv, "position = ?", new String[]{position_name[i]});
                }

                db.execSQL("CREATE TEMPORARY TABLE people_tmp(" +
                        "id INTEGER," +
                        "name TEXT," +
                        "position TEXT," +
                        "posid INTEGER" +
                        ");");

                db.execSQL("INSERT INTO people_tmp select id, name, position, posid FROM people;");
                db.execSQL("DROP TABLE people;");

                db.execSQL("CREATE TABLE people(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT, " +
                        "posid INTEGER" +
                        ");");
                db.execSQL("INSERT INTO people select id, name , posid FROM people_tmp;");
                db.execSQL("DROP TABLE people_tmp;");

                db.setTransactionSuccessful();

            } catch (Exception e) {
                Log.e(LOG_TAG, " Error: "+e.getMessage());
            } finally {
                db.endTransaction();
            }
        }
    }
}

