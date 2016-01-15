package com.example.vpelenskyi.lesson041_inflater;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] name = {"Ivan", "Mark", "Daniel", "Valera", "Igor", "Volodia", "Sofa", "Ira"};
    String[] position = {"developer", "QA", "Project Men", "Time Lid", "Security", "SysAdmin", "Clerk", "Boss"};
    int[] salary = {20000, 15000, 30000, 30000, 10000, 300000, 100000, 500000};

    int[] colors = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linLayout);

        LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; name.length > i; i++) {
            Log.d("myLog", "i = " + i);
            View item = inflater.inflate(R.layout.item, linearLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);

            TextView tvPosition = (TextView) item.findViewById(R.id.tvPositiion);
            tvPosition.setText("Position: " + position[i]);

            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("Salary: " + String.valueOf(salary[i]));

            item.getLayoutParams().width = ActionBar.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linearLayout.addView(item);
        }
    }
}
