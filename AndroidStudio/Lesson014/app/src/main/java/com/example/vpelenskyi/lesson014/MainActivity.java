package com.example.vpelenskyi.lesson014;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by v.pelenskyi on 10.12.2015.
 */
public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private CheckBox checkBox;
    private CheckBox checkXmlBox;
    private final int XML_GROUP = R.id.group_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.tv);
        checkBox = (CheckBox) findViewById(R.id.chbMenu);
        checkXmlBox = (CheckBox) findViewById(R.id.chbXmlMenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //id group; id item; order; text
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 4, "exit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();

        sb.append("Item Menu");
        sb.append("\r\n group_Id: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n item_Id: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + String.valueOf(item.getTitle()));
        textView.setText(sb.toString());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.setGroupVisible(1, checkBox.isChecked());
        menu.setGroupVisible(XML_GROUP, checkXmlBox.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }
}
