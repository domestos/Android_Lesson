package es.hol.varenik.lesson017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llMain;
    private RadioGroup rgGravity;
    private EditText etName;
    private Button btnCreate, btnClear;

    private int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(MainActivity.this);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                Toast.makeText(this,"Success create", Toast.LENGTH_SHORT).show();
                createBtn();
                break;

            case  R.id.btnClear:
                Toast.makeText(this,"Success remove", Toast.LENGTH_SHORT).show();
                clearBtn();
        }


    }

    private void clearBtn() {
        llMain.removeAllViews();
    }

    private void createBtn() {
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                wrapContent, wrapContent);
        int btnGravity = Gravity.LEFT;

        switch (rgGravity.getCheckedRadioButtonId()){
            case R.id.rbLeft:
                btnGravity = Gravity.LEFT;
                break;
            case  R.id.rbCenter:
                btnGravity = Gravity.CENTER_HORIZONTAL;
                break;
            case  R.id.rbRight:
                btnGravity = Gravity.RIGHT;
                break;
        }
        lParams.gravity = btnGravity;

        Button btnNew = new Button(this);
        btnNew.setText(etName.getText().toString());
        llMain.addView(btnNew, lParams);


    }
}
