package com.example.vpelenskyi.lesson26;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vpelenskyi.lesson26.fragment.LastFragment;

public class MainActivity extends FragmentActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        initFragmentLast();

    }

    private void initFragmentLast() {
        transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, new LastFragment());
        transaction.commit();
    }

    public void onClickFragmentButton(View view) {
        textView = (TextView) findViewById(R.id.text_container_fragment);
        editText = (EditText) findViewById(R.id.etFirstFragment);
        textView.setText(editText.getText());

    }

}
