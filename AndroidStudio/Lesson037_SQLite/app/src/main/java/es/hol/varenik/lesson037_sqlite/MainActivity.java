package es.hol.varenik.lesson037_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Подключаемся к БД
        DBHelper dbh = new DBHelper(this, "NameDB", null, 1);
        SQLiteDatabase db = dbh.getWritableDatabase();
        Cursor c;

        // ==================== SHOW Table position
        Log.i(LOG_TAG, "------ SHOW Table position");
        c = db.query("position", null, null, null, null, null, null);
        logCursor(c);
        c.close();

        // ==================== SHOW Table people
        Log.i(LOG_TAG, "------ SHOW Table people");
        c = db.query("people", null, null, null, null, null, null);
        logCursor(c);
        c.close();

        // ==================== SHOW JOIN TABLES use rawQuery  where salary >12000
        Log.i(LOG_TAG, "----- JOIN TABLE whit rawQuery where salary >12000");
        String sqlQuery = "SELECT PL.name AS Name, PS.name AS Position, salary AS Salary "  +
                "FROM people AS PL " +
                "INNER JOIN position AS PS " +
                "on PL.id_pos  = PS.id " +
                "WHERE salary >?";
        c = db.rawQuery(sqlQuery, new String[]{"12000"});
        logCursor(c);
        c.close();

        // ==================== SHOW JOIN TABLES use query  where salary <12000
        Log.i(LOG_TAG, "----- JOIN TABLE whit QUERY where salary >12000");
        String table = "people AS PL INNER JOIN position AS PS ON PL.id_pos = PS.id ";
        String[] column = {"PL.name AS Name", "PS.name AS Position", "salary AS Salary"};
        String selection = "salary < ?";
        String[] selectionArgs = new String[]{"12000"};
        c =  db.query(table, column, selection, selectionArgs, null, null, null);
        logCursor(c);
        c.close();


    }

    private void logCursor(Cursor c) {

        if (c != null) {
            if (c.moveToFirst()) {
                String srt;

                do {
                    srt = "";
                    for (String columnName : c.getColumnNames()) {
                        srt = srt.concat(columnName + " = " + c.getString(c.getColumnIndex(columnName)) + " ; ");
                    }
                    Log.i(LOG_TAG, srt);

                } while (c.moveToNext());

            }
        }


    }


}

class DBHelper extends SQLiteOpenHelper {

    final String LOG_TAG = "myLogs";

    // данные для таблицы должностей
    int[] position_id = {1, 2, 3, 4};
    String[] position_name = {"Директор", "Программер", "Бухгалтер", "Охранник"};
    int[] position_salary = {15000, 13000, 10000, 8000};

    // данные для таблицы людей
    String[] people_name = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь"};
    int[] people_posid = {2, 3, 2, 2, 3, 1, 2, 4};

    ContentValues cv = new ContentValues();

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table position
        db.execSQL("CREATE TABLE position(" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "salary INTEGER" +
                ");");

        // inset db
        for (int i = 0; i < position_id.length; i++) {
            cv.clear();
            cv.put("id", position_id[i]);
            cv.put("name", position_name[i]);
            cv.put("salary", position_salary[i]);
            db.insert("position", null, cv);
            Log.i(LOG_TAG, "insert this in table position: " + cv);
        }

        //create table person
        db.execSQL("CREATE TABLE people(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "id_pos INTEGER" + ");");

        //insert table people
        for (int i = 0; i < people_name.length; i++) {
            cv.clear();
            cv.put("name", people_name[i]);
            cv.put("id_pos", people_posid[i]);
            db.insert("people", null, cv);
            Log.i(LOG_TAG, "insert this in table people: " + cv);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}