package com.example.vpelenskyi.lesson26.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vpelenskyi.lesson26.R;

/**
 * Created by v.pelenskyi on 02.12.2015.
 */
public class LastFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.last_fragment, container, false);
    }
}
