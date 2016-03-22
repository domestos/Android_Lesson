package com.example.vpelenskyi.lesson104;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwoo extends Fragment {
    private final String TAG_LOG = "myLog";

    //==========    CREATED
    /**
     * фрагмент прикріплений до активності і отримує посилання на нього.
     * Надалі ми завжди можемо отримати посилання на активність, викликавши метод getActivity ().
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG_LOG, "FragmentTwoo onAttach");

    }

    /**
     * це аналог методу OnCreate у Activity, але тут ми поки не має доступу до UI-елементів
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG_LOG, "FragmentTwoo onCreate");
    }

    /**
     * тут ви створюєте вигляд, який буде вмістом фрагмента, і віддаєте його системі
     * Далі спрацьовують метод Activity  - OnCreate, після нього метод  onActivityCreated
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG_LOG, "FragmentTwoo onCreateView");
        return inflater.inflate(R.layout.fragment_twoo,null);

    }

    /**
     * повідомляє фрагменту про те, що активність створено і можна працювати з UI-елементами
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG_LOG, "FragmentTwoo onActivityCreated");
    }

    /**
     * ДАЛІ метод Activity - onStart
     * після нього наш onStart -  аналогічний методу активність, фрагмент стає видимим користувачеві
     */
    //==========    STARTED
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG_LOG, "FragmentTwoo onStart");
    }

    /**
     * ДАЛІ метод Activity - onResume,
     * після нього наш onResume - аналогічний методу Activity, фрагмент доступний для взаємодії.
     */
    //==========    RESUME
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG_LOG, "FragmentTwoo onResume");
    }

    //==========    PAUSE
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG_LOG, "FragmentTwoo onPause");
    }

    //==========    STOP
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG_LOG, "FragmentTwoo onStop");
    }

    //==========    DESTROY_VIEW

    /**
     * onDestroyView -повідомляє нам, що вид, який ми створювали в onCreateView, вже недоступний
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG_LOG, "FragmentTwoo onDestroyView");
    }

    //==========    DESTROY

    /**
     * OnDestroy - аналог методу OnDestroy у Activity
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG_LOG, "FragmentTwoo onDestroy");
    }

    //==========    DETACH

    /**
     * onDetach - фрагмент від'єднаний від активності
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG_LOG, "FragmentTwoo onDetach");
    }
}
