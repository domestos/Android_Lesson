package es.hol.varenik.lesson016;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by varenik on 10.12.15.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams  layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout, layoutParams);


        ViewGroup.LayoutParams LP_WRAP_WRAP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams LP_MATCH_WRAP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        TextView tv = new TextView(this);
        tv.setText("text view  wrap");
        tv.setBackgroundColor(Color.GRAY);
        tv.setTextColor(Color.WHITE);
        tv.setLayoutParams(LP_WRAP_WRAP);
        linearLayout.addView(tv);

        TextView tv2 = new TextView(this);
        tv2.setText("text view match");
        tv2.setBackgroundColor(Color.GRAY);
        tv2.setTextColor(Color.WHITE);
        tv2.setLayoutParams(LP_MATCH_WRAP);
        linearLayout.addView(tv2);


        LinearLayout.LayoutParams MARGIN_LAYOUT_PARAMS = new LinearLayout.LayoutParams(LP_MATCH_WRAP);
        MARGIN_LAYOUT_PARAMS.setMargins(30, 30, 30, 30);
        TextView tv3 = new TextView(this);
        tv3.setText("text view + Margin ");
        tv3.setBackgroundColor(Color.GRAY);
        tv3.setTextColor(Color.WHITE);
        tv3.setLayoutParams(MARGIN_LAYOUT_PARAMS);
        linearLayout.addView(tv3);


        LinearLayout.LayoutParams GRAVITY_LAYOUT_PARAMS = new LinearLayout.LayoutParams(LP_WRAP_WRAP);
        GRAVITY_LAYOUT_PARAMS.gravity = Gravity.RIGHT;
        TextView tv4 = new TextView(this);
        tv4.setText("text view + gravity + padding");
        tv4.setBackgroundColor(Color.GRAY);
        tv4.setTextColor(Color.WHITE);
        tv4.setPadding(10,10,10,10);
        tv4.setLayoutParams(GRAVITY_LAYOUT_PARAMS);
        linearLayout.addView(tv4);





    }
}
