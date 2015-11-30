package com.example.vpelenskyi.lesson25;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.vpelenskyi.lesson25.fragment.FirstFragment;
import com.example.vpelenskyi.lesson25.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment;
    SecondFragment secondFragment;
    FragmentManager manager;
    FragmentTransaction transaction;
    Switch isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        isChecked = (Switch) findViewById(R.id.switchBackSteck);
    }


    public void onClikeBtnFragment(View v) {
        transaction  =  manager.beginTransaction();
        switch (v.getId()){

            case R.id.btn_add :
    //          transaction.add(R.id.container , new FirstFragment(), FirstFragment.TAG);
                if(manager.findFragmentByTag(FirstFragment.TAG)== null){
                    transaction.add(R.id.container , firstFragment, FirstFragment.TAG);
                }

                break;

            case R.id.btn_remove :
    //          transaction.remove(manager.findFragmentByTag(FirstFragment.TAG));
                if(manager.findFragmentByTag(FirstFragment.TAG) != null){
                    transaction.remove(firstFragment);
                }

                if(manager.findFragmentByTag(SecondFragment.TAG) != null){
                    transaction.remove(secondFragment);
                }
                break;

            case R.id.btn_replace :
                if(manager.findFragmentByTag(FirstFragment.TAG) != null){
                    transaction.replace(R.id.container, secondFragment , SecondFragment.TAG);
                }

                if(manager.findFragmentByTag(SecondFragment.TAG) != null){
                    transaction.replace(R.id.container, firstFragment, FirstFragment.TAG);
                }
                break;

        }

        if(isChecked.isChecked()){
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }
}
