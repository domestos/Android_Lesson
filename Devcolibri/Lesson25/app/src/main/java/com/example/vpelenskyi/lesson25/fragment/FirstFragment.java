package com.example.vpelenskyi.lesson25.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vpelenskyi.lesson25.R;

/**
 * Created by v.pelenskyi on 30.11.2015.
 */
public class FirstFragment extends Fragment {

    public static final String TAG = "firstFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, null);
    }
}
