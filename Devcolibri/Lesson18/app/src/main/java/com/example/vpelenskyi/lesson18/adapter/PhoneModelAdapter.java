package com.example.vpelenskyi.lesson18.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vpelenskyi.lesson18.R;
import com.example.vpelenskyi.lesson18.pojo.PhoneModel;

import java.util.List;

/**
 * Created by v.pelenskyi on 26.11.2015.
 */
public class PhoneModelAdapter extends BaseAdapter {


    private List<PhoneModel> list;
    private LayoutInflater layoutInflater;

    public PhoneModelAdapter(Context context, List<PhoneModel> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        }
        TextView ltPojoItem = (TextView) view.findViewById(R.id.ltPojoItem);
        PhoneModel phoneModel = getPhoneModel(position);

        ltPojoItem.setText(phoneModel.getName()+"        price : "+phoneModel.getPrice()+" y.o.");
        return view;

    }

    private PhoneModel getPhoneModel(int position){
        return  (PhoneModel)getItem(position);
    }
}
