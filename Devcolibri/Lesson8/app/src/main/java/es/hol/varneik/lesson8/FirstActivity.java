package es.hol.varneik.lesson8;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by v.pelenskyi on 23.11.2015.
 */
public class FirstActivity extends Activity {
Button btnToest1, btnToest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        btnToest1 = (Button) findViewById(R.id.btnToest1);
        btnToest2 = (Button) findViewById(R.id.btnToest2);
    }

    public void onSoweToest1(View v){
        Toast toast = new Toast(getApplicationContext());
        toast.makeText(this, "You click on this button : "+btnToest1.getText().toString(),Toast.LENGTH_SHORT).show();
    }


    public void onSoweToest2(View v){
        //Toast has the static method makeText()
        Toast toast = Toast.makeText(this, "You click on this button : " + btnToest2.getText().toString(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 50);
        toast.show();


    }



}
