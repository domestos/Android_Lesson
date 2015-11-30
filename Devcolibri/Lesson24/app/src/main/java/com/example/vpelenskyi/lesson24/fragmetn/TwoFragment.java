package com.example.vpelenskyi.lesson24.fragmetn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vpelenskyi.lesson24.R;

/**
 * Created by v.pelenskyi on 30.11.2015.
 */
public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.two_fragment, null);
    }
}
