package com.example.vpelenskyi.lesson104;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {
    private final String TAG_LOG = "myLog";

    //==========    CREATED
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG_LOG, "FragmentOne onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG_LOG, "FragmentOne onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG_LOG, "FragmentOne onCreateView");
        return inflater.inflate(R.layout.fragment_one, null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG_LOG, "FragmentOne onActivityCreated");
    }

    //==========    STARTED
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG_LOG, "FragmentOne onStart");
    }


    //==========    RESUME
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG_LOG, "FragmentOne onResume");
    }

    //==========    PAUSE
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG_LOG, "FragmentOne onPause");
    }

    //==========    STOP
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG_LOG, "FragmentOne onStop");
    }

    //==========    DESTROY_VIEW
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG_LOG, "FragmentOne onDestroyView");
    }

    //==========    DESTROY
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG_LOG, "FragmentOne onDestroy");
    }

    //==========    DETACH
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG_LOG, "FragmentOne onDetach");
    }
}
