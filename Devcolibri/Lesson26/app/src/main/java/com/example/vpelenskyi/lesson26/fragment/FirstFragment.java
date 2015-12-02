package com.example.vpelenskyi.lesson26.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vpelenskyi.lesson26.R;

/**
 * Created by v.pelenskyi on 02.12.2015.
 */
public class FirstFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onStart() {

        super.onStart();
        Button button = (Button) getActivity().findViewById(R.id.btn_first1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TextView textView = (TextView) getActivity().findViewById(R.id.text_container_fragment);
               EditText editText = (EditText) getActivity().findViewById(R.id.etFirstFragment);
                textView.setText(editText.getText());
            }
        });

    }
}
