package es.hol.varenik.lesson12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3;
    private TextView textView;
    private static final String TAG = "myLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "will find view elements");
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        textView = (TextView) findViewById(R.id.text);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int i;
        switch (v.getId()) {
            case R.id.btn1:
                i  = 6/2;
                textView.setText("6/2 = "+i);

                Log.d(TAG, "click on the "+btn1.getText());
                break;
            case R.id.btn2:
               try {
                   i = 6 / 0;
                   Log.d(TAG, "click on the " + btn1.getText());
               }catch (Exception e){
                   textView.setText("6/0 =" +e);
                   Log.e(TAG, "you are can't divide by 0  ", e);
               }
                break;
            case R.id.btn3:
                textView.setText("Click on the " + btn3.getText());
                Log.d(TAG, "click on the "+btn1.getText());
                break;
        }
    }
}
