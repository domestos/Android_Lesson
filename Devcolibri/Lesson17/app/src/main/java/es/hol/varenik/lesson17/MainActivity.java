package es.hol.varenik.lesson17;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  exsplicitCall(View v){
        Intent intent = new Intent(this, CurrentDateActivity.class);
        startActivity(intent);

    }

    public void implicitCall(View v){
        Intent intent = new Intent("es.hol.varenik.lesson17.SiteActivity.Varenik");
        startActivity(intent);
    }


    public void openContacts(View v){
        Intent intent  = new Intent();
        intent.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
        startActivity(intent);
    }
}
