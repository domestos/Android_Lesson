package es.hol.varneik.lessno7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tvEmail, tvPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_layout);

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPass = (TextView) findViewById(R.id.tvPass);

        tvEmail.setText(getIntent().getStringExtra("intentEmail"));
        tvPass.setText(getIntent().getStringExtra("intentPassword"));


    }
    public void back(View v){
        Intent intent =  new Intent(this, Main.class);
        startActivity(intent);
    }

}
