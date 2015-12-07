package es.hol.varenik.lesson0122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast toast;
        switch (v.getId()) {

            case R.id.btn1:
                toast = Toast.makeText(this, btn1.getText().toString(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                break;
            case R.id.btn2:
                toast = Toast.makeText(this, R.string.big_tetx, Toast.LENGTH_SHORT);
                LinearLayout toastImage = (LinearLayout) toast.getView();
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                break;
            case R.id.btn3:
                toast = Toast.makeText(this, "default ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.RIGHT, 0, 0);
                LinearLayout imageToast = (LinearLayout) toast.getView();
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.database47);
                imageToast.addView(imageView, 1);
                toast.show();
                break;
            case R.id.btn4:
                toast = Toast.makeText(this, "default ", Toast.LENGTH_SHORT);

                ImageView imageView2 = new ImageView(MainActivity.this);
                imageView2.setImageResource(R.drawable.database47);
                toast.setView(imageView2);
                toast.show();
                break;
        }
    }
}
