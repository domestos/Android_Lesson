package com.example.vpelenskyi.lesson033_sharepreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String SAVED_FNAME = "fname";
    private static final String SAVED_LNAME = "lname";
    SharedPreferences sPref;
    EditText etFname, etLname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFname = (EditText) findViewById(R.id.edFname);
        etLname = (EditText) findViewById(R.id.edLname);

        findViewById(R.id.btnLoad).setOnClickListener(this);
        findViewById(R.id.btnSave).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLoad:
                loadText();
                break;

            case R.id.btnSave:
                saveText();
                break;

            default:
                break;
        }
    }

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_FNAME,  etFname.getText().toString());
        ed.putString(SAVED_LNAME,  etLname.getText().toString());
        ed.commit();
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String fname = sPref.getString(SAVED_FNAME,"");
        etFname.setText(fname);

        String lname = sPref.getString(SAVED_LNAME, "");
        etLname.setText(lname);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
