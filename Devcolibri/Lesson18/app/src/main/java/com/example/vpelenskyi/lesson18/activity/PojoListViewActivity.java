package com.example.vpelenskyi.lesson18.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.vpelenskyi.lesson18.R;
import com.example.vpelenskyi.lesson18.adapter.PhoneModelAdapter;
import com.example.vpelenskyi.lesson18.pojo.PhoneModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.pelenskyi on 26.11.2015.
 */
public class PojoListViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pojo_listview_activity);

        ListView listView = (ListView) findViewById(R.id.lvPojoMobile);
        PhoneModelAdapter adapter = new PhoneModelAdapter(this, initData());
        listView.setAdapter(adapter);
    }

    private List<PhoneModel> initData() {

        List<PhoneModel> phoneModels = new ArrayList<>();

        phoneModels.add(new PhoneModel(1, "Samsung", 350));
        phoneModels.add(new PhoneModel(2, "HTC", 330));
        phoneModels.add(new PhoneModel(3, "iPhone", 500));
        phoneModels.add(new PhoneModel(4, "LG", 250));

        return phoneModels;
    }
}
