package com.example.vpelenskyi.lesson015;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvColor, tvSize;

    private final int MENU_COLOR_CYAN = 1;
    private final int MENU_SIZE_80 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);

        switch (v.getId()) {
            case R.id.tvColor:
                menu.setGroupVisible(R.id.group_color, true);
                menu.setGroupVisible(R.id.group_size, false);
                //group id, item id, order, title
                menu.add(R.id.group_color, MENU_COLOR_CYAN, 100, "COLOR PURPUL");

                break;
            case R.id.tvSize:
                menu.setGroupVisible(R.id.group_color, false);
                menu.setGroupVisible(R.id.group_size, true);
                //group id, item id, order, title
                menu.add(0, MENU_SIZE_80, 100, "size 80dp");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        setSize(item);
        setColor(item);
        return super.onContextItemSelected(item);
    }

    private void setColor(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.color_blue:
                tvColor.setTextColor(Color.BLUE);
                break;
            case R.id.color_green:
                tvColor.setTextColor(Color.GREEN);
                break;
            case R.id.color_red:
                tvColor.setTextColor(Color.RED);
                break;
            case MENU_COLOR_CYAN:
                tvColor.setTextColor(Color.CYAN);
                break;
        }
    }


    private void setSize(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.size_20dp:
                tvSize.setTextSize(20);
                break;
            case R.id.size_40dp:
                tvSize.setTextSize(40);
                break;
            case R.id.size_60dp:
                tvSize.setTextSize(60);
                break;
            case MENU_SIZE_80:
                tvSize.setTextSize(80);
                break;

        }
    }
}
