package com.example.vpelenskyi.lesson19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onAbout(MenuItem item){
        Toast.makeText(this, "you  push this button - > | " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_setting :
                Toast.makeText(this, "you  push this button - > | " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
//            case R.id.item_about :
//                Toast.makeText(this, "you  push this button - > | " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
//                break;
            case R.id.item_user:
                Toast.makeText(this, "you  push this button - > | " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
