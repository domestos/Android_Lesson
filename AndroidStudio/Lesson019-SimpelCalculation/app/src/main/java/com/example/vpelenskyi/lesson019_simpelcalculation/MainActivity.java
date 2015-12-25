package com.example.vpelenskyi.lesson019_simpelcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    Button plus, minus, multiplication;
    EditText ed1, ed2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);

        tvResult = (TextView) findViewById(R.id.tvResult);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiplication = (Button) findViewById(R.id.multiplication);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiplication.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (!TextUtils.isEmpty(ed1.getText().toString()) || !TextUtils.isEmpty(ed2.getText().toString())) {
            switch (v.getId()) {
                case R.id.plus:
                    tvResult.setText("" + (Integer.valueOf(ed1.getText().toString())
                            + Integer.valueOf(ed2.getText().toString())));
                    break;
                case R.id.minus:
                    tvResult.setText("" + (Integer.valueOf(ed1.getText().toString())
                            - Integer.valueOf(ed2.getText().toString())));
                    break;
                case R.id.multiplication:
                    tvResult.setText("" + (Integer.valueOf(ed1.getText().toString())
                            * Integer.valueOf(ed2.getText().toString())));
                    break;

            }
        } else {
            Toast.makeText(getApplicationContext(), "can't be empty", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case MENU_RESET_ID:
                ed1.setText("");
                ed2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
