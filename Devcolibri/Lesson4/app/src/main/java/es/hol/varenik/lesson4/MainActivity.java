package es.hol.varenik.lesson4;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private   Button btn;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        textView = (TextView) findViewById(R.id.textView);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button: {
                        if (btn.getText().equals(getString(R.string.btn_text_UA))) {
                            textView.setText(R.string.app_name_UA);
                            btn.setText(R.string.btn_text_USA);
                        } else if (btn.getText().equals(getString(R.string.btn_text_USA))) {
                            textView.setText(R.string.app_name);
                            btn.setText(R.string.btn_text_UA);
                        }

                    }
                }
            }
        };




        btn.setOnClickListener(onClickListener);


    }


    public void newSay(View v){
        TextView tvNew = new TextView(this);
        tvNew.setText("this textView created in method newSay");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.addContentView(tvNew, layoutParams);
    }

}
