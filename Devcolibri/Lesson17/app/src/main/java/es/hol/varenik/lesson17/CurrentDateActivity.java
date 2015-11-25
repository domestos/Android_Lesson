package es.hol.varenik.lesson17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class CurrentDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_date);
        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setText(Calendar.getInstance().getTime().toString());
    }
}
