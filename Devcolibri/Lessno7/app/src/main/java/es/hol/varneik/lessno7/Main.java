package es.hol.varneik.lessno7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    private EditText etEmail, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPassword);
    }

    public void sendData(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("intentEmail", etEmail.getText().toString());
        intent.putExtra("intentPassword", etPass.getText().toString());
        startActivity(intent);
    }


}
