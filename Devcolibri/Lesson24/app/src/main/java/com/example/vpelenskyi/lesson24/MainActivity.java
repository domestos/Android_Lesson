package com.example.vpelenskyi.lesson24;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.vpelenskyi.lesson24.fragmetn.OneFragment;
import com.example.vpelenskyi.lesson24.fragmetn.TwoFragment;

public class MainActivity extends FragmentActivity {

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
    }

    public void onClickFragment(View view){
        transaction = manager.beginTransaction();
        // TODO: 30.11.2015
        switch (view.getId()){
            case R.id.btn_add :
                transaction.add(R.id.conteiner, oneFragment);
        }
        transaction.commit();


    }

}
