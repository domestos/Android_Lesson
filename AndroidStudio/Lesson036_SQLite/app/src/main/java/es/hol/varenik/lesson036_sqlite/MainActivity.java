package es.hol.varenik.lesson036_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String SQL_LOG = "SQL_LOG";

    String names[] = {"Китай", "США", "Бразилия", "Россия", "Япония",
            "Германия", "Египет", "Италия", "Франция", "Канада"};
    int peoples[] = {1400, 311, 195, 142, 128, 82, 80, 60, 66, 35};
    String regions[] = {"Азия", "Америка", "Америка", "Европа", "Азия",
            "Европа", "Африка", "Европа", "Европа", "Америка"};


    EditText edPeoples, edFunction, edPeopleWhere;
    Button btnAll;

    RadioGroup rGroup;
    RadioButton rbName, rbPeople, rbReion;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edFunction = (EditText) findViewById(R.id.edFunction);
        edPeoples = (EditText) findViewById(R.id.edPeoples);
        edPeopleWhere = (EditText) findViewById(R.id.edPeoplesOnRegWhere);

        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rbName = (RadioButton) findViewById(R.id.rbNames);
        rbPeople = (RadioButton) findViewById(R.id.rbPeoples);
        rbReion = (RadioButton) findViewById(R.id.rbRegions);

        btnAll = (Button) findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);
        findViewById(R.id.btnFunction).setOnClickListener(this);
        findViewById(R.id.btnPeoples).setOnClickListener(this);
        findViewById(R.id.btnPeopleOnRegion).setOnClickListener(this);
        findViewById(R.id.btnPeopleOnRegionWhere).setOnClickListener(this);
        findViewById(R.id.btnOrder).setOnClickListener(this);


        dbHelper = new DBHelper(this, "DataBase", null, 1);
        db = dbHelper.getWritableDatabase();

        Cursor c = db.query("nameTable", null, null, null, null, null, null);
        if (c.getCount() == 0) {
            Log.i(SQL_LOG, "-- Creat Data Base --");
            ContentValues cv = new ContentValues();
            for (int i = 0; i < names.length; i++) {
                cv.put("name", names[i]);
                cv.put("people", peoples[i]);
                cv.put("region", regions[i]);
                db.insert("nameTable", null, cv);
            }
        }
        c.close();
        dbHelper.close();
        onClick(btnAll);
    }

    @Override
    public void onClick(View v) {
        db = dbHelper.getWritableDatabase();

        String sFunc = edFunction.getText().toString();
        String sPeoples = edPeoples.getText().toString();
        String sRegionPeople = edPeopleWhere.getText().toString();

        String colums[] = null;
        String selection = null;
        String selectionArgs[] = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor c = null;

        switch (v.getId()) {
            case R.id.btnAll:
                Log.i(SQL_LOG, "-- All info --");
                c = db.query("nameTable", null, null, null, null, null, null);
                break;
            case R.id.btnFunction:
                Log.i(SQL_LOG, "-- Function -- ");
                colums = new String[]{sFunc};
                c = db.query("nameTable", colums, null, null, null, null, null);
                break;
            case R.id.btnPeoples:
                Log.i(SQL_LOG, "-- where peoples more > " + edPeopleWhere + "-- ");
                selection = "people > ?";
                selection = "people > ?";
                selectionArgs = new String[]{sPeoples};
                c = db.query("nameTable", null, selection, selectionArgs, null, null, null);
                break;
            case R.id.btnPeopleOnRegion:
                Log.i(SQL_LOG, "-- Group --> ");
                colums = new String[]{"region", "SUM(people) as people"};
                groupBy = "region";
                c = db.query("nameTable", colums, null, null, groupBy, null, null);
                break;
            case R.id.btnPeopleOnRegionWhere:
                Log.i(SQL_LOG, "-- Region where people more " + edPeopleWhere + ">--> ");
                colums = new String[]{"region", "SUM(people) as people"};
                groupBy = "region";
                having = "SUM(people) > " + sRegionPeople;
                c = db.query("nameTable", colums, null, null, groupBy, having, null);
                break;
            case R.id.btnOrder:
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.rbNames:
                        Log.i(SQL_LOG, "-- sorted on name --");
                        orderBy = "name";
                        break;

                    case R.id.rbPeoples:
                        Log.i(SQL_LOG, "-- sorted on people --");
                        orderBy = "people";
                        break;

                    case R.id.rbRegions:
                        Log.i(SQL_LOG, "-- sorted on region --");
                        orderBy = "region";
                        break;
                }
                c = db.query("nameTable", null, null, null, null, null, orderBy);
                break;
        }//end switch


        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + "=" + c.getString(c.getColumnIndex(cn)));
                    }
                    Log.i(SQL_LOG, str);
                } while (c.moveToNext());
            }
            c.close();
        } else {
            Log.i(SQL_LOG, "Cursor null");
            dbHelper.close();
        }


    }//end onClick

}
